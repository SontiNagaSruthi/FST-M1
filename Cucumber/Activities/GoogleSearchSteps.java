package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    @Given("^User is on the google home page$")
    public void Userisonthegooglehomepage()
    {
        driver=new FirefoxDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://google.com");
    }

    @When("^User types in cheese and hit enter$")
    public void Usertypesincheeseandhitenter()
    {
        driver.findElement(By.name("q")).sendKeys("Cheese", Keys.RETURN);
    }

    @Then("^Show how many test results are generated$")
    public void Showhowmanytestresultsaregenerated()
    {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("result-stats")));
        String resultStats = driver.findElement(By.id("result-stats")).getText();
        System.out.println("Number of results found: " + resultStats);
    }

    @And("^Close the browser$")
    public void closeTheBrowser() throws Throwable {
        driver.close();
    }
}
