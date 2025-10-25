package automation.testsuite;

import automation.common.CommonBase;
import automation.contant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class practiceXpathDay8 extends CommonBase {

    @Test
    public void getElementById() {
        driver = initChromeDriver(CT_PageURL.GITHUB_URL);

        WebElement name = driver.findElement(By.name("name"));
        System.out.println("Name element is: " + name);

        WebElement address = driver.findElement(By.name("address"));
        System.out.println("Address element is: " + address);

        WebElement email = driver.findElement(By.name("email"));
        System.out.println("Address element is: " + email);

        WebElement pass = driver.findElement(By.name("password"));
        System.out.println("Address element is: " + pass);
    }
}
