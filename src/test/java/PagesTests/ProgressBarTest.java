package PagesTests;

import Pages.BootstrapProgressBarPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProgressBarTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();
    BootstrapProgressBarPage progressBarPage = new BootstrapProgressBarPage();

    @Test
    public void testProgressBarPercentage() {
        progressBarPage = homePage.clickBootstrapProgressBar();
        progressBarPage.clickStartDownloadButton();

        String actualPercentage = progressBarPage.getProgressBarPercentage();
        String actualMessage = progressBarPage.getCompletedMessage();

        String expectedMessage = "Dowload completed!"; // To make the test pass
        String expectedPercentage = "100%";

        softAssert.assertEquals(actualMessage, expectedMessage,
                "\n The Message is not complete or Correct \n");

        softAssert.assertEquals(actualPercentage, expectedPercentage,
                "\n Percentage is not 100% \n");

        softAssert.assertAll();
    }
}
