package com.herokuapp.pages.availableExamples;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MultipleWindowsPage extends BasePage {


    public MultipleWindowsPage(WebDriver driver) {
        super(driver);
    }

   // @FindBy(xpath = "//a[text()='Click Here']")
    @FindBy(css = "a[href='/windows']")
    WebElement windows;

    public MultipleWindowsPage clickHereButton() {
        click(windows);
        return this;
    }
//@FindBy(xpath = "//a[text()='Click Here']")

    public MultipleWindowsPage switchToNewTab(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

    @FindBy(css = ".example h3")
    WebElement example;

    public MultipleWindowsPage verifyNewTabTitle(String title) {
        Assertions.assertTrue(shouldHaveText(example, title, 5));

        return this;
    }
    @FindBy(xpath = "//a[text()='Click Here']")
    WebElement ClickHere;
    public MultipleWindowsPage clickHereButton2() {
click(ClickHere);
        return this;
    }
}
