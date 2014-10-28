package com.manjambo.selenium;
/**
 *************************************************************************************
 * Project Name - parallel
 * 
 ************************************************************************************* *************************************************************************************
 */

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

  protected ThreadLocal<RemoteWebDriver> threadDriver = null;

  @BeforeMethod(groups ={"search","full"})
  public void setUp() throws MalformedURLException {

    threadDriver = new ThreadLocal<RemoteWebDriver>();
    threadDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),  setUpChrome()));
  }

  /**
   * Description: Set up a Chrome Driver
   * 
   * @return
   */
  private DesiredCapabilities setUpChrome() {
    DesiredCapabilities dc = DesiredCapabilities.chrome();
    dc.setPlatform(org.openqa.selenium.Platform.WINDOWS);
    dc.setBrowserName(DesiredCapabilities.chrome().getBrowserName());

    return dc;
  }

  /**
   * Description: Set up a Firefox Driver
   * 
   * @return
   */
  private DesiredCapabilities setUpFireFox() {
    DesiredCapabilities dc = new DesiredCapabilities();
    FirefoxProfile fp = new FirefoxProfile();
    dc.setCapability(FirefoxDriver.PROFILE, fp);
    dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName());

    return dc;
  }

  public WebDriver getDriver() {
    return threadDriver.get();
  }

  @AfterMethod
  public void closeBrowser() {
    getDriver().quit();

  }
}
