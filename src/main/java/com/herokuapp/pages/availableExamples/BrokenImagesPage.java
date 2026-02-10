package com.herokuapp.pages.availableExamples;

import com.herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrokenImagesPage extends BasePage {

    public BrokenImagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "img")
    List<WebElement> images;

  public BrokenImagesPage checkBrokenImages() {
//        System.out.println("Total images on the page = " + images.size());
//
//        return this;


      try {
          System.out.println("Total images on the page = " + images.size());
          for (int i = 0; i < images.size(); i++) {
              WebElement image = images.get(i);
              String imageUrl = image.getAttribute("src");
              verifyLinks(imageUrl);
              boolean imageDisplayed = (Boolean) js.executeScript("return (typeof arguments[0].naturalWidth!=undefined && arguments[0].naturalWidth>0);", image);
              if (imageDisplayed) {
                  //System.out.println("Display OK");
                  softly.assertThat(imageDisplayed);
              } else {
                  //System.out.println("Display - BROKEN");
                   softly.fail("BROKEN images --> "+ imageUrl);
              }
          }
      } catch (Exception e) {
          //System.out.println("Error occurred");
          softly.fail("Error occurred");
          //throw new RuntimeException(e);
      }
      softly.assertAll();
      return this;
  }


}
