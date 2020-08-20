package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceLoginPage {
    //Yeni bir class oluşturun: FaceLogin
    //Bir test metodu oluşturun: faceLoginTest ()
    //Kullanıcı geçersiz kimlik bilgileri girdiğinde,
    // kullanıcı “The email or phone number you’ve entered doesn’t match any account.” mesajini görmelidir.
    //https://www.facebook.com/
    //Username: fakeusername
    //Password: fakepassword

    //create driver
    WebDriver driver;
    //driveri baslatmak icin constructor  kullanalim

    public FaceLoginPage(WebDriver driver){
        this.driver=driver;
        //page objelerini beslatmak icin  PageFactory.initElements(driver,this) kullaniyoruz

        PageFactory.initElements(driver,this);
        //Yukariyi ezberle

    }
    //Elementleri locate etmek icin
    @FindBy(id="email")
    public WebElement email;

    @FindBy(id="pass")
    public WebElement password;

    @FindBy(id="u_0_b")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement error_mesaj;
}
