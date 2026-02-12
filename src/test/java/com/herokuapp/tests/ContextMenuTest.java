package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.availableExamples.ContextMenuPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ContextMenuTest extends TestBase {
    ContextMenuPage context;

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getContextMenu();
        context = new ContextMenuPage(driver);

    }

    //    зайти на эту страницу
//    сделать правый клик по элементу с пунктирной линией
//    кликнуть на OK в появившемся диалоговом окне
//    при помощи класса Keys нажать на клавишу ARROW_DOWN(или DOWN), затем на клавишу ENTER
//    убедиться, что вы вернулись на домашнюю страницу

@Tag("testMy")
    @Test
    public void rightClickTestOnBox() {

        context.rightClick();
        context.acceptAlertOk();
        context.clickDownAndEnter()
                .verifyRightClick("Welcome to the-internet");
    }
}
