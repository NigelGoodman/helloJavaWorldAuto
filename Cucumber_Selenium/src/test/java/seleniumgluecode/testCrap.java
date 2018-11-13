package seleniumgluecode;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class testCrap 
{
    public static WebDriver driver;
    
    
    @Given("^the user is on lichess$")
    public void the_user_is_on_lichess() throws Throwable 
    {
        // Write code here that turns the phrase above into concrete actions
    	System.setProperty("webdriver.gecko.driver","geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://lichess.org/");
    }

    @Given("^they hover over the tools menu$")
    public void they_hover_over_the_tools_menu() throws Throwable 
    {
    	Actions moveOverItem = new Actions(driver);
    	moveOverItem.moveToElement(driver.findElement(By.cssSelector("#topmenu > section:nth-child(5) > a:nth-child(1)"))).build().perform();

    }

    @When("^they click on Analysis board$")
    public void they_click_on_Analysis_board() throws Throwable 
    {
        driver.findElement(By.linkText("Analysis board")).click();
    }

    @Then("^They are taken to the analysis board$")
    public void they_are_taken_to_the_analysis_board() throws Throwable 
    {
        Assert.assertArrayEquals("You are actually on " + driver.getTitle(), driver.getTitle().toCharArray(), "Analysis board • lichess.org".toCharArray());
        driver.close();
    }
    
    @Given("^the user is on the analysis board$")
    public void the_user_is_on_the_analysis_board() throws Throwable 
    {
        this.the_user_is_on_lichess();
        this.they_hover_over_the_tools_menu();
        this.they_click_on_Analysis_board();
    }

    @When("^they turn the analysis on$")
    public void they_turn_the_analysis_on() throws Throwable 
    {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.className("switch")).click();
    }

    @Then("^analysis activates$")
    public void analysis_activates() throws Throwable 
    {
    	
        //String joe = driver.findElement(By.tagName("pearl")).getText();
    	WebDriverWait wait = new WebDriverWait(driver, 20);
    	wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.tagName("pearl")), "+0.2"));
    	Assert.assertArrayEquals("actualText " + driver.findElement(By.tagName("pearl")).getText(), "+0.2".toCharArray(), driver.findElement(By.tagName("pearl")).getText().toCharArray());
        driver.close();
    }


    //sample crap
    @Given("^user is on homepage$")
    public void user_is_on_homepage() throws Throwable 
    {     	
    	System.setProperty("webdriver.gecko.driver","geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://portfolio.inazuma.org/");
    }
    
    @When("^user navigates to Login Page$")
    public void user_navigates_to_Login_Page() throws Throwable 
    {
        //driver.findElement(By.linkText("Sign in")).click();
    	driver.findElement(By.cssSelector(".menu > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(1) > a:nth-child(1)"));
    }
    
    @When("^user enters username and Password$")
    public void user_enters_username_and_Password() throws Throwable {
    	driver.findElement(By.id("email")).sendKeys("blog.cucumber@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Cucumber@blog");
        driver.findElement(By.id("SubmitLogin")).click();   
    }
    
    @Then("^success message is displayed$")
    public void success_message_is_displayed() throws Throwable {
    	String exp_message = "Welcome to your account. Here you can manage all   of your personal information and orders.";
    	String actual = driver.findElement(By.cssSelector(".info-account")).getText();
        Assert.assertEquals(exp_message, actual);
        driver.quit();  
    }      
    
    @When("^user goes to Grid FAQ$")
    public void user_goes_to_Grid_FAQ() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	driver.findElement(By.cssSelector(".menu > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(1) > a:nth-child(1)")).click();

    }

    @When("^user clicks option eight$")
    public void user_clicks_option_eight() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @Then("^the view the musical formats explaination$")
    public void the_view_the_musical_formats_explaination() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

}