package com.binmile.listners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.binmile.driver.website.TTWebsiteDriver;
import com.binmile.pages.TTBasePage;


/**
 * @author PranavPasricha TestListner is the listener class that listens to test
 *         case execution and allows Engineer to complete post test operations.
 *
 */
 
public class TestListner extends TestListenerAdapter{

	private static final Logger logger = LogManager.getLogger(TestListner.class
			.getName());
	
	TTWebsiteDriver object=new TTWebsiteDriver(null);
	
	

	@Override
	public void onTestStart(ITestResult tr) {
		logger.info("\n******************************************************************************************************************************"+
				"\n\t\t\t\t\tTEST CASE NAME:                  "+ tr.getMethod().getMethodName()+
				"\n******************************************************************************************************************************");
	}
	
	@Override
	public void onTestSuccess(ITestResult tr) {
		logger.info("[TEST IS SUCCESSFUL -------- Test case " + tr.getMethod().getMethodName()+ " has passed]");
		//object.Closebrowser();
		
	}
	
	@Override
	public void onTestFailure(ITestResult tr) {
		logger.info("Test has failed with TestResult status = "+tr.getStatus());
		if (tr.getStatus() == ITestResult.FAILURE){
			logger.info("[TEST HAS FAILED-------- Test case " + tr.getMethod().getMethodName()+" has failed]. The reason is "+tr.getThrowable());
			try {
				//TTWebsiteDriver.takeSnapShotAndRetPath(TTWebsiteDriver.driver, tr.getMethod().getMethodName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	}
	
	@Override
	public void onTestSkipped(ITestResult tr) {
		logger.info("[TEST IS SKIPPED -------- Test case " + tr.getMethod().getMethodName()	+ " skipped]");
	}
}
