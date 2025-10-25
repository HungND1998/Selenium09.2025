package automation.testsuite;

import automation.common.CommonBase;
import automation.contant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.sql.Driver;

public class Day8_Locator extends CommonBase {

    @Test
    public void getElementById() {
        driver = initChromeDriver(CT_PageURL.RISE_URL);
        WebElement email = driver.findElement(By.id("email"));
        System.out.println("Email element is: " + email);
        WebElement password = driver.findElement(By.name("password"));
        System.out.println("PassWord element is: " + password);
    }
    @Test
    public void getElementByLinkText() {
        driver = initChromeDriver(CT_PageURL.BEPANTOAN_URL);
        WebElement mayHutMuiLink = driver.findElement(By.linkText("Máy Hút Mùi"));
        System.out.println("MayHutMuiLink element is: " + mayHutMuiLink);

        WebElement ruaVoiLink = driver.findElement(By.partialLinkText("Chậu Vòi"));
        System.out.println("ruaVoiLink element is: " + ruaVoiLink);
    }
    @Test
    public void getElementByClass_TagName() {
        driver = initChromeDriver(CT_PageURL.BEPANTOAN_URL);
        WebElement h1 = driver.findElement(By.className("inline-block"));
        System.out.println("h1 is: " + h1);

        WebElement h3 = driver.findElement(By.tagName("h3"));
        System.out.println("h3 is : " + h3);
    }
}
