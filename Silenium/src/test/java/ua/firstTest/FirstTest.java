package ua.firstTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTest
{
  @Test
  public void firstTest(){
    System.setProperty("webdriver.chrome.driver","D:\\testfolder\\chromedriver.exe");
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.google.com.ua");

    WebElement element;
    element = driver.findElement(By.name("q"));
    element.sendKeys("Википедия");
    element.submit();
    element = driver.findElement(By.xpath("//*[@id=\"rso\"]/div/div/div[1]/div/div/div[1]/a"));
    element.click();
    element = driver.findElement(By.name("search"));
    element.sendKeys("Selenium");
    element.submit();
    element = driver.findElement(By.linkText("Apache License 2.0"));
    String expect = element.getText();
    System.out.println(expect);
    Assert.assertTrue(expect.equals("Apache License 2.0"));

    //driver.quit();

  }
}
