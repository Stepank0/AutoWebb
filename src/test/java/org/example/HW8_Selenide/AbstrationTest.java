package org.example.HW8_Selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public abstract class AbstrationTest {

    private static EventFiringWebDriver eventDriver;

    static Logger logger = LoggerFactory.getLogger(org.example.HW8_Selenide.AbstrationTest.class);

    @BeforeAll
    static void  setDriver(){
        closeWebDriver();
        Configuration.baseUrl = "https://allithave.ru";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

    }

    @BeforeEach
    @Step("Переход на главную страницу")
    void getStartPage(){
        logger.info("Переход на стартовую страницу");

        open("/");    }

    @AfterEach
    public void checkBrowser() throws IOException {
        screenshot();
    }


    @AfterAll
    public static void exit(){
        logger.info("Закрытие браузера. Все ТК выполнены.");
        if(eventDriver !=null) eventDriver.quit();

    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return screenshot == null ? null : Files.toByteArray(screenshot);
    }

    public WebDriver getWebDriver() { return this.eventDriver; }


}
