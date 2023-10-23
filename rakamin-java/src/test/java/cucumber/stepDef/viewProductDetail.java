package cucumber.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class viewProductDetail {

    WebDriver driver;

    String baseUrl = "https://www.saucedemo.com/";

    @Given("User success logged in to swaglab website")
    public void userSuccessLoggedInToSwaglabWebsite() {
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

    @When("Click product name")
    public void clickProductName() {
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[1]/a/div")).click();
    }

    @Then("Success view product detail")
    public void successViewProductDetail() {
        String productDesc = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[2]/div[2]")).getText();
        Assert.assertEquals(productDesc, "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        driver.close();
    }
}
