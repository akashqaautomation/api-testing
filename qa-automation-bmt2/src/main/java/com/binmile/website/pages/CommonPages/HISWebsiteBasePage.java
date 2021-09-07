package com.binmile.website.pages.CommonPages;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.binmile.driver.website.TTWebsiteDriver;
import com.binmile.pages.TTBasePage;
import com.binmile.utils.PropertyFile;
import com.binmile.website.pages.CommonPages.HISWebsiteBasePage;

public class HISWebsiteBasePage extends TTBasePage{
	
	private final By MENU = By.xpath("//i[@class='fa fa-bars']");
	private final By BARS_MENU = By.xpath("(//i[@class='fa fa-bars'])[1]");
	private final By HOME_ICON = By.xpath("//a[contains(text(),'HOME')]");

	

	private static final Logger logger = LogManager
			.getLogger(HISWebsiteBasePage.class.getName());
	
	
	protected TTWebsiteDriver driver;
	public HISWebsiteBasePage(TTWebsiteDriver driver){		
		super(driver);
		this.driver = driver;
	}

	protected PropertyFile propertyFile = new PropertyFile();
	
	
	
	
	public void clickOnMenu() throws InterruptedException {
		try {
		//driver.waitForElementPresent(MENU);
		WebElement clickOnMenu_element = driver.findElement(MENU);
		driver.clickByJS(TTWebsiteDriver.driver, clickOnMenu_element);
		logger.info("Menu Clicked");
		Thread.sleep(2000);
		}
		catch (Exception e) {
		}
	}
	
	public void clickOnHomeIcon() {
		//driver.waitForElementPresent(HOME_ICON);
		driver.clickByJS(TTWebsiteDriver.driver,driver.findElement(HOME_ICON));
		logger.info("HOME ICON Clicked");
	}
	
	public void expandMenu() {
		///driver.waitForElementPresent(BARS_MENU);
		//driver.findElement(BARS_MENU).click();
		driver.clickByJS(TTWebsiteDriver.driver, driver.findElement(BARS_MENU));
		logger.info("Menu Expanded");
	}
	
	public boolean verifyActionMessage(String message) {
		driver.waitForElementToBeVisible(By.xpath("//h6[contains(text(),'"+message+"')]"), 45);
		driver.waitForElementPresent(By.xpath("//h6[contains(text(),'"+message+"')]"));
		if (driver.findElement(By.xpath("//h6[contains(text(),'"+message+"')]")).isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}
	
}

