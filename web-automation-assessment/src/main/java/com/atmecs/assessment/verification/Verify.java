package com.atmecs.assessment.verification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

	/**
	 * This class contains assertion methods
	 * @author Sandhya.Kadiyala
	 *
	 */
	public class Verify {
		
		private static final Logger logger = LogManager.getLogger(Verify.class);
	    /**
	     * This method helps in string assertion of actualText and expectedText
	     *
	     * @param actualText
	     * @param expectedText
	     * @return Returns verification status as true when assertion is pass or false otherwise
	     */
	    public static boolean verifyString(String actualText, String expectedText, String verificationStepMessage) {
	        logger.info( verificationStepMessage);
	        boolean status = false;
	        try {
	            Assert.assertEquals(actualText, expectedText);
	            status = true;
	            logger.info("Actual Result :: " + expectedText + " == " + " Expected Result :: " + actualText);
	        } catch (AssertionError assertionError) {
	        	logger.error("Actual Result :: " + expectedText + " == " + " Expected Result :: " + actualText);
	        }
	        return status;
	    }

	    /**
	     * This method helps in string assertion of actualText and expectedText
	     *
	     * @param actualText
	     * @param expectedText
	     * @return Returns verification status as true when assertion is pass or false otherwise
	     */
	    public static boolean verifyStringAndStopTest(String actualText, String expectedText, String verificationStepMessage) {
	    	 logger.info(verificationStepMessage);
	        boolean status = false;
	        try {
	            Assert.assertEquals(actualText, expectedText);
	            status = true;
	            logger.info("Actual Result :: " + expectedText + " == " + " Expected Result :: " + actualText);
	        } catch (AssertionError assertionError) {
	        	logger.error("Actual Result :: " + expectedText + " == " + " Expected Result :: " + actualText);
	            Assert.fail(verificationStepMessage);
	        }
	        return status;
	    }

	    /**
	     * This method helps in boolean assertion of actual and expected values
	     *
	     * @param actual
	     * @param expected
	     * @return Returns verification status as true when assertion is pass or false otherwise
	     */
	    public static boolean verifyBoolean(boolean actual, boolean expected, String verificationStepMessage) {
	    	logger.info(verificationStepMessage);
	        boolean status = false;
	        try {
	            Assert.assertEquals(actual, expected);
	            status = true;
	            logger.info("Actual Result :: " + actual + " == " + " Expected Result :: " + expected);
	        } catch (AssertionError assertionError) {
	        	 logger.error("Actual Result :: " + actual + " == " + " Expected Result :: " + expected);
	        }
	        return status;
	    }

	    /**
	     * This method helps in integer assertion of actual and expected values
	     *
	     * @param actual
	     * @param expected
	     * @return Returns verification status as true when assertion is pass or false otherwise
	     */
	    public static boolean verifyInteger(int actual, int expected, String verificationStepMessage) {
	    	logger.info(verificationStepMessage);
	        boolean status = false;
	        try {
	            Assert.assertEquals(actual, expected);
	            status = true;
	            logger.info("Actual Result :: " + actual + " == " + " Expected Result :: " + expected);
	        } catch (AssertionError assertionError) {
	        	logger.error("Actual Result :: " + actual + " == " + " Expected Result :: " + expected);
	        }
	        return status;
	    }
	    public static boolean verifyStringAndStopTest(boolean actual, boolean expected, String verificationStepMessage) {
	    	 logger.info(verificationStepMessage);
	        boolean status = false;
	        try {
	            Assert.assertEquals(actual,expected);
	            status = true;
	            logger.info("Actual Result :: " + actual + " == " + " Expected Result :: " + expected);
	        } catch (AssertionError assertionError) {
	        	logger.error("Actual Result :: " + actual + " == " + " Expected Result :: " + expected);
	            Assert.fail(verificationStepMessage);
	        }
	        return status;
	    }
	}



