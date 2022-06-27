package org.example.HW6_pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {

    private static EventFiringWebDriver eventDriver;
    static Logger logger = LoggerFactory.getLogger(org.example.HW6_pageObject.AbstractTest.class);

    @BeforeAll
    static void setDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
//        options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");
        options.setPageLoadTimeout(Duration.ofSeconds(10));
//        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        eventDriver = new EventFiringWebDriver(new ChromeDriver(options));
        eventDriver.register(new MyWebDriverEventListener());
        eventDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeEach
    @Step("Переход на главную страницу")
    void getStartPage(){

//            Assertions.assertDoesNotThrow(() -> getWebDriver().get("https://zakka.ru/"),
//                    "Страница недоступна");

        Assertions.assertDoesNotThrow(() -> eventDriver.get("https://zakka.ru/"), "Стартовая страница не доступна!!!");
        logger.info("Переход на стартовую страницу");https://zakka.ru/
        Assertions.assertTrue(true);
      }

    @AfterEach
    public void checkBrowser(){
        List<LogEntry> allLogRows = getWebDriver().manage().logs().get(LogType.BROWSER).getAll();
        if(!allLogRows.isEmpty()){

            if (allLogRows.size() > 0 ) {
                allLogRows.forEach(logEntry -> {
                    System.out.println(logEntry.getMessage());
                });
            }
        }
    }

    @AfterAll
    public static void exit(){
        logger.info("Закрытие браузера. Все ТК выполнены.");
        if(eventDriver !=null) eventDriver.quit();

    }

    public WebDriver getWebDriver(){
        return this.eventDriver;
    }
}


//-------------------------------------------------------------------------------------------------------------

//public abstract class AbstractTest {
//
//    static EventFiringWebDriver eventDriver;
//
//    @BeforeAll
//    static void init(){
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito");
//        options.addArguments("start-maximized");
//        options.setPageLoadTimeout(Duration.ofSeconds(10));
////        options.addArguments("--headless");
//
//        eventDriver = new EventFiringWebDriver(new ChromeDriver(options));
//        eventDriver.register(new MyWebDriverEventListener());
//
//        eventDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//    }
//
//    @BeforeEach
//    void goTo(){
////        Assertions. assertDoesNotThrow( () -> getDriver().navigate().to("https://zakka.ru/"),
////                "Страница не доступна");
////        Assertions.assertTrue(true);
//    }
//
//    @AfterAll
//    public static void quit(){
//
//        if(eventDriver != null) eventDriver.quit();
//    }
//
//    @AfterEach
//    public void checkBrowser(){
//        List<LogEntry> allLogRows = getWebDriver().manage().logs().get(LogType.BROWSER).getAll();
//        if(!allLogRows.isEmpty()){
//
//            if (allLogRows.size() > 0 ) {
//                allLogRows.forEach(logEntry -> {
//                    System.out.println(logEntry.getMessage());
//                });
//
//            }
//
//        }
//
//    }
//
//
//    public WebDriver getWebDriver() {
//        return this.eventDriver;
//    }
//}
