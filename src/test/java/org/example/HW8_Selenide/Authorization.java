package org.example.HW8_Selenide;



import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class Authorization extends AbstrationTest{


    @Test
    @DisplayName("Авторизация на сайте")
    @Severity(SeverityLevel.NORMAL)
    void Login() throws IOException {

        logger.info("Авторизация на сайте магазина");
        Login login = new Login(getWebDriver());
        login.loginInAccount("teststepank0@yandex.ru", "stepantest");
        logger.info("Проверка авторизации");
        login.checkAuthorization();
    }


    @Test
    @DisplayName("Выходим из авторизации.")
    @Severity(SeverityLevel.MINOR)
    void LogOud() throws IOException {

        logger.info("Авторизация на сайте магазина");
        Login login = new Login(getWebDriver());
        login.loginInAccount("teststepank0@yandex.ru", "stepantest");
        logger.info("Проверка авторизации");
        login.checkAuthorization();
        logger.info("Выход из аккаунта.");
        login.logOut();
        logger.info("Проверка выхода из аккаунта");
        login.checkLogOut();

    }
}
