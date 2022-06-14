package org.example.HW3_selenium1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ThirdTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://zakka.ru/");

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));

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
            Thread.sleep(4000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        WebElement inputButton = driver.findElement(By.xpath(".//i[@class='fas fa-search']"));
        inputButton.click();

        WebElement inputFinder = driver.findElement(By.xpath(".//input[@id='title-search-input']"));
        inputFinder.click();
        inputFinder.sendKeys("Калькулятор Candy love | blue");
        inputFinder.sendKeys(Keys.ENTER);

        WebElement addItem = driver.findElement(By.xpath(".//div[@data-item='66906']"));
        addItem.click();

        WebElement addCart = driver.findElement(By.xpath(".//i[@class='fas fa-shopping-basket']"));
        addCart.click();

        WebElement placeAnOder = driver.findElement(By.xpath(".//a[@class='default-btn cl']"));
        placeAnOder.click();

        WebElement scrollUp = driver.findElement(By.cssSelector("div.page-up.show"));
        scrollUp.click();


        try {
            Thread.sleep(4000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement remove = driver.findElement(By.xpath(".//a[@data-a1='TR-CB03840-4']"));
        remove.click();


        WebElement secondScrollUp = driver.findElement(By.cssSelector("div.page-up.show"));
        secondScrollUp.click();

        driver.quit();

    }
}
