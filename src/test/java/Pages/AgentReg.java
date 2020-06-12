package Pages;

import Utility.InputHandler;
import Utility.Util;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class AgentReg {
    WebDriver driver;
    @FindBy(linkText = "Agent/Distributor Registration")
    WebElement linkAgentReg;
    @FindBy(id="userType")
    WebElement listUserType;
    @FindBy(id="distributorWallet")
    WebElement listDistributorWallet;
    @FindBy(id="fullName")
    WebElement txtFullName;
    @FindBy(id="mobilePhone")
    WebElement txtMobileNumber;
    @FindBy(id="nameOfProprietor")
    WebElement txtProprietorName;

    @FindBy(id="addressOffice")
    WebElement txtOfficeAddress;
    @FindBy(id="villageAreaOffice")
    WebElement txtVillageAreaOffice;
    @FindBy(id="districtOffice")
    WebElement listDistrictOffice;
    @FindBy(id="psThanaOffice")
    WebElement listThanaOffice;

    @FindBy(id="addressPresent")
    WebElement txtPresentAddress;
    @FindBy(id="villageAreaPresent")
    WebElement txtVillageAreaPresent;
    @FindBy(id="districtPresent")
    WebElement listDistrictPresent;
    @FindBy(id="psThanaPresent")
    WebElement listThanaPresent;

    @FindBy(id="businessRegionId")
    WebElement listBusinessRegion;
    @FindBy(id="businessAreaId")
    WebElement listBusinessArea;
    @FindBy(id="businessTerritoryId")
    WebElement listBusinessTerritory;

    @FindBy(id="bankName")
    WebElement listBankName;
    @FindBy(id="mobileNumberIntroducer")
    WebElement txtMobileNumberIntroducer;
    @FindBy(id="NI")
    WebElement rbNID;
    @FindBy(id="fileIdNumber")
    WebElement txtFileIdNumber;

    @FindBy(id="fileUrl")
    WebElement txtFileURL;
    @FindBy(id="photographUrl")
    WebElement txtPhotoGraphURL;

    @FindBy(id="register")
    WebElement btnRegister;
    @FindBy(id="confirm")
    WebElement btnConfirm;

    @FindBy(id="txtMobileNo")
    WebElement txtMobileNo;
    @FindBy(id="search")
    WebElement btnSearch;
    @FindBy(xpath="//*[@id=\"userList\"]")
    WebElement txtAgentWallet;
    @FindBy(xpath="/html/body/div[2]/div/div[2]/div/div/div[2]/form/div/a[2]")
    WebElement btnActive;
    @FindBy(id="updateComment")
    WebElement txtComment;
    @FindBy(id="saveButton")
    WebElement btnSubmitComment;

    public AgentReg(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public static String MobileNumber;
    public void agentReg() throws InterruptedException, IOException {
        Thread.sleep(2000);
        linkAgentReg.click();
        Thread.sleep(1000);
        Select userType=new Select(listUserType);
        userType.selectByIndex(1);
        Thread.sleep(2000);
        Select distWallet=new Select(listDistributorWallet);
        distWallet.selectByVisibleText("test automation dist");
        Thread.sleep(2000);
        txtFullName.sendKeys("Test Agent");
        Thread.sleep(1000);
        MobileNumber= Util.generateRandomMobileNumber();
        txtMobileNumber.sendKeys(MobileNumber);
        Thread.sleep(1000);
        txtProprietorName.sendKeys("Test Agent");
        Thread.sleep(1000);
        txtOfficeAddress.sendKeys("Dhaka");
        Thread.sleep(1000);
        txtVillageAreaOffice.sendKeys("Gulshan");
        Thread.sleep(1000);
        Select district=new Select(listDistrictOffice);
        district.selectByVisibleText("Dhaka");
        Thread.sleep(2000);
        Select thana=new Select(listThanaOffice);
        thana.selectByVisibleText("Gulshan");
        Thread.sleep(2000);
        txtPresentAddress.sendKeys("Dhaka");
        Thread.sleep(1000);
        txtVillageAreaPresent.sendKeys("Badda");
        Thread.sleep(1000);
        Select district2=new Select(listDistrictPresent);
        district2.selectByVisibleText("Dhaka");
        Thread.sleep(2000);
        Select thana2=new Select(listThanaPresent);
        thana2.selectByVisibleText("Badda");
        Thread.sleep(2000);
        Select businessRegion=new Select(listBusinessRegion);
        businessRegion.selectByVisibleText("Dhaka-North");
        Thread.sleep(2000);
        Select businessArea=new Select(listBusinessArea);
        businessArea.selectByVisibleText("Dhaka North Metro");
        Thread.sleep(2000);
        Select territory=new Select(listBusinessTerritory);
        territory.selectByVisibleText("Gulshan");
        Thread.sleep(2000);
        Select bankName=new Select(listBankName);
        bankName.selectByIndex(1);
        Thread.sleep(2000);
        InputHandler.ReadConfigFile();
        txtMobileNumberIntroducer.sendKeys(InputHandler.DistributorWallet);
        Thread.sleep(2000);
        rbNID.click();
        Thread.sleep(1000);
        txtFileIdNumber.sendKeys("1502212470");
        Thread.sleep(1000);
        txtFileURL.sendKeys(System.getProperty("user.dir")+"\\src\\test\\resources\\humanface.jpg");
        //txtFileURL.sendKeys("./src/test/resources/humanface.jpg");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        txtPhotoGraphURL.sendKeys(System.getProperty("user.dir")+"\\src\\test\\resources\\humanface.jpg");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        btnRegister.click();
        Thread.sleep(2000);
        btnConfirm.click();
        Thread.sleep(1000);
    }
    public void agentRegApprove() throws Exception {
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/ul/li[4]/a")).click();
        Thread.sleep(5000);
        String wallet=txtAgentWallet.getText();
        addDescription("Agent wallet: "+wallet);
        driver.get(""+InputHandler.URL+"/accountSearch/editAgent/"+wallet+"");
        Thread.sleep(5000);
        btnActive.click();
        Thread.sleep(1000);
        txtComment.sendKeys("Ok");
        Thread.sleep(1000);
        btnSubmitComment.click();
        Thread.sleep(2000);

    }
    public void addDescription(String data) throws Exception
    {
        try{
            Allure.addDescription(data);
        }
        catch(Exception e)
        {
            System.out.print(e.toString());
        }

    }
}
