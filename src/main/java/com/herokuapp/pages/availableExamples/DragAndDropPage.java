package com.herokuapp.pages.availableExamples;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "column-a")
    WebElement dragMeA;
    @FindBy(id = "column-b")
    WebElement dropHereB;

    public DragAndDropPage dragMe() {
actions.dragAndDrop(dragMeA,dropHereB).perform();
        return this;
    }

    public DragAndDropPage verifyDropped(String text) {
        Assertions.assertTrue(shouldHaveText(dropHereB,text,5));
        return this;
    }


// Move
    public DragAndDropPage dragMeBy() {
        // get coordinates dragMy (from)
        int xOffset1 = dragMeA.getLocation().getX();
        int yOffset1 = dragMeA.getLocation().getY();
        System.out.println("xOffset1 -> " + xOffset1 + " *** " + "yOffset1 -> " + yOffset1);


        // get coordinates dragMy (to)
        int xOffset = dropHereB.getLocation().getX();
        int yOffset = dropHereB.getLocation().getY();
        System.out.println("xOffset -> " + xOffset + " *** " + "yOffset -> " + yOffset);
        // find coordinates offset and offset1
        xOffset= xOffset - xOffset1;
        yOffset=yOffset - yOffset1;
        actions.dragAndDropBy(dragMeA,xOffset,yOffset).perform();

        return this;
    }
}
