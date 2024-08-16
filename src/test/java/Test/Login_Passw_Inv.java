package Test;

import Base.BaseTest;
import Help.HelpMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Login_Passw_Inv extends BaseTest {
    public HelpMethod helpMethod;

    @Test
    public void invalidLogin(){
        helpMethod = new HelpMethod(driver);

        String expectedRestult = "Modă, casă & beauty | Primark";
        helpMethod.validareHomepage(expectedRestult);

        helpMethod.handleCookie();
        WebElement profileButton = driver.findElement(By.id("profile-link"));
        profileButton.click();

        //fill in all the reqired fields
        WebElement signInEmail = driver.findElement(By.id("signInName"));
        signInEmail.sendKeys("currlly18@yahoo.com");

        WebElement signInPassword = driver.findElement(By.id("password"));
        signInPassword.sendKeys("25hf7");

        helpMethod.handleCookie();
        helpMethod.scrollDown();

        WebElement conectareButton = driver.findElement(By.id("next"));
        conectareButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //verify that the login was not successful and a validation msg appears
        String expectedResInvalidPass = "Detaliile introduse nu sunt valide.";
        System.out.println("Logarea nu s-a putut efectua.");
        WebElement invalidPasswordMessage = driver.findElement(By.xpath("//div[@style='display: block;']/p"));
        helpMethod.assertLogin(invalidPasswordMessage,expectedResInvalidPass);


    }

}
