package uiseleniumtest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CustomersTests {

    WebDriver driver;
    String baseURL;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "https://github.com/PiotrSzyszko/UItest/blob/master/src/resources/chromedriver.exe");
        Dimension d = new Dimension(1280,860);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        baseURL = "file:///C:/Users/lenovo/Documents/Udemy/hsbc/index.html";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(d);
    }

    @Test
    public void matchingNameNonCaseSensitive() {
        driver.get(baseURL);

        List<WebElement> rowsAllBefore = driver.findElements(By.cssSelector("tr.ng-scope"));
        List<WebElement> rowsBefore = driver.findElements(By.xpath("//tr//td[contains(text(),'stim')]"));

        //System.out.println("size before: " + rowsBefore.size());
        WebElement element = driver.findElement(By.id("search-column"));
        Select sel = new Select(element);

        sel.selectByIndex(1);


        driver.findElement(By.xpath("//*[@id=\"search-input\"]")).sendKeys("stim");

        List<WebElement> rowsAfter = driver.findElements(By.cssSelector("tr.ng-scope"));
        //System.out.println("size after: " + rowsAfter.size());

        Assert.assertTrue(rowsAfter.size() == rowsBefore.size());
        Assert.assertTrue(driver.findElement(By.xpath("//tr/td[2]")).getText().toString().contains("stim"));

        try {
            Thread.sleep(2500);
        } catch(InterruptedException e) {
            System.out.println("Problem in call: Thread.sleep(1000). Error: " + e.toString());
        }

        driver.findElement(By.id("clear-button")).click();

        List<WebElement> rowsAllAfter = driver.findElements(By.cssSelector("tr.ng-scope"));
        Assert.assertTrue(rowsAllAfter.size() == rowsAllBefore.size());

    }



    @Test
    public void matchingCityCaseSensitive() {
        driver.get(baseURL);

        List<WebElement> rowsAllBefore = driver.findElements(By.cssSelector("tr.ng-scope"));
        List<WebElement> rowsBeforeCaseSensitive = driver.findElements(By.xpath("//tr//td[contains(text(),'Belf')]"));
        List<WebElement> rowsBeforeNonCaseSensitive = driver.findElements(By.xpath("//tr//td[contains(text(),'belf')]"));


        //System.out.println("size before: " + rowsBeforeCaseSensitive.size());
        WebElement element = driver.findElement(By.id("search-column"));
        Select sel = new Select(element);
        sel.selectByVisibleText("City");


        driver.findElement(By.id("match-case")).click();

        driver.findElement(By.xpath("//*[@id=\"search-input\"]")).sendKeys("Belf");

        List<WebElement> rowsAfterCaseSensitive = driver.findElements(By.cssSelector("tr.ng-scope"));
        //System.out.println("size after: " + rowsAfter.size());

        Assert.assertTrue(rowsAfterCaseSensitive.size() == rowsBeforeCaseSensitive.size());
        Assert.assertTrue(driver.findElement(By.xpath("//tr/td[4]")).getText().toString().contains("Belf"));

        try {
            Thread.sleep(2500);
        } catch(InterruptedException e) {
            System.out.println("Problem in call: Thread.sleep(1000). Error: " + e.toString());
        }

        driver.findElement(By.id("clear-button")).click();
        driver.findElement(By.xpath("//*[@id=\"search-input\"]")).sendKeys("belf");

        List<WebElement> rowsAfterNonCaseSensitive = driver.findElements(By.cssSelector("tr.ng-scope"));
        //System.out.println("size after: " + listAfterNonCaseSensitive.size());

        Assert.assertTrue(rowsAfterNonCaseSensitive.size() == rowsBeforeNonCaseSensitive.size());

        try {
            Thread.sleep(2500);
        } catch(InterruptedException e) {
            System.out.println("Problem in call: Thread.sleep(1000). Error: " + e.toString());
        }

        driver.findElement(By.id("clear-button")).click();

        List<WebElement> rowsAllAfter = driver.findElements(By.cssSelector("tr.ng-scope"));
        Assert.assertTrue(rowsAllAfter.size() == rowsAllBefore.size());

    }



    @Test
    public void matchingEmailWithCity() {
        driver.get(baseURL);

        List<WebElement> rowsAllBefore = driver.findElements(By.cssSelector("tr.ng-scope"));
        List<WebElement> rowsBefore = driver.findElements(By.xpath("//tr//td[contains(text(),'@')]"));

        //System.out.println("size before: " + rowsBefore.size());
        WebElement element = driver.findElement(By.id("search-column"));
        Select sel = new Select(element);

        sel.selectByVisibleText("City");


        driver.findElement(By.xpath("//*[@id=\"search-input\"]")).sendKeys("@");

        List <WebElement> listAfter = driver.findElements(By.cssSelector("tr.ng-scope"));
        System.out.println("size after: " + listAfter.size());

        Assert.assertTrue(listAfter.size() == rowsBefore.size());

        try {
            Thread.sleep(2500);
        } catch(InterruptedException e) {
            System.out.println("Problem in call: Thread.sleep(1000). Error: " + e.toString());
        }

        driver.findElement(By.id("clear-button")).click();

        List<WebElement> rowsAllAfter = driver.findElements(By.cssSelector("tr.ng-scope"));
        Assert.assertTrue(rowsAllAfter.size() == rowsAllBefore.size());

    }


    @AfterClass
    public void cleanUp() throws Exception {
        try {
            Thread.sleep(2500);
        } catch(InterruptedException e) {
            System.out.println("Problem in call: Thread.sleep(1000). Error: " + e.toString());
        }
        driver.quit();
    }
}
