package automation.testsuite;

import automation.common.CommonBase;
import automation.contant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TS_PracticeElement extends CommonBase {

    @Test
    public void getElementById() {
        driver = initChromeDriver(CT_PageURL.SELECT_URL);
        WebElement email = driver.findElement(By.name("email"));
        System.out.println("Email element is: " + email);

        WebElement pass = driver.findElement(By.name("Password"));
        System.out.println("PassWord element is: " + pass);

        WebElement company = driver.findElement(By.name("company"));
        System.out.println("Company element is: " + company);

        WebElement mobile = driver.findElement(By.name("mobile number"));
        System.out.println("Mobile number element is: " + mobile);
    }
}
