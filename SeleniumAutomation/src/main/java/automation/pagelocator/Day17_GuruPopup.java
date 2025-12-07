package automation.pagelocator;

import automation.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Day17_GuruPopup extends CommonBase {
    private WebDriver driver;

    public Day17_GuruPopup(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public void getAccessDetail() {
        type(By.name("emailid"), "randomemail@gmail.com");
        click(By.name("btnLogin"));

    }
}
