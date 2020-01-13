package io.techleadacademy.Jan12;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.techleadacademy.SeleniumWaits;

import io.techleadacademy.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;



public class PHPtrevels {
     SeleniumWaits methods = new SeleniumWaits();
    static WebDriver driver;
    static TestData fake ;


    @Test(priority = 1)
    public void getTitle() {
        SeleniumWaits methods = new SeleniumWaits();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Actions action = new Actions(driver);
        fake = new TestData();

        String expectedTitle = "PHPTRAVELS | Travel Technology Partner";
        driver.get("https://phptravels.net/home");
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @Test(priority = 2)
    public void click() {
        WebElement menuContent = driver.findElement(By.xpath("//div[@class='dropdown dropdown-login dropdown-tab']"));
        menuContent.click();
        WebElement news = menuContent.findElement(By.xpath("//*[.='Sign Up']"));
        news.click();


    }
    @Test(priority = 3)
    public void addName(){
        driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(fake.getRandomFirstName());
        driver.findElement(By.xpath("(//input[@class='form-control'])[2]")).sendKeys(fake.getRandomLastName());
        driver.findElement(By.xpath("(//input[@class='form-control'])[3]")).sendKeys(fake.getRandomPhoneNum ());
        driver.findElement(By.xpath("(//input[@class='form-control'])[4]")).sendKeys(fake.getRandomEmail());
        String password = "Assanbek9090!";
        driver.findElement(By.xpath("(//input[@class='form-control'])[5]")).sendKeys(password);
        driver.findElement(By.xpath("(//input[@class='form-control'])[6]")).sendKeys(password);
        WebElement button = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
         methods.waitForClickability(button,driver);
         button.click();
methods.sleep(2000);
    }
    @Test(priority = 4)
    public void nexPage(){
       String actual,expected;
       actual = getPageTitle();
       Assert.assertEquals(actual,"My Account");
       // expected = "Hi, "+firstName+" "+lastName;


//        expected = "Hi, "+firstName+" "+lastName;
//        actual = getAccountSay();
//        Assert.assertEquals(actual, expected);
//        DateFormat dateFormat = new SimpleDateFormat("dd MMMMM yyyy");
//        Date todaysDate = new Date();
//        expected = dateFormat.format(todaysDate);
//        actual = getAccountDay();
//        Assert.assertEquals(actual, expected);


    }

//    private String getAccountDay() {
//        return driver.getTitle();
//    }

    private String getPageTitle(){
        return driver.getTitle();
    }
    private String getAccountSay(){
        return driver.findElement(By.xpath("(//h3)[1]")).getText();
    }

}


