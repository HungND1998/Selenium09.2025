package automation.testsuite;

import automation.common.CommonBase;
import automation.contant.CT_PageURL;
import automation.pagelocator.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class LoginTest extends CommonBase {
    @BeforeMethod
    public void openWebPage() {
        driver = initFirefoxDriver(CT_PageURL.CRM_URL);
    }

    @Test
    public void loginSuccessfully() {
        LoginPage login = new LoginPage(driver);
        login.loginFunction("admin@gmail.com", "12345678");
        WebElement textQuanLyND = driver.findElement(By.xpath("//p[text()='Quản lý người dùng']"));
        assertTrue(textQuanLyND.isDisplayed(), "Đăng nhập thành công!");
    }

    @Test
    public void loginFail_IncorrectPass() {
        LoginPage login = new LoginPage(driver);
        login.loginFunction("admin@gmail.com", "12345678888");
        WebElement textDangNhap = driver.findElement(By.xpath("//h4[text()='Đăng nhập']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertTrue(textDangNhap.isDisplayed(),
                "FAIL: Hệ thống KHÔNG hiển thị trang Đăng nhập khi sai password!");
    }

    @Test
    public void loginFail_IncorrectUserName() {
        LoginPage login = new LoginPage(driver);
        login.loginFunction("admin_incorrect@gmail.com", "12345678");
        WebElement textDangNhap = driver.findElement(By.xpath("//h4[text()='Đăng nhập']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertTrue(textDangNhap.isDisplayed(),
                "FAIL: Hệ thống KHÔNG hiển thị trang Đăng nhập khi sai cả email! ");
    }

    @Test
    public void loginFail_IncorrectUserNameAndPass() {
        LoginPage login = new LoginPage(driver);
        login.loginFunction("admin_incorrect@gmail.com", "12345678888");
        WebElement textDangNhap = driver.findElement(By.xpath("//h4[text()='Đăng nhập']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertTrue(textDangNhap.isDisplayed(),
                "FAIL: Hệ thống KHÔNG hiển thị trang Đăng nhập khi sai cả email và password!");
    }
}
