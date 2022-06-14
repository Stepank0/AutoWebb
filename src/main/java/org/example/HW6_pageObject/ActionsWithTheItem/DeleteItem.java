package org.example.HW6_pageObject.ActionsWithTheItem;

import org.example.HW6_pageObject.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeleteItem extends AbstractPage {

    @FindBy(xpath = ".//a[@data-a1='TR-CB03840-4']")
    private WebElement delete;


    public DeleteItem (WebDriver driver){
        super(driver);
    }

    public DeleteItem clickDelete(){
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        new WebDriverWait(getDriver(), Duration.ofMillis(5000l))
//                .until(ExpectedConditions.elementToBeClickable(delete));
        delete.click();
        return this;
    }



}
