package com.herokuapp.pages.availableExamples;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.time.Duration;

public class ContextMenuPage extends BasePage {
    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "hot-spot")
    WebElement hotSpot;

    public ContextMenuPage rightClick() {
        actions.contextClick(hotSpot).perform();
        return this;
    }


    public ContextMenuPage acceptAlertOk() {
        //isAlertPresent(6)
        driver.switchTo().alert().accept();
        // getWait(10000);
        return this;
    }


    public ContextMenuPage clickDownAndEnter() {
        // actions.sendKeys(Keys.ENTER).perform();
        //actions.sendKeys(Keys.ENTER).pause(Duration.ofSeconds(6)).perform();
        actions.sendKeys(Keys.ARROW_DOWN).pause(Duration.ofMillis(1000)).sendKeys(Keys.ENTER).perform();
        driver.navigate().back();
        return this;
    }


//    @FindBy(css = ".example h3")
//    WebElement example;

    @FindBy(css = ".heading")
    WebElement heading;

    public ContextMenuPage verifyRightClick(String text) {
        Assertions.assertEquals(text, heading.getText());
        return this;
    }
}
