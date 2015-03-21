package com.fuzzycontrol.common.util;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.MissingResourceException;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.ResourceNotFoundException;

/**
 * Velocity Engine Util class
 * 
 * @author EasyTeam, created by Pedro Almir
 *
 */
public class VelocityEngineUtil {
	
	/**
	 * Get velocity template
	 * 
	 * @param params
	 * @param template
	 * @return the content
	 */
	public static String getTemplate(Map<String, Object> params, String template) {
		try {
			InputStream templateFile = VelocityEngineUtil.class.getResourceAsStream(template);
			
			StringBuilder builder = new StringBuilder();
			int i = 0;
			while ((i = templateFile.read()) != -1) {
				builder.append((char)i);
			}
			templateFile.close();

			VelocityContext context = new VelocityContext();
			for (Entry<String, Object> entry : params.entrySet()) {
				context.put(entry.getKey(), entry.getValue());
			}

			StringWriter writer = new StringWriter();
			Velocity.evaluate(context, writer, "LOG", builder.toString());

			return writer.toString();
		}catch (NullPointerException nPE){
			//npE.printStackTrace();
		}catch (ResourceNotFoundException rNFE){
			//rNFE.printStackTrace();
		}catch (MissingResourceException mRE){
			//rNFE.printStackTrace();
		}catch (Exception e) {
			//e.printStackTrace();
		}
		return "";
	}
}
