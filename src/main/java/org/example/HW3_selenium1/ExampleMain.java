package org.example.HW3_selenium1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExampleMain {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");

        WebElement webElement1 = driver.findElement(By.name("q"));
        WebElement webElement2 = driver.findElement(By.xpath(".//input[@name='q']"));

//        try {
//            WebElement webElement3 = driver.findElement(By.name("error"));
//        } catch (NoSuchFieldException e){
//            System.out.println(e);
//        }

        List<WebElement> webElements = driver.findElements(By.name("error"));
        if (webElements.size()>1){
            // todo
        }

        webElement1.click();
        webElement1.sendKeys("Поиск");

        WebElement webElement4 = driver.findElement(By.cssSelector("gb_1 gb_2 gb_9d gb_9c"));

        webElement4.click();

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlContains("google"));
//        Thread.sleep(10000l);

        driver.navigate().to("https://www.google.com/");




//        driver.quit(); потом раскоментируй !!!!!!


    }
}
