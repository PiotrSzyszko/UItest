package uiseleniumtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverWindows {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Documents\\Udemy\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

    }
}
