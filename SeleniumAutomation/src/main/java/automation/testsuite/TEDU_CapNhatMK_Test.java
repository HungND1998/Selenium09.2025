package automation.testsuite;

import automation.common.CommonBase;
import automation.contant.CT_PageURL;
import automation.pagelocator.Tedu_CapNhatMK_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TEDU_CapNhatMK_Test extends CommonBase {

    @BeforeMethod
    public void openWebPage() {
        driver = initFirefoxDriver(CT_PageURL.TEDU_URL);
    }

    @Test
    public void loginSuccessfully() {
        Tedu_CapNhatMK_Page tedu = new Tedu_CapNhatMK_Page(driver);
        tedu.loginFunction("hungnd621@wru.vn", "12345678");
        WebElement avatar = driver.findElement(By.xpath("//a[@title='Tài khoản' and @data-toggle='dropdown']"));
        Assert.assertTrue(avatar.isDisplayed());
    }

    @Test
    public void updatePasswordSuccessfully() {
        loginSuccessfully();
        Tedu_CapNhatMK_Page tedu = new Tedu_CapNhatMK_Page(driver);
        tedu.changePassword("12345678", "12345678");
        WebElement avatar = driver.findElement(By.xpath("//h2[text()='Đăng nhập']"));
        Assert.assertTrue(avatar.isDisplayed());
    }
}
