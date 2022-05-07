package org.example.HW3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FourthTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://zakka.ru/");

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement shopAddress = driver.findElement(By.cssSelector("div.shop-address"));
        shopAddress.click();


        WebElement city = driver.findElement(By.xpath(".//a[@href='/service/contacts/belgorod/']"));
        city.click();

        WebElement workTime = driver.findElement(By.xpath(".//div[@class='worktime']/a"));
        workTime.click();



        driver.quit();
    }
}
