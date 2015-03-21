/**
 * 
 */
package com.fuzzycontrol.common.util;


/**
 * @author Pedro Almir
 * 
 */
public class HttpRequestMultipart {

	/**
	 * Process request and create user with image
	 * 
	 * @param request
	 * @return 
	 * @return complete user
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
//	public static FuzzyAdjModel processRequest(HttpServletRequest request, String owner){
//		FuzzyAdjModel model = new FuzzyAdjModel();
//		String value = "";
//		ServletFileUpload upload = new ServletFileUpload();
//		FileItemIterator iter;
//
//		try {
//			iter = upload.getItemIterator(request);
//
//			while (iter.hasNext()) {
//				FileItemStream fileItem = iter.next();
//				if (fileItem.isFormField()) {
//
//					InputStream stream = fileItem.openStream();
//					byte[] str = new byte[stream.available()];
//					stream.read(str);
//					value = new String(str, "UTF8");
//					
//					if(fileItem.getFieldName().equals("name")){
//						model.setName(value);
//					}else if(fileItem.getFieldName().equals("email")){
//						model.setEmail(value);
//					}else if(fileItem.getFieldName().equals("accuracy")){
//						model.setAccuracy(Float.valueOf(value.replace(",", ".")));
//					}else if(fileItem.getFieldName().equals("sampleSize")){
//						model.setSampleSize(Float.valueOf(value.replace(",", ".")));
//					}else if(fileItem.getFieldName().equals("antNumber")){
//						model.setAntNumber(Integer.valueOf(value.replace(",", ".")));
//					}else if(fileItem.getFieldName().equals("iterations")){
//						model.setIterations(Integer.valueOf(value.replace(",", ".")));
//					}else if(fileItem.getFieldName().equals("alpha")){
//						model.setAlpha(Float.valueOf(value.replace(",", ".")));
//					}else if(fileItem.getFieldName().equals("evaporationRate")){
//						model.setEvaporationRate(Float.valueOf(value.replace(",", ".")));
//					}else if(fileItem.getFieldName().equals("executions")){
//						model.setExecutions(Integer.valueOf(value.replace(",", ".")));
//					}else if(fileItem.getFieldName().equals("outputVariable")){
//						model.setOutputVariable(value.trim());
//					}
//				} else {
//					if(fileItem.getFieldName().equals("fclInputFile")){
//						InputStream fileStream = fileItem.openStream();
//						
//						String fileName = fileItem.getName();
//						String mime = fileItem.getContentType();
//						byte[] byteArray = IOUtils.toByteArray(fileStream);
//						
//						model.setFclFile(byteArray);
//						model.setFclFileName(fileName);
//						model.setFclMimeType(mime);
//					}else if(fileItem.getFieldName().equals("csvInputFile")){
//						InputStream fileStream = fileItem.openStream();
//						
//						String fileName = fileItem.getName();
//						String mime = fileItem.getContentType();
//						byte[] byteArray = IOUtils.toByteArray(fileStream);
//						
//						model.setCsvFile(byteArray);
//						model.setCsvFileName(fileName);
//						model.setCsvMimeType(mime);
//					}
//				}
//			}
//		} catch (FileUploadException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return model;
//	}

}
