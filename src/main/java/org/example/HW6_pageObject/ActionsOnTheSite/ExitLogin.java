package org.example.HW6_pageObject.ActionsOnTheSite;

import io.qameta.allure.Step;
import org.example.HW6_pageObject.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ExitLogin extends AbstractPage {

    @FindBy(xpath = ".//div[@class='auth-user']//i")
    private WebElement iconExit;

    public ExitLogin (WebDriver driver){
        super(driver);
    }

    @Step("Выход из авторизации")
    public void exit (){
        getDriver().navigate().to("https://zakka.ru/");
        Actions actions = new Actions(getDriver());
        actions.pause(4000l)
                .click(iconExit)
                .pause(4000l)
                .build()
                .perform();

    }
}
