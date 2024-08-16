package Test;

import Base.BaseTest;
import Help.HelpMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

//Toate Clasele de test din acest fisier contin pasii pe care trebuie sa ii executam
public class Login extends BaseTest {
    public HelpMethod helpMethod;

    @Test
    public  void completeLogin(){
        helpMethod = new HelpMethod(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        String expectedResult = "Modă, casă & beauty | Primark";
        helpMethod.validareHomepage(expectedResult);

        helpMethod.handleCookie();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // First interaction with the profile button and wait for it to be visible
        WebElement profileButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("profile-link")));
        profileButton.click();

//        WebElement profileButton = driver.findElement(By.id("profile-link"));
//        profileButton.click();

        WebElement signInEmail = driver.findElement(By.id("signInName"));
        signInEmail.sendKeys("maioraria25@yahoo.com");

        WebElement signInPassword = driver.findElement(By.id("password"));
        signInPassword.sendKeys("12345abcdE25*");

        helpMethod.handleCookie();

        helpMethod.scrollDown();

        WebElement conectareButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("next")));
        conectareButton.click();

//        WebElement conectareButton = driver.findElement(By.id("next"));
//        conectareButton.click();

        //assert if the user profile page is open after login
        helpMethod.assertUserProfilePageIsDisplayed();


    }


}
