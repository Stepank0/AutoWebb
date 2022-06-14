package org.example.HW6_pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LookForShop extends AbstractPage{

    @FindBy(css = "div.shop-address")
    private WebElement shopAddress;

    @FindBy(xpath = ".//a[@href='/service/contacts/belgorod/']")
    private WebElement city;

    @FindBy(xpath = ".//div[@class='worktime']/a")
    private WebElement workTime;


    public LookForShop (WebDriver driver){
        super (driver);
    }

    public LookForShop clickShopAddress(){
        shopAddress.click();
        return this;
    }

    public LookForShop clickCity(){
        city.click();
        return this;
    }

    public LookForShop clickWorkTime(){
        workTime.click();
        return this;
    }
}
