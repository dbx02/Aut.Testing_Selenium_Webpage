package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

//clasa BaseTest contine tot ce exista la preconditii pt testul nostru(@before-test) dar si @after-testul
public class BaseTest {
    public WebDriver driver;

    @BeforeMethod

    public void openWebsite() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);

//        driver = new ChromeDriver();
        driver.get("https://www.primark.com/ro-ro");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterMethod

    public void closeWebsite() {

        //when driver is closed,all necesarry settings are applied before a new driver is opened.
        if (driver != null){
            driver.quit();
        }

//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
//       driver.quit();
    }


}