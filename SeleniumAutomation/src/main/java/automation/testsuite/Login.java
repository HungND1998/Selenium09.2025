package automation.testsuite;

import automation.common.CommonBase;
import automation.contant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class Login extends CommonBase {

    @BeforeMethod
    public void openWebPage() {
        driver = initFirefoxDriver(CT_PageURL.CRM_URL);
    }

    @Test
    public void loginSuccessfully() {
        WebElement textEmail = driver.findElement(By.id("email"));
        if (textEmail.isDisplayed()) {
            textEmail.sendKeys("admin@gmail.com");
        }
        WebElement textPass = driver.findElement(By.id("password"));
        if (textPass.isDisplayed()) {
            textPass.sendKeys("12345678");
        }
        driver.findElement(By.name("signin")).click();
//        driver.switchTo().alert().accept();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement textQuanLyND = driver.findElement(By.xpath("//p[text()='Quản lý người dùng']"));
        assertTrue(textQuanLyND.isDisplayed());
    }

    @Test
    public void loginFail_IncorrectUsername() {
        WebElement textEmail = driver.findElement(By.id("email"));
        if (textEmail.isDisplayed()) {
            textEmail.sendKeys("admin_incorrect@gmail.com");
        }
        WebElement textPass = driver.findElement(By.id("password"));
        if (textPass.isDisplayed()) {
            textPass.sendKeys("12345678");
        }
        driver.findElement(By.name("signin")).click();
//        driver.switchTo().alert().accept();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement textDangNhap = driver.findElement(By.xpath("//h4[text()='Đăng nhập']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertTrue(textDangNhap.isDisplayed());

    }

    @Test
    public void loginFail_IncorrectPass() {
        WebElement textEmail = driver.findElement(By.id("email"));
        if (textEmail.isDisplayed()) {
            textEmail.sendKeys("admin@gmail.com");
        }
        WebElement textPass = driver.findElement(By.id("password"));
        if (textPass.isDisplayed()) {
            textPass.sendKeys("12345678_incorrect");
        }
        driver.findElement(By.name("signin")).click();
//        driver.switchTo().alert().accept();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement textDangNhap = driver.findElement(By.xpath("//h4[text()='Đăng nhập']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertTrue(textDangNhap.isDisplayed());

    }

    @Test
    public void loginFail_IncorrectUserNameAndPass() {
        WebElement textEmail = driver.findElement(By.id("email"));
        if (textEmail.isDisplayed()) {
            textEmail.sendKeys("admin_incorrect@gmail.com");
        }
        WebElement textPass = driver.findElement(By.id("password"));
        if (textPass.isDisplayed()) {
            textPass.sendKeys("12345678_incorrect");
        }
        driver.findElement(By.name("signin")).click();
//        driver.switchTo().alert().accept();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement textDangNhap = driver.findElement(By.xpath("//h4[text()='Đăng nhập']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertTrue(textDangNhap.isDisplayed());

    }
}
