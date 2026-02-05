package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.availableExamples.DropdownPage;
import com.herokuapp.pages.availableExamples.FramesPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    public void framesByTests(){
        framesPage.getNestedFrames()
                .switchToFrameLeft()
                .verifyFrameByName("LEFT")
                .switchToMainPage()
                .verifyMainPageByTitles("Nested Frames");

    }


}
