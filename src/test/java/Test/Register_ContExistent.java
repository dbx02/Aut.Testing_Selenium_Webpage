package Test;

import Base.BaseTest;
import Help.HelpMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Register_ContExistent extends BaseTest {
    public HelpMethod helpMethod;

    @Test
    public void registerWithExistingAccount(){
        helpMethod = new HelpMethod(driver);

        String expectedResult = "Modă, casă & beauty | Primark";
        helpMethod.validareHomepage(expectedResult);

        helpMethod.handleCookie();
        WebElement profileButton = driver.findElement(By.xpath("//div[@id='account-toolbar']//a[@id='profile-link']"));
        profileButton.click();

        WebElement registerButton = driver.findElement(By.xpath("//div[@class='tabs-wrapper']/a"));
        registerButton.click();

        //fill the required fields
        WebElement registerEmail = driver.findElement(By.id("email"));
        registerEmail.sendKeys("currlly18@yahoo.com");

        WebElement registerFirstName = driver.findElement(By.id("givenName"));
        registerFirstName.sendKeys("Aria");

        WebElement registerLastName = driver.findElement(By.id("surname"));
        registerLastName.sendKeys("Maior");

        WebElement dayOfBirth = driver.findElement(By.id("day-input"));
        dayOfBirth.sendKeys("25");

        WebElement monthOfBirth = driver.findElement(By.id("month-input"));
        monthOfBirth.sendKeys("10");

        WebElement yearOfBirth = driver.findElement(By.id("year-input"));
        yearOfBirth.sendKeys("1989");

        WebElement registerNewPassword = driver.findElement(By.id("newPassword"));
        registerNewPassword.sendKeys("12345ABCde*");

        WebElement reenterPassword = driver.findElement(By.id("reenterPassword"));
        reenterPassword.sendKeys("12345ABCde*");

        helpMethod.handleCookie();
        helpMethod.scrollIntoViewRegisterMessage();

        WebElement createProfileButton = driver.findElement(By.id("continue"));
        createProfileButton.click();

        // Explicit wait for the error message to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement existingUserMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='attributeVerification']//div[@class='error pageLevel'][4]")));

        helpMethod.scrollUp();

        //validate the error msg for an existing user
        String expectedResultRegisterInvalid = "Există deja un cont pentru această adresă de e-mail. Încearcă să te conectezi sau să folosești o altă adresă de e-mail pentru a te înregistra.";
        String actualMessage = existingUserMessage.getText();

        //print the actual msg for debugging purpose
        System.out.println("Actual validation message: " + actualMessage);

        //assert that the actual msg matches the expected msg
        helpMethod.assertRegisterExistingUser(existingUserMessage, expectedResultRegisterInvalid);




    }



}
