package com.miaplaza.pages;

import com.miaplaza.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MiaplazaHomepage_Page {

    public MiaplazaHomepage_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /** Homepage Logo */
    @FindBy(xpath = "//div[@class='mia-img']//*[name()='svg']")
    public WebElement assertPage;

    /** Online High School */
    @FindBy(xpath = "//*[.='Online High School']")
    public WebElement onlineHighSchool;

}