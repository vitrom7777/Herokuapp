package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.availableExamples.DropdownPage;
import com.herokuapp.pages.availableExamples.UploadPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UploadTest extends TestBase {
    UploadPage upload;

//протестируйте, пожалуйста, страницу File Uploader

    @BeforeEach
    public void precondition() {
        upload = new UploadPage(driver);
        new HomePage(driver).getUpload();
    }


    @Test
    public void UploadFileTest() {
        upload.clickChooseFile("C://QA/Herokuapp/src/test/resources/1.png")
                .verifyUploadFile("File Uploaded!");

    }

}
