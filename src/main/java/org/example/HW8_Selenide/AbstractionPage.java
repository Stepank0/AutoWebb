package org.example.HW8_Selenide;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractionPage {

    private WebDriver webDriver;

    public AbstractionPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);

    }

    protected WebDriver getWebDriver(){
        return this.webDriver;
    }
}
