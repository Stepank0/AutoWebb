package org.example.HW6_pageObject.ActionsOnTheSite;

import org.example.HW6_pageObject.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExitLogin extends AbstractPage {

    @FindBy(xpath = ".//div[@class='auth-user']//i")
    private WebElement iconExit;

    public ExitLogin (WebDriver driver){
        super(driver);
    }

    public void exit (){
        getDriver().navigate().to("https://zakka.ru/");
        iconExit.click();
    }
}
