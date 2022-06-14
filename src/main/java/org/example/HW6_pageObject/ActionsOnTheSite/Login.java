package org.example.HW6_pageObject.ActionsOnTheSite;

import org.example.HW6_pageObject.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends AbstractPage {

    @FindBy(xpath = ".//a[@data-fancybox='login-popap']")
    private WebElement loginPopap;

    @FindBy(xpath = ".//input[@id='USER_LOGIN']")
    private WebElement userLogin;

    @FindBy(xpath = ".//input[@id='USER_PASSWORD']")
    private WebElement userPassword;

    @FindBy(css = "input.submit")
    private WebElement submit;


    public Login (WebDriver driver){
        super(driver);
    }

    public Login clickloginPopap(){
        loginPopap.click();
        return this;
    }

    public Login clickuserLogin() {
        userLogin.click();
        return this;
    }

    public void inputLogin(String login){
        userLogin.sendKeys(login);
    }


    public Login clickuserPassword() {
        userPassword.click();
        return this;
    }

    public void inputPassword(String password){
        userPassword.sendKeys(password);
    }

    public Login clicksubmit() {
        submit.click();
//        new WebDriverWait(getDriver(), Duration.ofMillis(1000l)).until(ExpectedConditions.elementToBeClickable(submit));
        return this;
    }

}
