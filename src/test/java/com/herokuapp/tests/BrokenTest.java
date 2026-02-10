package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.availableExamples.BrokenImagesPage;
import com.herokuapp.pages.availableExamples.DragAndDropPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BrokenTest extends TestBase {
    BrokenImagesPage broken;

    @BeforeEach
    public void precondition() {
        broken = new BrokenImagesPage(driver);
        new HomePage(driver).getBrokenImagesPage();
    }
    @Test
    public void checkBrokenImagesTest(){
        broken.checkBrokenImages();
    }
}
