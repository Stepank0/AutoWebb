package org.example.HW5;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class HWTest extends AbstractTest{

    @BeforeEach
    void login(){
        Actions login = new Actions(getDriver());

        login.click(getDriver().findElement(By.xpath(".//a[@data-fancybox='login-popap']")))
                .click(getDriver().findElement(By.xpath(".//input[@id='USER_LOGIN']")))
                .sendKeys("teststepank0@yandex.ru")
                .click(getDriver().findElement(By.xpath(".//input[@id='USER_PASSWORD']")))
                .sendKeys("teststepanko")
                .click(getDriver().findElement(By.cssSelector("input.submit")))
                .build()
                .perform();

        Assertions.assertEquals("STEPAN KORYAGIN", getDriver().findElement(By.xpath(".//a[text()='Stepan Koryagin']")).getText() );

    }


    @Test
    void addItem(){

        Actions search = new Actions(getDriver());

        search.click(getDriver().findElement(By.xpath(".//i[@class='fas fa-search']")))
                .click(getDriver().findElement(By.xpath(".//input[@id='title-search-input']")))
                .sendKeys("Ручка шариковая Glance")
                .sendKeys(Keys.ENTER)
                .build()
                .perform();


        Actions find = new Actions(getDriver());

        find.click(getDriver().findElement(By.cssSelector("div.section-item-wrap")))
                .build()
                .perform();

        WebElement addCart = getDriver().findElement(By.xpath(".//i[@class='fas fa-shopping-basket']"));
        addCart.click();

        WebElement placeAnOder = getDriver().findElement(By.xpath(".//a[@class='default-btn cl']"));
        placeAnOder.click();

        WebElement scrollUp = (new WebDriverWait(getDriver(), Duration.ofSeconds(10000l))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.page-up.show"))));
        scrollUp.click();

        Assertions.assertEquals("Ручка шариковая Glance | green",
                getDriver().findElement(By.xpath(".//a[@href='/catalog/ruchki_i_karandashi/ruchka_sharikovaya_glance_green/']")).getText());

    }

    @Test
    void addFavorite(){

        Actions search = new Actions(getDriver());

        search.click(getDriver().findElement(By.xpath(".//i[@class='fas fa-search']")))
                .click(getDriver().findElement(By.xpath(".//input[@id='title-search-input']")))
                .sendKeys("Калькулятор Candy love")
                .sendKeys(Keys.ENTER)
                .build()
                .perform();

        WebElement item = getDriver().findElement(By.cssSelector("div.section-item-wrap"));
        item.click();

        WebElement favourites = getDriver().findElement(By.xpath(".//a[@href='#']/i[@class='far fa-heart']"));
        favourites.click();

        WebElement iconClose = getDriver().findElement(By.cssSelector("button.fancybox-button.fancybox-close-small"));
        iconClose.click();
        WebElement iconFavorites = getDriver().findElement(By.xpath(".//i[@class='far fa-heart']/span[@class='count']"));
        iconFavorites.click();

        Assertions.assertEquals("Калькулятор Candy love | blue",
                getDriver().findElement(By.xpath(".//div[@class='name']/a[@href='/catalog/melochi/kalkulyator_candy_love_blue/']")).getText());

    }

    @Test
    void deleteFromBasket(){

        Actions search = new Actions(getDriver());

        search.click(getDriver().findElement(By.xpath(".//i[@class='fas fa-search']")))
                .click(getDriver().findElement(By.xpath(".//input[@id='title-search-input']")))
                .sendKeys("Калькулятор Candy love")
                .sendKeys(Keys.ENTER)
                .build()
                .perform();

        Actions find = new Actions(getDriver());

        find.click(getDriver().findElement(By.cssSelector("div.section-item-wrap")))
                .build()
                .perform();

        WebElement addCart = getDriver().findElement(By.xpath(".//i[@class='fas fa-shopping-basket']"));
        addCart.click();

        WebElement placeAnOder = getDriver().findElement(By.xpath(".//a[@class='default-btn cl']"));
        placeAnOder.click();

        Actions remove = new Actions(getDriver());

        remove.click(getDriver().findElement(By.cssSelector("div.page-up.show")))
                .pause(1000l)
                .click(getDriver().findElement(By.xpath(".//a[@data-a1='TR-CB03840-4']")))
                .build()
                .perform();

        WebElement scrollUp = (new WebDriverWait(getDriver(), Duration.ofSeconds(10000l))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.page-up.show"))));
        scrollUp.click();

        Assertions.assertThrows(NoSuchElementException.class,
                () -> getDriver().findElement(By.xpath(".//a[@href='/catalog/melochi/kalkulyator_candy_love_blue/']")));

    }

    @Test
    void lookForShop(){

        WebElement shopAddress = getDriver().findElement(By.cssSelector("div.shop-address"));
        shopAddress.click();


        WebElement city = getDriver().findElement(By.xpath(".//a[@href='/service/contacts/belgorod/']"));
        city.click();

        WebElement workTime = getDriver().findElement(By.xpath(".//div[@class='worktime']/a"));
        workTime.click();

        Assertions.assertEquals("СИТИ МОЛЛ\n" +
                        "ул. Щорса, 64 (1 этаж)\n" +
                        "10:00 - 22:00 :\n" +
                        "+74722289015",
                getDriver().findElement(By.cssSelector("div.basket-popap-in.fancybox-content")).getText());

    }

    @Test
    void addFavoriteByCard(){

        Actions search = new Actions(getDriver());

        search.click(getDriver().findElement(By.xpath(".//i[@class='fas fa-search']")))
                .click(getDriver().findElement(By.xpath(".//input[@id='title-search-input']")))
                .sendKeys("Подарочный набор Это мы")
                .sendKeys(Keys.ENTER)
                .build()
                .perform();

        Actions addItem = new Actions(getDriver());

        addItem.moveToElement(getDriver().findElement(By.xpath(".//div[@data-item='66061']")))
                .click(getDriver().findElement(By.xpath(".//div[@data-item='66061']//i[@class='far fa-heart']")))
                .build()
                .perform();

        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement closeWindow = getDriver().findElement(By.cssSelector("button.fancybox-button.fancybox-close-small"));
        closeWindow.click();

        WebElement scrollUp = getDriver().findElement(By.cssSelector("div.page-up.show"));
        scrollUp.click();

        try {
            Thread.sleep(600l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        WebElement iconFavorites = getDriver().findElement(By.xpath(".//i[@class='far fa-heart']/span[@class='count']"));
        iconFavorites.click();

        Assertions.assertEquals("Подарочный набор \"Это мы\"\n" +
                "499 р.", getDriver().findElement(By.xpath(".//div[@data-item='66061']/div[@class='section-item-wrap']")).getText());



    }

    @Test
    void addItemByCard(){

        Actions search = new Actions(getDriver());

        search.click(getDriver().findElement(By.xpath(".//i[@class='fas fa-search']")))
                .click(getDriver().findElement(By.xpath(".//input[@id='title-search-input']")))
                .sendKeys("Tianhao Deer")
                .sendKeys(Keys.ENTER)
                .build()
                .perform();

        Actions addItem = new Actions(getDriver());

        addItem.moveToElement(getDriver().findElement(By.xpath(".//div[@data-item='66159']")))
                .click(getDriver().findElement(By.xpath(".//div[@data-item='66159']//i[@class='icon-cart']")))
                .build()
                .perform();

        WebElement placeOrder = getDriver().findElement(By.cssSelector("a.default-btn.cl"));
        placeOrder.click();

        WebElement scrollUp = (new WebDriverWait(getDriver(), Duration.ofSeconds(10000l))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.page-up.show"))));
       scrollUp.click();

       Assertions.assertEquals("Набор текстовыделителей Tianhao Deer 36 цветов", getDriver().findElement(By.xpath(".//a[@href='/catalog/ruchki_i_karandashi/nabor_tekstovydeliteley_tianhao_deer_36_tsvetov/']")).getText());

    }

    @AfterEach
    void exitLogin() {

        getDriver().navigate().to("https://zakka.ru/");

        WebElement exit = getDriver().findElement(By.xpath(".//div[@class='auth-user']//i"));
        exit.click();

    }


}
