/**
 * 
 */
package com.fuzzycontrol.common.handler;

import com.google.appengine.api.utils.SystemProperty;

/**
 * @author Pedro Almir
 */
public class View {
	
	public static final String APP_ID = SystemProperty.applicationId.get();
	
	/** */
	public static final String INDEX_JSP = "/index.jsp";
	public static final String INDEX = "/";
	/** */
	public static final String LOGIN_JSP = "/views/login/login.jsp";
	public static final String LOGIN = "/login";
	/** */
	public static final String NEW_FUZZY_ADJS_JSP = "/views/fuzzy/adjs.jsp";
	public static final String QUESTION_URL = "http://" + APP_ID + ".appspot.com/questions?id=%s";
	/** */
	public static final String QUESTION_JSP = "/views/question/list.jsp";
	/** */
	public static final String RESULT_JSP = "/views/result/list.jsp";
	/** */
	public static final String CREATE_FCL_JSP = "/views/fuzzy/createFCL.jsp";
}
