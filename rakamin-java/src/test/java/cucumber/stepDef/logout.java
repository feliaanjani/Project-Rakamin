package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class logout {
    WebDriver driver;

    String baseUrl = "https://www.saucedemo.com/";

    @Given("User have logged in to swaglab website")
    public void userCanAccessProductPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        String productPage = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(productPage, "Products");
    }

    @When("Click hamburger menu")
    public void clickHamburgerMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("Click logout menu")
    public void clickLogoutMenu() {
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("Success logout")
    public void successLogout() {
        String loginPageAssert = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
        driver.close();
    }
}
