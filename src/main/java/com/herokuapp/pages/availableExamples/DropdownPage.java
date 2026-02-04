package com.herokuapp.pages.availableExamples;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {
    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "dropdown")
    WebElement dropdown;

    public DropdownPage selectOption(String option) {
        new Select(dropdown).selectByVisibleText(option);
        return this;
    }

    public DropdownPage verifyOption() {
        Assertions.assertTrue(shouldHaveText(dropdown,
                new Select(dropdown).getFirstSelectedOption().getText(), 5));
        return this;
    }
}
