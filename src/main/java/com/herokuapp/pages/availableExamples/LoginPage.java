package com.herokuapp.pages.availableExamples;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
@FindBy(id = "username")
    WebElement userNameInput;
    @FindBy(id = "password")
    WebElement passwordInput;

    public LoginPage enterUserData(String userName,String password){
        type(userNameInput,userName);
        type(passwordInput,password);
        return this;
    }

   @FindBy(css = "button[type='submit'")
    //@FindBy(id = "form#login button") // 2v  no work
    //@FindBy(xpath = "//h2[text()='Secure Area']") //3v
    WebElement loginButton;

    public LoginPage clickOnLoginButton() {
click(loginButton);
        return this;
    }
    @FindBy(css = ".example h2")
//@FindBy(id="flash")
//@FindBy(css = "div.flash.success")
WebElement success;

    public LoginPage verifyOnPageText(String text) {
        Assertions.assertTrue(isContainsText(text, success));
        return this;
    }
}
