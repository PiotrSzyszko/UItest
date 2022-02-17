package uiseleniumtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverWindows {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "c:\\Users\\User\\Documents\\GitHub\\UItest\\src\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

    }
}
