import Pages.Login;
import Pages.WebFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class seleniumTest {

    Login Login = new Login();
    WebDriver driver = WebDriverFactory.Browsers.CHROME.create();
    WebFormPage WebFormPage;

    @BeforeTest
    public void setUp() {
        WebFormPage = new WebFormPage(driver);
        WebFormPage.openUrlPage();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void logIn() {
        driver.findElement(By.xpath("//img[@title]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
        driver.findElement(By.id("email")).sendKeys(Login.getLogin());
        driver.findElement(By.id("pass")).sendKeys(Login.getPassword());
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.xpath("(//button[@class='action switch'])[1]")).click();
        String checkInText = driver.findElement(By.xpath("(//li//a)[3]")).getText();
        assertEquals("Sign Out", checkInText);
        driver.findElement(By.xpath("(//li//a)[3]")).click();
    }

    @Test(priority = 2)
    public void checkingFilters() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5000,
                TimeUnit.MILLISECONDS);
        WebFormPage = new WebFormPage(driver);
        WebFormPage.getSale().click();
        driver.findElement(By.xpath("(//a[text()='Hoodies and Sweatshirts'])[1]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Size')]")).click();
        driver.findElement(By.xpath("//div[text()='S' and @tabindex='-1']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Color')]")).click();
        driver.findElement(By.xpath("//div[@option-id='60' and @tabindex='-1']")).click();
        String searchText = driver.findElement(By.xpath("//a[contains(text(),'Helena Hooded Fleece')]")).getText();
        assertEquals("Helena Hooded Fleece", searchText);
    }

    //*[@id="shopping-cart-table"]
    @Test(priority = 3)
    public void addItem() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5000,
                TimeUnit.MILLISECONDS);
        WebFormPage = new WebFormPage(driver);
        WebFormPage.getLogoButton().click();
        WebFormPage.getSale().click();
        driver.findElement(By.xpath("(//a[text()='Hoodies and Sweatshirts'])[1]")).click();
        driver.findElement(By.xpath("//img[@alt='Circe Hooded Ice Fleece']")).click();
        driver.findElement(By.xpath("//div[@id='option-label-size-143-item-166']")).click();
        driver.findElement(By.xpath("//div[@id='option-label-color-93-item-52']")).click();
        WebFormPage.getAddToCart().click();
        String shoppingCart = WebFormPage.getShoppingCart().getText();
        assertNotNull(shoppingCart);
        WebFormPage.getShoppingCart().click();
    }

    @Test(priority = 4)
    public void removeItem() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5000,
                TimeUnit.MILLISECONDS);
        WebFormPage = new WebFormPage(driver);
        WebFormPage.getLogoButton().click();
        WebFormPage.getSale().click();
        driver.findElement(By.xpath("(//a[text()='Hoodies and Sweatshirts'])[1]")).click();
        driver.findElement(By.xpath("//img[@alt='Circe Hooded Ice Fleece']")).click();
        driver.findElement(By.xpath("//div[@id='option-label-size-143-item-166']")).click();
        driver.findElement(By.xpath("//div[@id='option-label-color-93-item-52']")).click();
        WebFormPage.getAddToCart().click();
        WebFormPage.getShoppingCart().click();
        driver.findElement(By.xpath("//a[@title='Edit item parameters']")).click();
        driver.findElement(By.xpath("//div[@id='option-label-size-143-item-168']")).click();
        driver.findElement(By.xpath("//div[@id='option-label-color-93-item-53']")).click();
        driver.findElement(By.xpath("//input[@id='qty']")).sendKeys("2");
        driver.findElement(By.xpath("//button[@id='product-updatecart-button']")).click();
        WebFormPage.getRemoveCart().click();
        String emptyCart = driver.findElement(By.xpath("//div[@class='cart-empty']")).getText();
        assertEquals("You have no items in your shopping cart.\n" + "Click here to continue shopping.", emptyCart);
    }

    @Test(priority = 5)
    public void fieldValidationCreateAnAccount() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5000,
                TimeUnit.MILLISECONDS);
        WebFormPage = new WebFormPage(driver);
        WebFormPage.getLogoButton().click();
        WebFormPage.getCreateAnAccount().click();
        driver.findElement(By.id("firstname")).sendKeys("Test");
        String firstName = driver.findElement(By.id("firstname")).getText();
        assertNotNull(firstName);
        driver.findElement(By.id("lastname")).sendKeys("Testing");
        String lastName = driver.findElement(By.id("lastname")).getText();
        assertNotNull(lastName);
        driver.findElement(By.id("email_address")).sendKeys(Login.getLogin());
        String emailAddress = driver.findElement(By.id("email_address")).getText();
        assertNotNull(emailAddress);
        driver.findElement(By.id("password")).sendKeys(Login.getPassword());
        String password = driver.findElement(By.id("password")).getText();
        assertNotNull(password);
        driver.findElement(By.id("password-confirmation")).sendKeys("testNGtest1996");
        String passwordConfirmation = driver.findElement(By.id("password-confirmation")).getText();
        assertNotNull(passwordConfirmation);
        driver.findElement(By.xpath("(//span[text()='Create an Account'])[1]")).click();
        String error = driver.findElement(By.xpath("//a[text()='click here']")).getText();
        assertEquals("click here", error);
    }
}
