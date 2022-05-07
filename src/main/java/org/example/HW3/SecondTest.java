package org.example.HW3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SecondTest {

    public static void main(String[] args) {

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

        try {
            Thread.sleep(6000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement inputButton = driver.findElement(By.xpath(".//i[@class='fas fa-search']"));
        inputButton.click();

        WebElement inputFinder = driver.findElement(By.xpath(".//input[@id='title-search-input']"));
        inputFinder.click();
        inputFinder.sendKeys("Калькулятор Candy love");
        inputFinder.sendKeys(Keys.ENTER);

        WebElement item = driver.findElement(By.cssSelector("div.section-item-wrap"));
        item.click();

        WebElement favourites = driver.findElement(By.xpath(".//a[@href='#']/i[@class='far fa-heart']"));
        favourites.click();

        WebElement iconClose = driver.findElement(By.cssSelector("button.fancybox-button.fancybox-close-small"));
        iconClose.click();

        WebElement iconFavorites = driver.findElement(By.xpath(".//i[@class='far fa-heart']/span[@class='count']"));
        iconFavorites.click();

        driver.quit();


    }
}
