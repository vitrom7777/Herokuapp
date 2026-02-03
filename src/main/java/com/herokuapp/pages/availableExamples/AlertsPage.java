package com.herokuapp.pages.availableExamples;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    private WebElement buttonJsAlert;

    public AlertsPage verifyAlertWithTimer() {
        click(buttonJsAlert);
        Assertions.assertTrue(isAlertPresent(5));
        return this;
    }

    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    private WebElement buttonJsConfirm;

    public AlertsPage clickOnJsConfirm(String result) {
        click(buttonJsConfirm);
        if (result != null && result.equals("Ok")) {
            driver.switchTo().alert().accept();
        } else if (result != null && result.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(id = "result")
    private WebElement resultConfirm;

    public AlertsPage verifyResult(String text) {
        Assertions.assertTrue(isContainsText(text, resultConfirm));
        return this;
    }

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    private WebElement jsPrompt;

    public AlertsPage clickOnJsPromptButton() {
        click(jsPrompt);
        return this;
    }


    public AlertsPage sendMessageToAlert(String message) {
        if (message != null) {
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }
        return this;
    }

    @FindBy(xpath = "//p[contains(text(),'You entered:')]")
    private WebElement YouEntered;

    public AlertsPage verifyMessage(String text) {
        Assertions.assertTrue(isContainsText(text,YouEntered));
        return this;
    }
}
