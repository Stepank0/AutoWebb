package org.example.HW8_Selenide;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$;

public class Login extends AbstractionPage {

    public Login(WebDriver webDriver) {
        super(webDriver);
    }

    public Login loginInAccount(String login, String password){
        $(By.xpath(".//i[@class='fas fa-user']")).click();
        $(By.xpath(".//a[@data-target='#authorization']")).click();
        $(By.xpath(".//div[@id=\"authorization\"]/div/div/div[2]/form/div[1]/div/input")).val(login);
        $(By.xpath(".//input[@type='password']")).val(password).pressEnter();
        return this;
    }

    public Login checkAuthorization(){
        $(By.xpath(".//a[@href='/my_account/orders']")).should(exist);
        return this;
    }

    public Login logOut (){
        $(By.xpath(".//i[@class='fas fa-user']")).click();
        $(By.xpath(".//a[@href='/logout']")).shouldBe(Condition.exist).click();
        return  this;
    }

    public Login checkLogOut(){
        $(By.xpath(".//a[@data-target='#authorization']")).shouldBe(Condition.exist);
        return this;
    }
}
