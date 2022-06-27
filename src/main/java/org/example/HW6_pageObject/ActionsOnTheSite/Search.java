package org.example.HW6_pageObject.ActionsOnTheSite;

import io.qameta.allure.Step;
import org.example.HW6_pageObject.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Search extends AbstractPage {

    @FindBy(xpath = ".//i[@class='fas fa-search']")
    private WebElement searchButton;

    @FindBy(xpath = ".//input[@id='title-search-input']")
    private WebElement inputSearch;

    public Search(WebDriver driver){
        super(driver);
    }

    public Search searchButton(){
        searchButton.click();
        return this;
    }

    public Search inputSearch(){
        inputSearch.click();
        return this;
    }

    @Step("Экшен действие с поиском товара.")
    public void  actionSearch(String item){
        Actions actions = new Actions(getDriver());
        actions.click(searchButton)
                .click(inputSearch)
                .sendKeys(item)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
    }

}
