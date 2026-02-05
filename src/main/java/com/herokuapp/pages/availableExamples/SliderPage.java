package com.herokuapp.pages.availableExamples;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends BasePage {
    public SliderPage(WebDriver driver) {
        super(driver);
    }


    //@FindBy(css = ".sliderContainer")
    //   WebElement sliderContainer;
    @FindBy(css = ".sliderContainer input")
    WebElement sliderContainer;

    public SliderPage moveSlider() {
        actions.dragAndDropBy(sliderContainer, 260, 0)
                .perform();
        return this;
    }

    @FindBy(id = "range")
    WebElement range;


    public SliderPage verifySliderValue(String number) {
        String actualValue = range.getText();
        System.out.println(actualValue);
        Assertions.assertEquals(number, actualValue);

        // If: getDomAttribute(name) --> Test: expected: <5> but was: <null>
        //Assertions.assertEquals(number,range.getDomAttribute("5"));
        return this;
    }
}
