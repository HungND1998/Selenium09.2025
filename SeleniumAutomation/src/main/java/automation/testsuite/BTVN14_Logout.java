package automation.testsuite;

import automation.common.CommonBase;
import automation.contant.CT_PageURL;
import automation.pagelocator.LoginPage_Factory_BTVN14;
import automation.pagelocator.LogoutPage_Factory_BTVN14;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class BTVN14_Logout extends CommonBase {
    @BeforeMethod
    public void openWebPage() {
        driver = initFirefoxDriver(CT_PageURL.VIBLO_URL);
    }

    @Test
    public void logoutSuccessfully() {
        LoginPage_Factory_BTVN14 login = new LoginPage_Factory_BTVN14(driver);
        login.loginFunction("nguyenhung1998na@gmail.com", "12345678");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LogoutPage_Factory_BTVN14 logout = new LogoutPage_Factory_BTVN14(driver);
        logout.LogoutFunction();
        WebElement loginTitle = driver.findElement(By.xpath("//h5[text()='Đăng nhập vào Viblo']"));
        assertTrue(loginTitle.isDisplayed(), "Đăng xuất thất bại - không quay về trang đăng nhập");
    }
}
