import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;


    public MainPage(WebDriver driver) {

        this.driver = driver;
    }

    private By signInButton = By.xpath("//a[@class='HeaderMenu-link no-underline mr-3']");
    private By signUpButton = By.xpath("//a[contains(@class,'HeaderMenu-link d-inline-block')]");
    private By userNameField = By.xpath("//input[@id='user[login]']");
    private By passwordField = By.xpath("//input[@id='user[password]']");
    private By emailField = By.xpath("//input[@id='user[email]']");
    private By signUpFormButton = By.xpath("(//button[text()='Sign up for GitHub'])[1]");

    public LoginPage clickSignInButton() {

        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUpButton() {

        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpFormButton() {

        driver.findElement(signUpFormButton).click();
        return new SignUpPage(driver);
    }

    public MainPage typeUsername(String username) {
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public MainPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public MainPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage reregister(String username, String password, String email) {
        this.typeUsername(username);
        this.typePassword(password);
        this.typeEmail(email);
        this.clickSignUpFormButton();
        return new SignUpPage(driver);
    }

}
