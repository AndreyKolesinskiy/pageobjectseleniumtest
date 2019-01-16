import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//*[text()='Join GitHub']");
    private By userNameField = By.xpath("//input[@name='user[login]']");
    private By emailField = By.xpath("//input[@name='user[email]']");
    private By passwordField = By.xpath("//input[@name='user[password]']");
    private By signUpButton = By.xpath("//button[@id='signup_button']");
    private By mainError = By.xpath("//input[@name='user[login]']/ancestor::auto-check/preceding-sibling::div[contains(@class, 'flash-error')]");
    private By userNameError = By.xpath("//input[@name='user[login]']/ancestor::dd/following-sibling::dd[contains(@class, 'error')]");
    private By emailError = By.xpath("//input[@name='user[email]']/ancestor::dd/following-sibling::dd[contains(@class, 'error')]");
    private By passwordError = By.xpath("//input[@name='user[password]']/ancestor::dd/following-sibling::dd[contains(@class, 'error')]");

    public SignUpPage typeUsername(String username) {
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public SignUpPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage reregisterWithInvalidCreds(String username, String password, String email) {
        this.typeUsername(username);
        this.typePassword(password);
        this.typeEmail(email);
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    public String getMainErrorText() {
        return driver.findElement(mainError).getText();
    }

    public String getUserNameErrorText() {
        return driver.findElement(userNameError).getText();
    }

    public String getEmailErrorText() {
        return driver.findElement(emailError).getText();
    }

    public String getPasswordErrorText() {
        return driver.findElement(passwordError).getText();
    }


}