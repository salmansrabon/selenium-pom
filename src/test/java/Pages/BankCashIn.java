package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankCashIn {
    WebDriver driver;
    @FindBy(linkText = "Bank Cash In")
    WebElement linkBankCashIn;
    @FindBy(linkText = "Approve")
    WebElement linkApprove;
    @FindBy(id="wallet")
    WebElement txtWallet;
    @FindBy(id="name")
    WebElement txtName;
    @FindBy(id="amount")
    WebElement txtAmount;
    @FindBy(id="description")
    WebElement txtDescription;
    @FindBy(id="updateComment")
    WebElement txtUpdateComment;
    @FindBy(id="deposit")
    WebElement btnCashIn;
    @FindBy(id="confirm")
    WebElement btnConfirm;
    @FindBy(id="approveButton")
    WebElement btnApproveButton;
    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div/div[2]/div")
    WebElement txtResult;
    public BankCashIn(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void CashInRequestByMaker(String wallet, String amount, String description) throws InterruptedException {
        linkBankCashIn.click();
        Thread.sleep(2000);
        txtWallet.sendKeys(wallet);
        Thread.sleep(2000);
        txtAmount.sendKeys(amount);
        Thread.sleep(2000);
        txtDescription.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        txtDescription.sendKeys(description);
        Thread.sleep(2000);
        btnCashIn.click();
        Thread.sleep(2000);
        btnConfirm.click();
        Thread.sleep(2000);

    }
    public void CashinApproveByChecker() throws InterruptedException {
        Thread.sleep(2000);
        linkApprove.click();
        txtUpdateComment.sendKeys("Bank Cash-in");
        Thread.sleep(1000);
        btnApproveButton.click();
        Thread.sleep(1000);
    }


}
