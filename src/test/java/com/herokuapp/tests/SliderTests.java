package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.availableExamples.AlertsPage;
import com.herokuapp.pages.availableExamples.SliderPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SliderTests extends TestBase {
    SliderPage sliderPage;

    @BeforeEach
    public void precondition() {
        sliderPage = new SliderPage(driver);
        new HomePage(driver).getHorizontalSlider();
    }
    @Tag("testMy")
    @Test
    public void sliderTest(){

        new SliderPage(driver).moveSlider()
              .verifySliderValue("5");
    }
}

