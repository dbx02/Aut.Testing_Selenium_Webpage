package Test;

import Base.BaseTest;
import Help.HelpMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Register extends BaseTest {
    public HelpMethod helpMethod;

    @Test
    public void completeRegister(){
        helpMethod = new HelpMethod(driver);

        String expectedResult = "Modă, casă & beauty | Primark";
        helpMethod.validareHomepage(expectedResult);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        helpMethod.handleCookie();

        WebElement profileButton = driver.findElement(By.id("profile-link"));
        profileButton.click();

        WebElement registerButton = driver.findElement(By.xpath("//a[contains(text(), 'Înregistrare')]"));
        registerButton.click();

        // Generate a unique email address directly in the test method
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
        int randomNum = new Random().nextInt(1000);
        String uniqueEmail = "testuser" + timestamp + randomNum + "@example.com";

        System.out.println("Generated unique email: " + uniqueEmail);

        //fill in the required fields
        WebElement registerEmail = driver.findElement(By.id("email"));
        registerEmail.sendKeys(uniqueEmail);

        WebElement registerFirstName = driver.findElement(By.id("givenName"));
        registerFirstName.sendKeys("Aria Manuela");

        WebElement registerLastName = driver.findElement(By.id("surname"));
        registerLastName.sendKeys("Maior");

        WebElement dayOfBirth = driver.findElement(By.id("day-input"));
        dayOfBirth.sendKeys("15");

        WebElement monthOfBirth = driver.findElement(By.id("month-input"));
        monthOfBirth.sendKeys("09");

        WebElement yearOfBirth = driver.findElement(By.id("year-input"));
        yearOfBirth.sendKeys("1995");

        WebElement registerNewPassword = driver.findElement(By.id("newPassword"));
        registerNewPassword.sendKeys("12345ABCde*");

        WebElement reenterPassword = driver.findElement(By.id("reenterPassword"));
        reenterPassword.sendKeys("12345ABCde*");

        helpMethod.handleCookie();
        helpMethod.scrollIntoViewRegister();
        helpMethod.scrollDown();

        //click the register button
        WebElement createProfileButton = driver.findElement(By.id("continue"));
        createProfileButton.click();

        //verify if profile page will open
        helpMethod.assertRegister();


    }

}
