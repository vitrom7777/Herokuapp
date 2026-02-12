package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.availableExamples.DropdownPage;
import com.herokuapp.pages.availableExamples.MultipleWindowsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class DropdownTests extends TestBase {

    DropdownPage dropdownPage;


    @BeforeEach
    public void precondition() {
        dropdownPage = new DropdownPage(driver);
        new HomePage(driver).getDropdown();
    }
    //@Tag("testMy")
    @Test
    public void selectOptions(){
        dropdownPage.selectOption("Option 1")
                .verifyOption();
    }
}
