package uiseleniumtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverWindows {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "https://github.com/PiotrSzyszko/UItest/blob/master/src/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

    }
}
