package org.example.HW6_pageObject.ActionsWithTheItem;

import org.example.HW6_pageObject.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddFavorite extends AbstractPage {

    @FindBy(css = "div.section-item-wrap")
    private WebElement item;

    @FindBy(xpath = ".//a[@href='#']/i[@class='far fa-heart']")
    private WebElement iconFavorite;

    @FindBy(xpath = ".//button[@class='fancybox-button fancybox-close-small']")
    private  WebElement iconClose;

    @FindBy(xpath = ".//i[@class='far fa-heart']/span[@class='count']")
    private WebElement iconFavoriteHeader;

    public AddFavorite(WebDriver driver){
        super(driver);
    }

    public AddFavorite clickItem(){
        item.click();
        return this;
    }

    public AddFavorite clickIconFavorite(){
        iconFavorite.click();
        return this;
    }

    public AddFavorite clickIconClose(){
        iconClose.click();
        return this;
    }

    public AddFavorite clickIconFavoriteHeader(){
        iconFavoriteHeader.click();
        return this;
    }
}
