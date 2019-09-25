package com.employeeaudit.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.employeeaudit.dto.Headers;

/**
 * @author 45228
 * This is to retrieve the header fields.
 */
public class HeadersDaoImpl {
	/**
	 * @param path is to specify the file path of headers.txt
	 * @return
	 */
	public Headers getHeaders(String path) {
		Headers properties = new Headers();
		
		try {
			InputStream input = new FileInputStream(path);
            Properties prop = new Properties();

            prop.load(input);

            properties.setHeader1(prop.getProperty("header1"));
            properties.setHeader2(prop.getProperty("header2"));
            properties.setHeader3(prop.getProperty("header3"));
            properties.setHeader4(prop.getProperty("header4"));

        } catch (IOException ex) {
        	System.out.println("Headers file not available");
            ex.printStackTrace();
        }
		
		return properties;
	}
}
