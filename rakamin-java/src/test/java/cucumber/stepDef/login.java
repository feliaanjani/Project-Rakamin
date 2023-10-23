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

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("Halaman login swaglab")
    public void halaman_login() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //Assertion
        String loginPageAssert = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @When("Input Username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input Password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click Login button")
    public void clickLoginButton() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("User in on dashboard page")
    public void userInOnDashboardPage() {
        String productPage = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(productPage, "Products");
        driver.close();
    }

    @When("Input invalid Username")
    public void inputInvalidUsername() {
        driver.findElement(By.id("user-name")).sendKeys("secret_sauce");
    }

    @And("Input invalid Password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("standard_user");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        String errorLogin = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }

}
