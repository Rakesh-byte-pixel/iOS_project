package com.pCloudy.testNG;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Runner {
	
	AppiumDriverLocalService service;
	AppiumDriver<WebElement> driver;
	String folder_name;
	DateFormat df;
	
	@BeforeTest
	public void setUpSuite() throws Exception {
}
		

	@BeforeMethod
	public void prepareTest() throws IOException, InterruptedException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("pCloudy_Username", "smruti.panda@opkey.com");
		capabilities.setCapability("pCloudy_ApiKey", "yjgh444nytc5wjqs2f5s3my2");
		capabilities.setCapability("pCloudy_DurationInMinutes", 10);
		capabilities.setCapability("newCommandTimeout", 600);
		capabilities.setCapability("launchTimeout", 90000);
		capabilities.setCapability("pCloudy_DeviceFullName", "APPLE_iPhone7_iOS_15.7.3_77fe9");
		capabilities.setCapability("platformVersion", "15.7.3");
		capabilities.setCapability("platformName", "ios");
		capabilities.setCapability("acceptAlerts", true);
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("pCloudy_ApplicationName", "TestmunkDemo_Resigned1688039726.ipa");
		capabilities.setCapability("bundleId", "com.pcloudy.TestmunkDemo");
		capabilities.setCapability("project", "test");
		capabilities.setCapability("build", "best");
		capabilities.setCapability("name", "pro");
		capabilities.setCapability("tag", "old");
		capabilities.setCapability("pCloudy_WildNet", "false");
		capabilities.setCapability("pCloudy_EnableVideo", "true");
		capabilities.setCapability("pCloudy_EnablePerformanceData", "true");
		capabilities.setCapability("pCloudy_EnableDeviceLogs", "true");
		capabilities.setCapability("appiumVersion", "1.21.0");
		IOSDriver<WebElement> driver = new IOSDriver<WebElement>(new URL("https://ind-west.pcloudy.com/appiumcloud/wd/hub"), capabilities);
		}
	

	@Test// (invocationCount=)
	public void Test1() throws IOException, InterruptedException {
		
		//Enter email-id
		driver.findElement(By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]")).sendKeys("test@testname.com");
		captureScreenShots();
		
		//Enter Password		
		driver.findElement(By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField[1]")).sendKeys("testmunk");
		captureScreenShots();
		
		//Click on login button	
		driver.findElement(By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]")).click();
		captureScreenShots();
	}

	
	 @AfterMethod 
	 public void endTest() throws IOException {
		 
	  
	  driver.quit(); 
	  }
	 

	
	public void captureScreenShots() throws IOException {
        folder_name="screenshot";
        File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Date format for screenshot file name
        df=new  SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        //create dir with given folder name
        new File(folder_name).mkdir();
        //Setting file name
        String file_name=df.format(new Date())+".png";
        //copy screenshot file into screenshot folder.
        FileUtils.copyFile(f, new File(folder_name + "/" + file_name));
    }
}
