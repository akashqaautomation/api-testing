package com.binmile.test.login_test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.binmile.test.base.ResultListener;
import com.binmile.test.website.TTWebsiteBaseTest;
import com.binmile.website.pages.CommonPages.KYC_home_page;
@Listeners(ResultListener.class)
public class KYC_Login extends TTWebsiteBaseTest
{
	private static final Logger logger = LogManager
			.getLogger(KYC_Login.class.getName());
	KYC_home_page home_page =new KYC_home_page(driver);
	@Test
	public void Login_test()
	{
		test=extent.createTest("KYC login", "This test case verify the funcationlaity of login");
		test.assignCategory("login");
		home_page.login(test);
	}
	

}
