/**
 * 
 */
package com.fuzzycontrol.common.util;


import java.io.BufferedReader;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import com.google.appengine.api.files.AppEngineFile;
import com.google.appengine.api.files.FileReadChannel;
import com.google.appengine.api.files.FileService;
import com.google.appengine.api.files.FileServiceFactory;
import com.google.appengine.api.files.FileWriteChannel;
import com.google.appengine.api.files.GSFileOptions.GSFileOptionsBuilder;

/**
 * @author Pedro Almir
 * 
 */
@SuppressWarnings("deprecation")
public class GoogleStorageService {

	public static final String BUCKET_NAME = "fuzzy_bucket";
	public static final String BASE_PATH = "https://storage.cloud.google.com/fuzzy_bucket/";
	/** */
	private FileWriteChannel writeChannel = null;
	/** */
	private FileService fileService = FileServiceFactory.getFileService();
	/** */
	private OutputStream os = null;
	/** */
	private static final Logger log = Logger.getLogger(GoogleStorageService.class.getName());
	
	/**
	 * @param fileName
	 * @param mime
	 * @param owner
	 * @param b
	 * @param length
	 * @return
	 */
	public String saveFileInStorage(String fileName, String mime, String owner, byte[] b, int length){
		try{
			log.info("Storage service:init() method:  file name:" + fileName + " and mime:" + mime);
			System.out.println("Storage service:init() method:  file name:" + fileName + " and mime:" + mime);
			
			GSFileOptionsBuilder optionsBuilder = new GSFileOptionsBuilder().setBucket(BUCKET_NAME)
					.setKey(fileName).setAcl("public_read").setMimeType(mime);
					
			AppEngineFile writableFile = fileService.createNewGSFile(optionsBuilder.build());
			
			/* Open a channel to write to it */
			boolean lock = true;
			
			FileWriteChannel writeChannel = fileService.openWriteChannel(writableFile, lock);
			OutputStream os = Channels.newOutputStream(writeChannel);
			
			os.write(b, 0, length);
			os.flush();
			
			log.info("Storage service: destroy() method");
			System.out.println("Storage service: destroy() method");
			
			os.close();
			writeChannel.closeFinally();
			
			return BASE_PATH + fileName;
		}catch(Exception ex){
			ex.printStackTrace();
			log.severe(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * @param fileName
	 * @param mime
	 * @throws Exception
	 */
	public String init(String fileName, String mime, String owner) throws Exception {
		try{
			log.info("Storage service:init() method:  file name:" + fileName + " and mime:" + mime);
			
			/* Data formatter */
			SimpleDateFormat formatData = new SimpleDateFormat("yyyyMMddHHmmss");
			@SuppressWarnings("unused")
			String date = formatData.format(new Date());
			
			GSFileOptionsBuilder optionsBuilder = new GSFileOptionsBuilder().setBucket(BUCKET_NAME).setKey(fileName).setAcl("public-read");
					/*.addUserMetadata("date-created", date)
					.addUserMetadata("owner", owner);*/
			
			AppEngineFile writableFile = fileService.createNewGSFile(optionsBuilder.build());
			
			log.info("writableFile");
			
			/* Open a channel to write to it */
			boolean lock = true;
			
			writeChannel = fileService.openWriteChannel(writableFile, lock);
			os = Channels.newOutputStream(writeChannel);
			
			return BASE_PATH + fileName;
		}catch(Exception ex){
			ex.printStackTrace();
			log.severe(ex.getMessage());
		}
		return null;
	}
	
	/**
	 * @param b
	 * @param length
	 * @throws Exception
	 */
	public void storeFile(byte[] b, int length) throws Exception {
		os.write(b, 0, length);
		os.flush();
	}

	/**
	 * Only to read uploaded text files
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public String readTextFileOnly(String fileName) throws Exception {
		log.info("Reading the txt file from google cloud storage...........");
		String filename = "/gs/" + BUCKET_NAME + "/" + fileName;
		
		AppEngineFile readableFile = new AppEngineFile(filename);
		FileReadChannel readChannel = fileService.openReadChannel(readableFile, false);
		BufferedReader reader = new BufferedReader(Channels.newReader(readChannel, "UTF8"));
		String line = reader.readLine();
		readChannel.close();
		
		return line;
	}

	/**
	 * @throws Exception
	 */
	public void destroy() throws Exception {
		log.info("Storage service: destroy() method");
		os.close();
		writeChannel.closeFinally();
	}

}
