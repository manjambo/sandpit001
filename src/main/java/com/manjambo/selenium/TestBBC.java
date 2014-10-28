package com.manjambo.selenium;

 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
 
public class TestBBC extends TestBase{
 
  @Test(description="Performs a search", groups ={"search","full"})
    public void testLink()throws Exception{
        getDriver().get("http://www.bbc.co.uk");
        WebElement textBox = getDriver().findElement(By.xpath("//input[@id='orb-search-q']"));
        textBox.click();
        textBox.sendKeys("Just a test!");
        Thread.sleep(2000);
    }
}