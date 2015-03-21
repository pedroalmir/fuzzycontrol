package com.fuzzycontrol.core.repository.base;


import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.fuzzycontrol.core.model.base.GenericEntity;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;

import static com.fuzzycontrol.core.repository.service.OfyService.ofy;

public class GenericDAO<T extends GenericEntity> {
	/**
	 * number of pages loaded for paging
	 */
	static final Integer NUMBER_OF_PAGES = 10;

	/**
	 * Entity class
	 */
	protected Class<T> entityClass;

	/**
	 * Set entity class
	 * 
	 * @param entityClass
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	/**
	 * @param clazz
	 * @return
	 */
	public Key<T> save(T clazz) {
		/* Save the object */
		return ofy().save().entity(clazz).now();
	}
	
	/**
	 * @param clazz
	 * @return true if all it's OK!
	 */
	public boolean remove(T clazz) {
		try{
			ofy().delete().entity(clazz).now();
			return true;
		}catch(Exception ex){
			return false;
		}
	}

	/**
	 * @param id
	 * @return
	 */
	public boolean purge(Long id) {
		Key<T> key = Key.create(this.entityClass, id);
		ofy().delete().key(key).now();
		return true;
	}

	/**
	 * @param clazz
	 * @return
	 */
	public Key<T> update(T clazz) {
		return save(clazz);
	}

	/**
	 * Id search for all objects not deleted
	 * 
	 * @param id
	 * @return
	 */
	public T findById(Long id) {
		return ofy().load().type(this.entityClass).filter("id", id).first().get();
	}

	/**
	 * Id search for all objects.
	 * 
	 * @param id
	 * @return
	 */
	public T findByIdAll(Long id) {
		Key<T> key = Key.create(entityClass, id);
		return ofy().load().key(key).get();
	}

	/**
	 * @return
	 */
	public List<T> listAll() {
		return ofy().load().type(this.entityClass).list();
	}

	/**
	 * List all with limit
	 * 
	 * @param limit
	 * @return list of entities not deleted
	 */
	public List<T> listAllWithLimit(int limit) {
		return ofy().load().type(this.entityClass).limit(limit).list();
	}

	/**
	 * lists all objects with the included deleted.
	 * 
	 * @return
	 */
	public List<T> listAllWhithDeletes() {
		return ofy().load().type(this.entityClass).list();
	}

	/**
	 * Return a list of Entity found by Ids
	 * 
	 * @param ids
	 * @return
	 */
	public List<T> listByIds(List<Long> ids) {
		return new ArrayList<T>(ofy().load().type(this.entityClass).ids(ids).values());
	}

	/**
	 * Return a list of Entity found by Keys filtering
	 * the objects with deleted=false
	 * 
	 * @param keys
	 * @return list of entity with deleted=false
	 */
	public List<T> listByKeys(Collection<Key<T>> keys) {
		LinkedList<T> resultList = new LinkedList<T>();
		if(keys!=null){
			Collection<T> values = ofy().load().keys(keys).values();
			if(values != null){
				for (T t : values) {
					if (t instanceof GenericEntity) {
						resultList.add(t);
					}
				}
			}
		}
		return resultList;
	}

	/**
	 * Find entity by key
	 * 
	 * @param keys
	 * @return
	 */
	public T findByKey(Key<T> key) {
		return ofy().load().key(key).get();
	}

	/**
	 * Find entity by key with deleted=false
	 * 
	 * @param keys
	 * @return return <code>null</code> if entity is deleted or entity if it's not deleted.
	 */
	public T findByKeyWithoutNonDeleted(Key<T> key) {
		T t = ofy().load().key(key).get();
		return t;
	}

	/**
	 * Gets the last object added to the database.
	 */
	public T last() {
		Query<T> query = ofy().load().type(this.entityClass);
		return query.order("-id").first().get();

	}
}
