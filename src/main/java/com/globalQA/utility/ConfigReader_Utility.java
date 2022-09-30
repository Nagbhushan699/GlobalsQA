package com.globalQA.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader_Utility {
	Properties prop;
static String path=System.getProperty("user.dir");
static String fullpath=path+File.separator+"\\src\\test\\resources"+File.separator+"Properties.properties";
public static Properties readProperties() throws IOException {
	FileReader file=new FileReader(fullpath);
	Properties prop=new Properties();
	prop.load(file);
	return prop;
}
}
