package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigrationReader {

	private ConfigrationReader() {
	}

	private static FileInputStream fis;

	public static Properties initProperties() {
		Properties properties = new Properties();

		try {
			fis = new FileInputStream(new File(".\\src\\test\\resources\\config.properties"));
			properties.load(fis);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
			}
		}
		return properties;
	}
}
