package org.example.HW3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FirstTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://zakka.ru/");

        WebElement loginButton = driver.findElement(By.xpath(".//a[@data-fancybox='login-popap']"));
        loginButton.click();

        WebElement login = driver.findElement(By.xpath(".//input[@id='USER_LOGIN']"));
        login.click();
        login.sendKeys("teststepank0@yandex.ru");

        WebElement password = driver.findElement(By.xpath(".//input[@id='USER_PASSWORD']"));
        password.click();
        password.sendKeys("teststepanko");

        WebElement enter = driver.findElement(By.cssSelector("input.submit"));
        enter.click();

        Thread.sleep(6000l);

//        WebElement inputButton = (new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//i[@class='fas fa-search']"))));

        WebElement inputButton = driver.findElement(By.xpath(".//i[@class='fas fa-search']"));
        inputButton.click();

        WebElement inputFinder = driver.findElement(By.xpath(".//input[@id='title-search-input']"));
        inputFinder.click();
        inputFinder.sendKeys("Ручка шариковая Glance");
        inputFinder.sendKeys(Keys.ENTER);

        WebElement cardItem = driver.findElement(By.cssSelector("div.section-item-wrap"));
        cardItem.click();

        WebElement addCart = driver.findElement(By.xpath(".//i[@class='fas fa-shopping-basket']"));
        addCart.click();

        WebElement placeAnOder = driver.findElement(By.xpath(".//a[@class='default-btn cl']"));
        placeAnOder.click();

        WebElement scrollUp = driver.findElement(By.cssSelector("div.page-up.show"));
        scrollUp.click();

        driver.quit();


    }
}
