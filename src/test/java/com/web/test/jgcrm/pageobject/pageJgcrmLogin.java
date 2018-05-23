package com.web.test.jgcrm.pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.test.common.framework.testData;



public class pageJgcrmLogin implements PageBase {
	
	public testData data;
	
	@FindBy(id = "Login")
	WebElement inputName;
	
	@FindBy(id = "Password")
	WebElement inputPassWord;
	
	@FindBy(xpath = "//a[@class='btn btn-lg btn-info btn-block']")
	WebElement loginButton;
	By locator=By.xpath("//a[@class='btn btn-lg btn-info btn-block']");
	
    public pageJgcrmLogin(testData data) {
    	this.data=data;
    	PageFactory.initElements(data.driver, this);
    }
    
	public void verifyOnTheCurrentPage(String title) {
		Assert.assertEquals(title,data.driver.getTitle());	
	}
	
	public void go() {
		data.driver.get("http:");
		data.waitForLoadPage(data.driver);
		
	}
	
	public void inputUserNamePassWord(String name,String passw) {
		inputName.clear();
		inputName.sendKeys(name);
		inputPassWord.clear();
		inputPassWord.sendKeys(passw);
		
	}
	
	public void clickLoginButton() {
		data.waitForClick(locator);
		loginButton.click();
	}

}
