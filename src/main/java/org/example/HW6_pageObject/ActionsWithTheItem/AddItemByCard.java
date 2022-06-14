package org.example.HW6_pageObject.ActionsWithTheItem;

import org.example.HW6_pageObject.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddItemByCard extends AbstractPage {

    @FindBy(xpath = ".//div[@data-item='66159']")
    private WebElement itemCard;

    @FindBy(xpath = ".//div[@data-item='66159']//i[@class='icon-cart']")
    private WebElement buttonAdd;


    public AddItemByCard (WebDriver driver){
        super(driver);
    }

    public void addItem(){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(itemCard)
                .click(buttonAdd)
                .build()
                .perform();

    }
}
