package com.binmile.website.pages.CommonPages;


import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.Logger;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.binmile.driver.website.TTWebsiteDriver;

public class Admin_Asego_home_page extends HISWebsiteBasePage
{
	private static final Logger logger = LogManager.getLogger(Admin_Asego_home_page.class.getName());

	private static final By USERNAME = By.id("username");
	private static final By PASSWORD = By.id("login_password");
	//private static final By YES_BTN_LOGIN_ALERT = null;

	private static final By LOGIN_BTN = By.xpath("//button[text()='Login']");

	private static final By USER_ICON_ON_TOPRIGHT = By.xpath("//*[@id=\"root\"]/div[1]/nav/div/ul/li[6]/a/div[2]/img");

	private static final By LOGOUT_BUTTON = By.xpath("//span[text()='Logout']");

	private By insurance_module=By.xpath("//*[contains(text(),'Insurance Provider Management')]/..");

	private By insurance_provider_link=By.xpath("(//span[contains(text(),'Insurance Provider')])[2]");

	
	public Admin_Asego_home_page(TTWebsiteDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void loginToAdimn(ExtentTest test) throws InterruptedException {
//		try {
//			WebElement advanced_btn = driver.findElement(By.xpath("//button[@id='details-button']"));
//			driver.clickByJS(TTWebsiteDriver.driver, advanced_btn);
//			driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
//		}
		//catch (Exception e) {}
		driver.findElement(USERNAME).sendKeys(propertyFile.getProperty("userName"));
		driver.findElement(PASSWORD).sendKeys(propertyFile.getProperty("password"));

		driver.clickByJS(TTWebsiteDriver.driver, driver.findElement(LOGIN_BTN));

		try {
			//driver.clickByJS(TTWebsiteDriver.driver, driver.findElement(YES_BTN_LOGIN_ALERT));
		} catch (Exception e) {
			e.printStackTrace();}
	

		logger.info("User has been logged in to Asego Admin Portal");
		Markup m1=MarkupHelper.createLabel("User has been logged in to Asego Admin Portal", ExtentColor.GREEN);
		test.info(m1);
	}
	public void logOutFromAdminApplication(ExtentTest test) {
		//WebElement element = driver.findElement(USER_ICON_ON_TOPRIGHT);
		driver.clickByJS(TTWebsiteDriver.driver, driver.findElement(USER_ICON_ON_TOPRIGHT));
		//Actions action = new Actions(TTWebsiteDriver.driver);
		//action.moveToElement(element).build().perform();
		driver.waitForElementPresent(LOGOUT_BUTTON);
		driver.click(LOGOUT_BUTTON);
		logger.info("User has been logged Out From  Asego Admin  Portal");
		Markup m1=MarkupHelper.createLabel("User has been logged in to Asego Admin Portal", ExtentColor.GREEN);
		test.info(m1);
	}
	public boolean verifyClientLogoisDisplayed(){
		logger.info("Client Logo is Displayed");
		return driver.isElementPresent(By.xpath("//img[@class='mt-0']"));
	}
	public void click_on_menu_bar(ExtentTest test,String value)
	{
		WebElement master_text=driver.findElement(By.xpath("//*[contains(text(),'"+value+"')]"));
		driver.clickByJS(TTWebsiteDriver.driver,master_text);
		logger.info("User has been clicked on "+value+" link");
		Markup m1=MarkupHelper.createLabel("User has been clicked on "+value+" manue", ExtentColor.GREEN);
		test.info(m1);
		
	}
	public void click_on_sub_menu_bar(ExtentTest test,String value)
	{
		WebElement Sub_heading=driver.findElement(By.xpath("//*[contains(text(),'"+value+"')]"));
		driver.clickByJS(TTWebsiteDriver.driver, Sub_heading);
		logger.info("User has been clicked on "+value+" link");
		Markup m1=MarkupHelper.createLabel("User has been clicked on "+value+" manue", ExtentColor.GREEN);
		test.info(m1);
	}
	public void clickoninsurancemodule(ExtentTest test)
	{
		driver.clickByJS(TTWebsiteDriver.driver,driver.findElement(insurance_module));
		logger.info("User has been clicked on insurance module");
		Markup m1=MarkupHelper.createLabel("User has been clicked on insurance module", ExtentColor.GREEN);
		test.info(m1);
	}
	public void click_on_insurance_provider_menu(ExtentTest test)
	{
		driver.clickByJS(TTWebsiteDriver.driver,driver.findElement(insurance_provider_link));
		logger.info("User has been clicked on insurance provider");
		Markup m1=MarkupHelper.createLabel("User has been clicked on insurance provider", ExtentColor.GREEN);
		test.info(m1);
	}
	public void click_on_policy(ExtentTest test, String string) {
		driver.clickByJS(TTWebsiteDriver.driver,driver.findElement(By.xpath("(//span[contains(text(),'Policy')])[2]")));
		logger.info("User has been clicked on policy link");
		Markup m1=MarkupHelper.createLabel("User has been clicked on policy link", ExtentColor.GREEN);
		test.info(m1);
		
	}
	
	
	
	

}
