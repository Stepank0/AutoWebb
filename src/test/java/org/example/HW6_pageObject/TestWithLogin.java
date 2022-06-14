package org.example.HW6_pageObject;

import org.example.HW6_pageObject.ActionsOnTheSite.ExitLogin;
import org.example.HW6_pageObject.ActionsOnTheSite.Login;
import org.example.HW6_pageObject.ActionsOnTheSite.Search;
import org.example.HW6_pageObject.ActionsWithTheItem.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class TestWithLogin extends AbstractTest {

    @BeforeEach
    void login() {
        Login login = new Login(getDriver());

        login.clickloginPopap();
        login.clickuserLogin();
        login.inputLogin(("teststepank0@yandex.ru"));
        login.clickuserPassword();
        login.inputPassword("teststepanko");
        login.clicksubmit();
        Assertions.assertEquals("STEPAN KORYAGIN",
                getDriver().findElement(By.xpath(".//a[text()='Stepan Koryagin']")).getText() );
    }

    @Test
    void addItemIntoCart(){

        Search search = new Search(getDriver());
        search.actionSearch("Ручка шариковая Glance");

        AddItem addItem = new AddItem(getDriver());
        addItem.clickFindItem();
        addItem.clickAddCard();
        addItem.clickPlaceAnOder();
        addItem.scroll();

        Assertions.assertEquals("Ручка шариковая Glance | green",
                getDriver().findElement(By.xpath(".//a[@href='/catalog/ruchki_i_karandashi/ruchka_sharikovaya_glance_green/']")).getText());

    }

    @Test
    void DeleteItemFromCart(){

        Search search = new Search(getDriver());
        search.actionSearch("Калькулятор Candy love");

        AddItem addItem = new AddItem(getDriver());
        addItem.clickFindItem();
        addItem.clickAddCard();
        addItem.clickPlaceAnOder();
        addItem.scroll();

        DeleteItem deleteItem = new DeleteItem(getDriver());

        deleteItem.clickDelete();
        addItem.scroll();

        Assertions.assertThrows(NoSuchElementException.class,
                () -> getDriver().findElement(By.xpath(".//a[@href='/catalog/melochi/kalkulyator_candy_love_blue/']")));


    }

    @Test
    void addFavorite(){

        Search search = new Search(getDriver());
        search.actionSearch("Калькулятор Candy love");

        AddFavorite addFavorite = new AddFavorite(getDriver());
        addFavorite.clickItem();
        addFavorite.clickIconFavorite();
        addFavorite.clickIconClose();
        addFavorite.clickIconFavoriteHeader();

        Assertions.assertEquals("Калькулятор Candy love | blue",
                getDriver().findElement(By.xpath(".//div[@class='name']/a[@href='/catalog/melochi/kalkulyator_candy_love_blue/']")).getText());


    }

    @Test
    void addItemByCard(){

        Search search = new Search(getDriver());
        search.actionSearch("Tianhao Deer");

        AddItemByCard addItemByCard = new AddItemByCard(getDriver());
        addItemByCard.addItem();

        AddItem addItem = new AddItem(getDriver());
        addItem.clickPlaceAnOder();
        addItem.scroll();

        Assertions.assertEquals("Набор текстовыделителей Tianhao Deer 36 цветов", getDriver().findElement(By.xpath(".//a[@href='/catalog/ruchki_i_karandashi/nabor_tekstovydeliteley_tianhao_deer_36_tsvetov/']")).getText());

    }

    @Test
    void addFavoriteByCard(){

        Search search = new Search(getDriver());
        search.actionSearch("Подарочный набор Это мы");

        AddFavoriteByCard add = new AddFavoriteByCard(getDriver());
        add.addItemToFavorite();
        add.clickCloseWindow();

        AddItem addItem = new AddItem(getDriver());
        addItem.scroll();

        add.clickIconFavorites();


        Assertions.assertEquals("Подарочный набор \"Это мы\"\n" +
                "499 р.", getDriver().findElement(By.xpath(".//div[@data-item='66061']/div[@class='section-item-wrap']")).getText());



    }


    @Test
    void lookForShop(){

        LookForShop lookForShop = new LookForShop(getDriver());
        lookForShop.clickShopAddress();
        lookForShop.clickCity();
        lookForShop.clickWorkTime();

        Assertions.assertEquals("СИТИ МОЛЛ\n" +
                        "ул. Щорса, 64 (1 этаж)\n" +
                        "10:00 - 22:00 :\n" +
                        "+74722289015",
                getDriver().findElement(By.cssSelector("div.basket-popap-in.fancybox-content")).getText());


    }

    @AfterEach
    void exitLogin(){
        ExitLogin exitLogin = new ExitLogin(getDriver());
        exitLogin.exit();
    }

}
