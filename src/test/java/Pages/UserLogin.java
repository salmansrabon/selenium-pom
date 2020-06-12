package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLogin {

    public UserLogin(WebDriver driver){


        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    WebDriver driver;
    @FindBy(id="userName")
    WebElement txtUserName;
    @FindBy(id="password")
    WebElement txtPassword;
    @FindBy(id="confirm")
    WebElement btnLogin;
    @FindBy(className = "logo-lg")
    WebElement linkHomePageObject;
    @FindBy(linkText = "Logout")
    WebElement linkLogout;

    public void doUserLogin(String UserName,String Password) throws InterruptedException {
        Thread.sleep(1000);
        txtUserName.sendKeys(UserName);
        txtPassword.sendKeys(Password);
        Thread.sleep(1000);
        btnLogin.click();

    }
    public void doLogout() throws InterruptedException {
        linkLogout.click();
    }
}
