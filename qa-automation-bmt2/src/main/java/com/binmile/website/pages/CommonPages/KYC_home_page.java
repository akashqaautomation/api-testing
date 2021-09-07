package com.binmile.website.pages.CommonPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.binmile.driver.website.TTWebsiteDriver;

public class KYC_home_page extends HISWebsiteBasePage {

	public KYC_home_page(TTWebsiteDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private static final Logger logger = LogManager.getLogger(KYC_home_page.class.getName());
	public void login(ExtentTest test) {
		
		
		logger.info("User has been logged in to KYC  Portal");
		Markup m1=MarkupHelper.createLabel("User has been logged in to KYC  Portal", ExtentColor.GREEN);
		test.info(m1);
	}

}
