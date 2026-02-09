package com.herokuapp.pages.availableExamples;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadPage extends BasePage {
    public UploadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "file-upload")
    WebElement fileUpload;

    @FindBy(css = ".button")
    WebElement buttonUpload;


    public UploadPage clickChooseFile(String path) {
        fileUpload.sendKeys(path);
        click(buttonUpload);
        return this;
    }

    @FindBy(css = "h3")
    WebElement formTitle;

    public UploadPage verifyUploadFile(String result) {
        Assertions.assertTrue(isContainsText(result, formTitle));
        return this;
    }
}
