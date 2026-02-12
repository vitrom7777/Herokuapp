package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.availableExamples.DragAndDropPage;
import com.herokuapp.pages.availableExamples.DropdownPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class DragAndDropTests extends TestBase {
DragAndDropPage dragAndDropPage;

    @BeforeEach
    public void precondition() {
        dragAndDropPage = new DragAndDropPage(driver);
        new HomePage(driver).getDragAndDropPage();
    }

    // v.1
    @Tag("testMy")
    @Test
    public void dragMyTest(){
        dragAndDropPage.dragMe()
                .verifyDropped("A");
    }

    // v.2
    @Test
    public void dragMeByTest(){
        dragAndDropPage.dragMeBy()
                .verifyDropped("A");
    }


}
