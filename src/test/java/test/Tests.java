package test;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import pages.CarvanaCarsPage;

import static org.testng.Assert.*;

public class Tests extends Base {

    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void validateCarvanaHomePageTitleAndURL() {
        driver.get("https://www.carvana.com/");
        assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
        assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
    }

    @Test(priority = 2, description = "Test name = Validate the Carvana logo")
    public void validateCarvanaLogo() {
        driver.get("https://www.carvana.com/");
        assertTrue(carvanaMainPage.carvanaLogo.isDisplayed());
    }

    @Test(priority = 3, description = "Test name = Validate the main navigation section items")
    public void validateNavigationSections() {
        driver.get("https://www.carvana.com/");
        String[] expectedMenuNavigatorBar = {"HOW IT WORKS",
                "ABOUT CARVANA",
                "SUPPORT & CONTACT"};

        for (int i = 0; i < expectedMenuNavigatorBar.length; i++) {
            assertEquals(carvanaMainPage.menuNavigatorBar.get(i).getText(), expectedMenuNavigatorBar[i]);

        }
    }

    @Test(priority = 4, description = "Validate the sign in error message")
    public void validateTheSingInError() {
        driver.get("https://www.carvana.com/");
        carvanaMainPage.singIn.click();
        explicitWait.until(ExpectedConditions.visibilityOf(carvanaMainPage.userNameEmailInputBox));
        carvanaMainPage.userNameEmailInputBox.sendKeys("johndoe@gmail.com");
        carvanaMainPage.userNamePasswordInputBox.sendKeys("abcd1234");
        explicitWait.until(ExpectedConditions.elementToBeClickable(carvanaMainPage.singInButtonInSingInForm));
        carvanaMainPage.singInButtonInSingInForm.click();
        assertEquals(carvanaMainPage.errorMessage.getText(), "Email address and/or password combination is incorrect" +
                "\nPlease try again or reset your password.");

    }

    @Test(priority = 5, description = "Validate the search filter options and search button")
    public void ValidateSearchFilterOptions() {
        driver.get("https://www.carvana.com/");

        carvanaMainPage.searchCarsButton.click();
        assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");

        String[] expectedCarOptions = {"PAYMENT & PRICE",
                "MAKE & MODEL",
                "BODY TYPE",
                "YEAR & MILEAGE",
                "FEATURES",
                "MORE FILTERS"};

        for (int i = 0; i < expectedCarOptions.length; i++) {
            assertEquals(carvanaCarsPage.filterOptions.get(i).getText(), expectedCarOptions[i]);
        }
    }

    @Test(priority = 6, description = "Validate the search result tiles")
    public void validateSearchResultTitle() throws InterruptedException {
        driver.get("https://www.carvana.com/");
        carvanaMainPage.searchCarsButton.click();
        assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
        carvanaCarsPage.searchInputBox.sendKeys("mercedes-benz");
        carvanaCarsPage.goButton.click();
        explicitWait.until(ExpectedConditions.urlContains("mercedes-benz"));
        assertTrue(driver.getCurrentUrl().contains("mercedes-benz"));
        carvanaCarsPage.crossClose.click();
        for (int i = 0; i < 19; i++) {
            assertTrue(carvanaCarsPage.tileImg.get(i).isDisplayed());
            assertTrue(carvanaCarsPage.tileFavorite.get(i).isDisplayed());
            assertTrue(carvanaCarsPage.tileBody.get(i).isDisplayed());
            assertTrue(carvanaCarsPage.inventoryType.get(i).isDisplayed() && carvanaCarsPage.inventoryType.get(i).getText() != null);
            assertTrue(carvanaCarsPage.yearMakeModelInfo.get(i).isDisplayed() && carvanaCarsPage.yearMakeModelInfo.get(i).getText() != null);
            assertTrue(carvanaCarsPage.trimMileage.get(i).isDisplayed() && carvanaCarsPage.trimMileage.get(i).getText() != null);
            assertTrue(carvanaCarsPage.price.get(i).isDisplayed() && carvanaCarsPage.price.get(i).getText() != null);
            assertTrue(carvanaCarsPage.monthlyPaymentInfo.get(i).isDisplayed() && carvanaCarsPage.monthlyPaymentInfo.get(i).getText() != null);
            assertTrue(carvanaCarsPage.downPaymentInfo.get(i).isDisplayed() && carvanaCarsPage.downPaymentInfo.get(i).getText() != null);
            assertTrue(carvanaCarsPage.deliveryChip.get(i).isDisplayed() && carvanaCarsPage.deliveryChip.get(i).getText() != null);

        }
    }
}
