package automation.testsuite;

import automation.common.CommonBase;
import automation.contant.CT_PageURL;
import automation.pagelocator.ChangePass_Factory;
import automation.pagelocator.LoginPage_Factory_BTVN14;
import automation.pagelocator.LogoutPage_Factory_BTVN14;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class Change_PassWord extends CommonBase {
    @BeforeMethod
    public void openWebPage() {
        driver = initFirefoxDriver(CT_PageURL.VIBLO_URL);
    }

    @Test
    public void changePassWord() {
        LoginPage_Factory_BTVN14 login = new LoginPage_Factory_BTVN14(driver);
        login.loginFunction("nguyenhung1998na@gmail.com", "25252525");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ChangePass_Factory change = new ChangePass_Factory(driver);
        change.changePassFuction("25252525", "12345678", "12345678");
//        Đã đổi mật khẩu thành công,đăng xuất và đăng nhập lại bằng mật khẩu mới
        LogoutPage_Factory_BTVN14 logout = new LogoutPage_Factory_BTVN14(driver);
        logout.LogoutFunction();
        WebElement loginTitle = driver.findElement(By.xpath("//h5[text()='Đăng nhập vào Viblo']"));
        assertTrue(loginTitle.isDisplayed(), "Đăng xuất thất bại - không quay về trang đăng nhập");
        // Đăng xuất thành công
        LoginPage_Factory_BTVN14 loginNewPass = new LoginPage_Factory_BTVN14(driver);
        loginNewPass.loginFunction("nguyenhung1998na@gmail.com", "12345678");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Trang Chủ']")).isDisplayed());
        // Đăng nhập với mật khẩu mới thành công
    }
}
