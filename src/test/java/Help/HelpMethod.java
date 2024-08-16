package Help;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

//Clasa HelpMethod contine metodele generale (scroll,assert, pop-up,etc.) pe care le apelam astfel incat sa nu incarcam codul
public class HelpMethod {
    private WebDriver driver;

    public HelpMethod(WebDriver driver){
        this.driver = driver;
    }

    public void validareHomepage(String expectedTitle){
        String actualResult =  driver.getTitle();
        Assert.assertTrue(actualResult.equals(expectedTitle), "The title is not correct!");
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }

    public void scrollUp(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-350)", "");
    }

    public void scrollIntoViewRegister(){
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        WebElement Stop = driver.findElement(By.id("continue"));
        js1.executeScript("arguments[0].scrollIntoView(true);", Stop);
    }

    public  void  assertLogin (WebElement element, String nume){
        Assert.assertTrue(element.getText().equals(nume), "Wrong unser or password.");
    }

    public void assertUserProfilePageIsDisplayed(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement profileElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".css-g9ki7z")));

            Assert.assertTrue(profileElement.isDisplayed(), "Profile element is not visible");
        } catch (Exception e) {
            throw new AssertionError("User profile page did not load successfully.", e);
        }
    }

    public void assertRegister(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement registerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='MuiContainer-root css-1qjj9i6']/h4")));
        Assert.assertTrue(registerElement.isDisplayed(), "Register element is not visible.");
    }

    public  void  assertRegisterExistingUser (WebElement actualMessageElement, String expectedMessage){
        String actualMessage = actualMessageElement.getText();
        assert actualMessage.equals(expectedMessage) : "Validation message mismatch! Expected: " + expectedMessage + " but found: " + actualMessage;

    }

    public void scrollIntoViewRegisterMessage(){
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        WebElement Stop = driver.findElement(By.id("claimVerificationServerError"));
        js1.executeScript("arguments[0].scrollIntoView(true);", Stop);
    }

    public void assertExpectedSearch(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement expectedSearchElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-results-header")));
            Assert.assertTrue(expectedSearchElement.isDisplayed(), "Search element is not visible");
        }catch (Exception e) {
            throw new AssertionError("Search page did not load successfully.", e);
        }
    }

    public void assertWrongSearch(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement expectedSearchElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("no-result")));
            Assert.assertTrue(expectedSearchElement.isDisplayed(), "Sorry, there is no result for the searched items");
        }catch (Exception e) {
            throw new AssertionError("Search page did not load successfully.", e);
        }
    }

    public void scrollIntoViewAddList(){
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        WebElement Stop = driver.findElement(By.xpath("//button[contains(@class, 'MuiButtonBase-root') and @aria-label='add to shopping list']"));
        js1.executeScript("arguments[0].scrollIntoView(true);", Stop);
    }

    public void assertAddProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Adăugat în Lista de cumpărături')]")));
        Assert.assertTrue(addProduct.isDisplayed(), "The product was not added to shopping list");
    }

    public void assertDeleteItem(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement deleteItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ProductCardRemoved-removedProductDescription MuiBox-root css-0']/div")));
        Assert.assertTrue(deleteItem.isDisplayed(), "The item was not deleted.");
    }

    public void assertChooseItem(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement chooseItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='mui-40']//li[2]")));
        Assert.assertTrue(chooseItem.isDisplayed(), "No size was selected.");
    }

    public void handlePopup() {
        try {
            // Wait for a maximum of 15 seconds for the pop-up to appear
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement closePopUp = driver.findElement(By.xpath("//button[@aria-label='Close Popup']"));
            closePopUp.click();
        } catch (NoSuchElementException e) {
            // If the pop-up does not appear, continue without throwing an exception
            System.out.println("Pop-up not found, continuing with the test.");
        }
    }

    public void handleCookie(){
        try {
            // Wait for a maximum of 15 seconds for the pop-up to appear
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement closeCookie = driver.findElement(By.id("onetrust-accept-btn-handler"));
            closeCookie.click();
        } catch (NoSuchElementException e) {
            // If the pop-up does not appear, continue without throwing an exception
            System.out.println("Cookie not found, continuing with the test.");
        }
    }



}













