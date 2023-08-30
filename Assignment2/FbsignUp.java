import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FacebookSignUpTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up the Chrome driver
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testFacebookSignUp() {
        // Open Facebook's sign-up page
        driver.get("http://www.fb.com");

        // Verify redirection
        String currentURL = driver.getCurrentUrl();
        if (!currentURL.equals("http://www.facebook.com")) {
            Assert.fail("Page is not redirected to Facebook.");
        }

        // Verify "Create an account" section
        WebElement createAccountSection = driver.findElement(By.id("create_account_section"));
        Assert.assertTrue(createAccountSection.isDisplayed(), "Create an account section not found.");

        // Fill in the text boxes
        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Doe");
        driver.findElement(By.name("reg_email__")).sendKeys("example@email.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("example@email.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("password123");

        // Update date of birth in drop-down
        WebElement dayDropdown = driver.findElement(By.id("day"));
        // Select day value
        // ...

        WebElement monthDropdown = driver.findElement(By.id("month"));
        // Select month value
        // ...

        WebElement yearDropdown = driver.findElement(By.id("year"));
        // Select year value
        // ...

        // Select gender
        WebElement genderRadioButton = driver.findElement(By.name("sex"));
        genderRadioButton.click();

        // Click on "Create an account"
        WebElement createAccountButton = driver.findElement(By.name("websubmit"));
        createAccountButton.click();

        // Verify account creation
        WebElement confirmationMessage = driver.findElement(By.xpath("//div[contains(text(),'Welcome to Facebook')]"));
        Assert.assertTrue(confirmationMessage.isDisplayed(), "Account creation failed.");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
