package com.cipl.MobilePages;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestBase {

	public static AndroidDriver<MobileElement> mobiledriver;

	public static AndroidDriver<MobileElement> getMobileDriver() {
		if (mobiledriver != null) {
			return mobiledriver;
		} else {
			mobiledriver = SetDriver();
			return mobiledriver;
		}
	}

	public static AndroidDriver<MobileElement> SetDriver() {
		try {
			File classpathRoot = new File(System.getProperty("user.dir"));
			File app = new File(classpathRoot, getProperty("android.app"));
			DesiredCapabilities Capabilities = new DesiredCapabilities();
			Capabilities.setCapability("platformName", "android");
			Capabilities.setCapability("deviceName", getProperty("android.devicename"));
			Capabilities.setCapability(CapabilityType.VERSION, getProperty("android.version"));
			Capabilities.setCapability("app", app.getAbsolutePath());
			Capabilities.setCapability("appPackage", getProperty("android.AppPackage"));
			Capabilities.setCapability("newCommandTimeout", Integer.parseInt(getProperty("android.newCommandTimeout")));
			Capabilities.setCapability("automationName", "UiAutomator1");
			Capabilities.setCapability("autoAcceptAlerts","true");
			
			mobiledriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4725/wd/hub"), Capabilities);
			mobiledriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			return mobiledriver;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static void pause(int millis) {
		try {
			Thread.sleep(5000);
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

	public static String getProperty(String strKey) {
		InputStream input;
		try {
			input = new FileInputStream("resources//base.properties");
			Properties porperties = new Properties();
			porperties.load(input);

			return porperties.getProperty(strKey);

		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
	}

	public static void WaitForElementPresent(MobileElement element) {
		int timeout = Integer.parseInt(getProperty("timeout"));
		WebDriverWait wait = new WebDriverWait(getMobileDriver(), timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void VerifyPresent(MobileElement element, String strElementName) {
		if (element.isDisplayed() == true) {
			Reporter.log(
					"Expected : " + strElementName + " should be present. Actual : " + strElementName + " is present.");
		} else {
			Reporter.log("Expected : " + strElementName + " should be present. Actual : " + strElementName
					+ " is not present.");
		}
	}
}
