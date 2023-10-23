package cucumber.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class addToCart {

    WebDriver driver;

    String baseUrl = "https://www.saucedemo.com/";

    @Given("User can access Product page")
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

    @When("Click Add to cart button")
    public void clickAddToCartButton() {
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/button")).click();
    }

    @Then("Success add to cart")
    public void successAddToCart() {
        String cartBadge = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a/span")).getText();
        Assert.assertEquals(cartBadge, "1");
        driver.close();
    }


}
