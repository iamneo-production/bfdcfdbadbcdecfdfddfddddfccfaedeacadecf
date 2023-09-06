package ai.iamneo.testing.Testing_Selenium_TestNg;

import org.testng.annotations.Test;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AppTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Set up WebDriver and open the Chrome browser
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testFacebookSignUp() {
        // Step 1: Open Chrome browser and navigate to fb.com
        driver.get("http://www.fb.com");

        // Step 2: Verify the URL
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "http://www.facebook.com");

        // Step 3: Verify the "Create an account" section
        WebElement createAccountSection = driver.findElement(By.id("create_account_section"));
        Assert.assertTrue(createAccountSection.isDisplayed());

        // Step 4: Fill in text boxes
        WebElement firstName = driver.findElement(By.id("firstname"));
        WebElement surname = driver.findElement(By.id("surname"));
        WebElement mobileOrEmail = driver.findElement(By.id("mobile_or_email"));
        WebElement reEnterMobile = driver.findElement(By.id("reenter_mobile"));
        WebElement newPassword = driver.findElement(By.id("new_password"));

        firstName.sendKeys("John");
        surname.sendKeys("Doe");
        mobileOrEmail.sendKeys("example@email.com");
        reEnterMobile.sendKeys("example@email.com");
        newPassword.sendKeys("password123");

        // Step 5: Update date of birth in the drop-down
        WebElement dayDropdown = driver.findElement(By.id("day"));
        WebElement monthDropdown = driver.findElement(By.id("month"));
        WebElement yearDropdown = driver.findElement(By.id("year"));

        // You can select the values from the dropdowns as needed

        // Step 6: Select gender
        WebElement genderRadioButton = driver.findElement(By.id("gender"));
        genderRadioButton.click();

        // Step 7: Click on "Create an account"
        WebElement createAccountButton = driver.findElement(By.id("create_account_button"));
        createAccountButton.click();

        // Step 8: Verify that the account is created successfully
        // You can add assertions or checks to verify the account creation

    }

    @AfterTest
    public void tearDown() {
        // Close the browser after the test
        driver.quit();
    }
}
