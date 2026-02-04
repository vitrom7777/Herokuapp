package com.herokuapp.pages.availableExamples;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FramesPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(FramesPage.class);

    public FramesPage(WebDriver driver) {
        super(driver);
    }


//    @FindBy(xpath = "//frameset")
//    WebElement frameset;

    @FindBy(name = "frame-top")
    WebElement frameTop;
    // @FindBy(name = "frame-left")
       @FindBy(css = "[name='frame-left']")
    WebElement frameLeft;

    public FramesPage switchToFrameLeft() {
       // driver.switchTo().defaultContent();
     log.info(String.valueOf(frameTop.getSize())); //
       driver.switchTo().frame(frameTop);
      //  driver.switchTo().defaultContent();
//        getWait(5).until(ExpectedConditions
//                .frameToBeAvailableAndSwitchToIt("frame-top"));
        driver.switchTo().frame("frame-left");
//        getWait(10).until(ExpectedConditions
//                .frameToBeAvailableAndSwitchToIt("frame-left"));
        return this;
    }

//    @FindBy(tagName = "body")
//    WebElement body;
    public FramesPage verifyFrameByName(String text) {
        Assertions.assertTrue(isContainsText(text,frameLeft));

        return this;
    }

    public FramesPage switchToMainPage() {
        driver.switchTo().defaultContent();
        return this;
    }
@FindBy(css = ".example")
WebElement example;
    public FramesPage verifyMainPageByTitles(String text) {
        Assertions.assertTrue(isContainsText(text,example));
        return this;
    }
    @FindBy(css = "a[href='/nested_frames']")
    WebElement nestedFrames;

    public FramesPage getNestedFrames() {
        click(nestedFrames);
        return this;
    }
}
