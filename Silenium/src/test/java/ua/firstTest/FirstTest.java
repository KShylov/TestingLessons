package ua.firstTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FirstTest
{
  WebDriver driver;
  private static final String START_URL = "https://www.google.com.ua";
  private static final String GOOGLE_SEARCH = "q";
  private static final String FIRST_LINK = "//*[@id=\"rso\"]/div/div/div[1]/div/div/div[1]/a";
  private static final String WIKIPEDIA_SEARCH = "search";
  @BeforeTest
  public void beforeFirstTest(){
    System.setProperty("webdriver.chrome.driver","D:\\testfolder\\chromedriver.exe");
    driver = new ChromeDriver();
  }
  @Test
  public void firstTest(){
    driver.get(START_URL);
    WebElement element;
    element = driver.findElement(By.name(GOOGLE_SEARCH));
    element.sendKeys("Википедия");
    element.submit();

    element = driver.findElement(By.xpath(FIRST_LINK));
    element.click();

    assertTrue(driver.getCurrentUrl().contains("https://ru.wikipedia.org"));

    element = driver.findElement(By.name(WIKIPEDIA_SEARCH));
    element.sendKeys("Selenium");
    element.submit();

    element = driver.findElement(By.linkText("Apache License 2.0"));
    String expect = element.getText();
    assertTrue(expect.equals("Apache License 2.0"));
  }
  @AfterTest
  public void afterFirstTest(){
    driver.quit();
  }
}
