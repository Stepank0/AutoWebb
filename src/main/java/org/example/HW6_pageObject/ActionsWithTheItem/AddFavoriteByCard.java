package org.example.HW6_pageObject.ActionsWithTheItem;

import org.example.HW6_pageObject.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddFavoriteByCard extends AbstractPage {

        @FindBy(xpath = ".//div[@data-item='66959']")
    private WebElement itemCard;

    @FindBy(xpath = ".//div[@data-item='66959']//i[@class='far fa-heart']")
    private WebElement buttonFavorite;

    @FindBy(xpath = ".//div[@id='basket-popap']/button")
    private WebElement closeWindow;

    @FindBy(xpath = ".//i[@class='far fa-heart']/span[@class='count']")
    private WebElement iconFavorites;


    public AddFavoriteByCard (WebDriver driver){
        super(driver);
    }

    public void addItemToFavorite(){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(itemCard)
                .pause(1000l)
                .click(buttonFavorite)
                .build()
                .perform();
    }

    public AddFavoriteByCard clickCloseWindow(){
        new WebDriverWait(getDriver(), Duration.ofMillis(5000l))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@id='basket-popap']/button")));
        closeWindow.click();
        return this;
    }

    public AddFavoriteByCard clickIconFavorites(){
//        new WebDriverWait(getDriver(), Duration.ofMillis(2000l))
//                .until(ExpectedConditions.visibilityOfAllElements(iconFavorites));
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        iconFavorites.click();
        return this;
    }
}
