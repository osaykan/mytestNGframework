package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbSignInPage {

    public GlbSignInPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id="email")
    public WebElement email;
    @FindBy(id="password")
    public  WebElement password;
    @FindBy(xpath = "//button[@value='Login']")
    public WebElement loginButton;
    @FindBy(xpath = "//div[@class='my_account_header']")
    public WebElement myAccount;
    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement mesaj;
}
