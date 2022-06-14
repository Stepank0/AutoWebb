package org.example.HW6_pageObject.ActionsWithTheItem;

import org.example.HW6_pageObject.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddItem extends AbstractPage {

    @FindBy(css = "div.section-item-wrap")
    private WebElement findItem;

    @FindBy(xpath = ".//i[@class='fas fa-shopping-basket']")
    private WebElement addCard;

    @FindBy(xpath = ".//a[@class='default-btn cl']")
    private  WebElement placeAnOder;

    @FindBy(css = "div.page-up.show")
    private WebElement scrollUp;

    public AddItem(WebDriver driver){
        super(driver);
    }

    public AddItem clickFindItem(){
        findItem.click();
        return this;
    }

    public AddItem clickAddCard(){
        addCard.click();
        return this;
    }

    public AddItem clickPlaceAnOder(){
        placeAnOder.click();
        return this;
    }

    public void scroll() {

        try {
            Thread.sleep(4000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
                scrollUp.click();
    }

//    public void scroll(){
//        new WebDriverWait(getDriver(), Duration.ofMillis(7000l))
//                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.page-up.show")));
//        scrollUp.click();
//        // By.cssSelector("div.page-up.show") если вместо css вставляю локатор
//        // By.cssSelector(scrollUp) то компилятор ругается
//    }

//     public AddItem clickScrollUp(){
//        scrollUp.click();
//        return this;
//    }

}
