package com.atmecs.assessment.constants;

import java.io.File;

public class FilePathConstants {
	 public static final String USER_DIR_PATH = System.getProperty("user.dir");
	    public static final String RESOURCES_PATH = USER_DIR_PATH + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator;
	    public static final String LOCATOR_HOME = RESOURCES_PATH + "locators" + File.separator;
	    public static final String TEST_DATA_PATH =RESOURCES_PATH + "testdata" + File.separator;
	    
	 public static final String SWAGLABS_LOCATOR_FILE_PATH = FilePathConstants.LOCATOR_HOME+"swaglabs.properties";
	 public static final String CHECKOUT_PAGE_LOCATOR_FILE_PATH = FilePathConstants.LOCATOR_HOME+"checkout_page.properties";
	 public static final String LOGIN_PAGE_LOCATOR_FILE_PATH = FilePathConstants.LOCATOR_HOME+"login_page.properties";
	 public static final String MENU_PAGE_LOCATOR_FILE_PATH = FilePathConstants.LOCATOR_HOME+"menu_page.properties";
	 public static final String PRODUCT_HOMEPAGE_LOCATOR_FILE_PATH = FilePathConstants.LOCATOR_HOME+"product_homepage.properties";
	 public static final String YOUR_CART_PAGE_LOCATOR_FILE_PATH = FilePathConstants.LOCATOR_HOME+"your_cart_page.properties";
	 
	 public static final String EXTENT_REPORT_PATH = USER_DIR_PATH + "/test-output/ExtentReport.html";
	 public static final String CONFIG_FILE_PATH = TEST_DATA_PATH +"config.properties";
	
	 public static final String DOWNLOADS_FOLDER_PATH = RESOURCES_PATH + "downloads";
	
}
