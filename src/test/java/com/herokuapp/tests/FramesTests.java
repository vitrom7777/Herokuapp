package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.availableExamples.DropdownPage;
import com.herokuapp.pages.availableExamples.FramesPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesTests extends TestBase {

    FramesPage framesPage;

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getFrames();
        framesPage = new FramesPage(driver);

    }

    @Test
    public void framesByLeftTests() {
        framesPage.getNestedFrames();
        driver.switchTo().defaultContent(); // pravilo - sbrasivaem kontext
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        String text = driver.findElement(By.tagName("body"))
                .getText();
        Assertions.assertEquals(text, "LEFT");
        //driver.switchToFrameLeft()
        //.verifyFrameByName("LEFT")
        //.switchToMainPage()
        // .verifyMainPageByTitles("Nested Frames");
    }

    @Test
    public void framesByMiddleTests() {
        framesPage.getNestedFrames();
        driver.switchTo().defaultContent(); // pravilo - sbrasivaem kontext
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        String text = driver.findElement(By.tagName("body"))
                .getText();
        Assertions.assertEquals(text, "MIDDLE");

    }
}