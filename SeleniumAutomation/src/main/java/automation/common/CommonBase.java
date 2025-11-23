package automation.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class CommonBase {
    public static WebDriver driver;
    public WebDriver initChromeDriver(String URL) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); tăng kích thước thời gian load
        return driver;
    }

    public WebDriver initFirefoxDriver(String URL) {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get(URL);
        driver.manage().window().maximize();
         driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        return driver;
    }

    public void closeDriver() {
        if (driver != null)
            driver.close();
    }
}
