package org.example.HW6_pageObject;

import io.qameta.allure.*;
import org.example.HW6_pageObject.ActionsOnTheSite.ExitLogin;
import org.example.HW6_pageObject.ActionsOnTheSite.Login;
import org.example.HW6_pageObject.ActionsOnTheSite.Search;
import org.example.HW6_pageObject.ActionsWithTheItem.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TestWithLogin extends AbstractTest {

    @BeforeEach
    @DisplayName("Авторизация на сайте")
    @Description("Перед каждым тестом авторизуется на сайте")
    @Link("https://zakka.ru/#login-popap")
    @Severity(SeverityLevel.NORMAL)
    void login() {
        Login login = new Login(getWebDriver());
        logger.info("Авторизация на сайте магазина");
        login.clickloginPopap();
        login.clickuserLogin();
        login.inputLogin(("teststepank0@yandex.ru"));
        login.clickuserPassword();
        login.inputPassword("teststepanko");
        login.clicksubmit();
        logger.info("Проверка авторизации");
        Assertions.assertEquals("STEPAN KORYAGIN",
                getWebDriver().findElement(By.xpath(".//a[text()='Stepan Koryagin']")).getText(),
                "Не получилось авторизоваться." );
    }

    @Test
    @DisplayName("ТК - 1. ")
    @Description("Добавляем товар в корзину через страницу товара.")
    @Link("https://zakka.ru/personal/cart/")
    @Severity(SeverityLevel.CRITICAL)
    void addItemIntoCart() throws IOException {
        logger.info("Поиск товара.");
        Search search = new Search(getWebDriver());
        search.actionSearch("Ручка шариковая Glance");
        logger.info("Добавление довара в Корзину.");
        AddItem addItem = new AddItem(getWebDriver());
        addItem.clickFindItem();
        addItem.clickAddCard();
        addItem.clickPlaceAnOder();
        addItem.scroll();

        // скрин результата проверки
        File file = MyUtils.makeScreenshot(getWebDriver(),"org.example.HW-7.InventoryPageTest.TC3_" + System.currentTimeMillis() + ".png");
        saveScreenshot(Files.readAllBytes(file.toPath()));
        MyUtils.getLogs(getWebDriver());

        logger.info("Проверка наличие товара в Корзине");
        Assertions.assertEquals("Ручка шариковая Glance | green",
                getWebDriver().findElement(By.xpath(".//a[@href='/catalog/ruchki_i_karandashi/ruchka_sharikovaya_glance_green/']")).getText(),
                "Товар не добавлен в корзину.");

    }

    @Test
    @DisplayName("ТК - 2. ")
    @Description("Добавляем товар в корзину через страницу товара, После чего удаляем товар из корзины")
    @Link("https://zakka.ru/personal/cart/")
    @Severity(SeverityLevel.CRITICAL)
    void DeleteItemFromCart() throws IOException, InterruptedException {
        logger.info("Поиск товара.");
        Search search = new Search(getWebDriver());
        search.actionSearch("Калькулятор Candy love");
        logger.info("Добавление товара в корзину");
        AddItem addItem = new AddItem(getWebDriver());
        addItem.clickFindItem();
        addItem.clickAddCard();

        Thread.sleep(1000l);
        addItem.clickPlaceAnOder();
        addItem.scroll();
        logger.info("Удаление товара из Корзины.");
        DeleteItem deleteItem = new DeleteItem(getWebDriver());

        Thread.sleep(2000l);
        deleteItem.clickDelete();
        addItem.scroll();

        // скрин результата проверки
        File file = MyUtils.makeScreenshot(getWebDriver(),"org.example.HW-7.InventoryPageTest.TC3_" + System.currentTimeMillis() + ".png");
        saveScreenshot(Files.readAllBytes(file.toPath()));
        MyUtils.getLogs(getWebDriver());

        logger.info("Проверка на отсудствие товара в Корзине.");
        Assertions.assertThrows(NoSuchElementException.class,
                () -> getWebDriver().findElement(By.xpath(".//a[@href='/catalog/melochi/kalkulyator_candy_love_blue/']")),
                "Товар не удален из корзины.");


    }

    @Test
    @DisplayName("ТК - 3. ")
    @Description("Добавляем товар в избранное через страницу товара.")
    @Link("https://zakka.ru/personal/fav/")
    @Severity(SeverityLevel.MINOR)
    void addFavorite() throws IOException {
        logger.info("Поиск товара.");
        Search search = new Search(getWebDriver());
        search.actionSearch("Калькулятор Candy love");
        logger.info("Добавление товара в Избранное.");
        AddFavorite addFavorite = new AddFavorite(getWebDriver());
        addFavorite.clickItem();
        addFavorite.clickIconFavorite();
        addFavorite.clickIconClose();
        addFavorite.clickIconFavoriteHeader();

        // скрин результата проверки
        File file = MyUtils.makeScreenshot(getWebDriver(),"org.example.HW-7.InventoryPageTest.TC3_" + System.currentTimeMillis() + ".png");
        saveScreenshot(Files.readAllBytes(file.toPath()));
        MyUtils.getLogs(getWebDriver());

        logger.info("Проверка на добленный товар в отделе Избранное");
        Assertions.assertEquals("Калькулятор Candy love | blue",
                getWebDriver().findElement(By.xpath(".//div[@class='name']/a[@href='/catalog/melochi/kalkulyator_candy_love_blue/']")).getText(),
                " Товар не добвавлен в Избранное.");


    }

    @Test
    @DisplayName("ТК - 4. ")
    @Description("Добавляем товар в корзину через карточку товара в каталоге.")
    @Link("https://zakka.ru/personal/cart/")
    @Severity(SeverityLevel.CRITICAL)
    void addItemByCard() throws IOException {
        logger.info("Поиск товара.");
        Search search = new Search(getWebDriver());
        search.actionSearch("Tianhao Deer");
        logger.info("Добавление товара в Корзину через карточку товара.");
        AddItemByCard addItemByCard = new AddItemByCard(getWebDriver());
        addItemByCard.addItem();

        AddItem addItem = new AddItem(getWebDriver());
        addItem.clickPlaceAnOder();
        addItem.scroll();

        // скрин результата проверки
        File file = MyUtils.makeScreenshot(getWebDriver(),"org.example.HW-7.InventoryPageTest.TC3_" + System.currentTimeMillis() + ".png");
        saveScreenshot(Files.readAllBytes(file.toPath()));
        MyUtils.getLogs(getWebDriver());

        logger.info("Проверка на наличие товара в Корзине.");
        Assertions.assertEquals("Набор текстовыделителей Tianhao Deer 36 цветов",
                getWebDriver().findElement(By.xpath(".//a[@href='/catalog/ruchki_i_karandashi/nabor_tekstovydeliteley_tianhao_deer_36_tsvetov/']")).getText()
                , "Товар не добавлен в Корзину");

    }

    @Test
    @DisplayName("ТК - 5. ")
    @Description("Добавляем товар в избранное через карточку товара в каталоге.")
    @Link("https://zakka.ru/personal/fav/")
    @Severity(SeverityLevel.MINOR)
    void addFavoriteByCard() throws IOException {
        logger.info("Поиск товара.");
        Search search = new Search(getWebDriver());
        search.actionSearch("Подарочный набор Для дерзких и резких");
        logger.info("Добавление товара в Избранное через карточку товара.");
        AddFavoriteByCard add = new AddFavoriteByCard(getWebDriver());
        add.addItemToFavorite();
        add.clickCloseWindow();

        AddItem addItem = new AddItem(getWebDriver());
        addItem.scroll();

        add.clickIconFavorites();

        // скрин результата проверки
        File file = MyUtils.makeScreenshot(getWebDriver(),"org.example.HW-7.InventoryPageTest.TC3_" + System.currentTimeMillis() + ".png");
        saveScreenshot(Files.readAllBytes(file.toPath()));
        MyUtils.getLogs(getWebDriver());

        logger.info(" Проверка на добавление товара в раздел Избранное.");
        Assertions.assertEquals("Подарочный набор \"Для дерзких и резких\" 26*22*10 см.\n" +
                        "2 100 р.",
                getWebDriver().findElement(By.xpath(".//div[@data-item='66959']/div[@class='section-item-wrap']")).getText(),
                "Товар не добаплен в Избранное");

    }


    @Test
    @DisplayName("ТК - 6. ")
    @Link("https://zakka.ru/service/contacts/belgorod/")
    @Severity(SeverityLevel.TRIVIAL)
    void lookForShop() throws IOException {
        logger.info("ТК-6 Поиск адресс магазина");
        LookForShop lookForShop = new LookForShop(getWebDriver());
        lookForShop.clickShopAddress();
        lookForShop.clickCity();
        lookForShop.clickWorkTime();

        // скрин результата проверки
        File file = MyUtils.makeScreenshot(getWebDriver(),"org.example.HW-7.InventoryPageTest.TC3_" + System.currentTimeMillis() + ".png");
        saveScreenshot(Files.readAllBytes(file.toPath()));
        MyUtils.getLogs(getWebDriver());

        logger.info("ТК-6 Проверка на модальное окно с адрессом магазина");
        Assertions.assertEquals("СИТИ МОЛЛ\n" +
                        "ул. Щорса, 64 (1 этаж)\n" +
                        "10:00 - 22:00 :\n" +
                        "+74722289015",
                getWebDriver().findElement(By.cssSelector("div.basket-popap-in.fancybox-content")).getText(), "Магазин не найден.");
    }

    @Step("Создание скриншота")
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @AfterEach
    @DisplayName("Выходим из авторизации.")
    @Description("Выход из авторизации после каждого теста")
    @Link("https://zakka.ru/")
    void exitLogin() throws InterruptedException {
        logger.info("Выход из авторизованного аккаунта.");
        ExitLogin exitLogin = new ExitLogin(getWebDriver());
        exitLogin.exit();
        Thread.sleep(2000l);
        logger.info("Проверка на Выход из авторизации");
        Assertions.assertEquals("ВОЙТИ", getWebDriver().findElement(By.xpath(".//a[@data-fancybox='login-popap']/span")).getText(),
                "Выход из авторизованного аккаунта не был произведён");

    }

}
