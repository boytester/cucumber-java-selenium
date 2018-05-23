package com.web.test.common.framework;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.web.test.jgcrm.pageobject.pageJgcrmLogin;

public class testData {
	
	public String browserType = "chrome";
	public int waitTime = 60;
	
	public WebDriver driver;
	public pageJgcrmLogin jgcrmLoginPage;
	
	public void initTestData() {
		
		initBrowser();
		
//		init page object
		jgcrmLoginPage=new pageJgcrmLogin(this);
		
	}
	
	public void initBrowser() {
		setBrowserPath();
		setUpbrowser(browserType);
	}
	
	public void setBrowserPath() {
		if(System.getProperty("os.name").equalsIgnoreCase("Windows 7")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"library"+File.separator+"chromedriver.exe");
		}
	}
	
	public void setUpbrowser(String browserName) {
		String name=browserName.toLowerCase();
		switch(name){
		case "chrome":
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
	}
	
	public void quit() {
		driver.quit();
	}
	
//	selenium Common operations encapsulation
	
    public void waitForLoadPage(WebDriver driver) {
    	WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(isPageLoaded());
    }
    
    protected Function<WebDriver, Boolean> isPageLoaded() {
        return new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
    }
    
    public void waitForClick(By locator) {
    	WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
