package com.manjambo.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestStackOverflow extends TestBase {

  @Test(description="Performs a search", groups ={"search","full"})
  public void testLink() throws Exception {
    getDriver().get("http://www.stackoverflow.com");
    WebElement textBox = getDriver().findElement(By.xpath("//input[@name='q']"));
    textBox.click();
    textBox.sendKeys("Just another test!");
    Thread.sleep(2000);
  }
}