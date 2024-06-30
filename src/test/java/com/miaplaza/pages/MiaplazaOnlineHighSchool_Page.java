package com.miaplaza.pages;

import com.miaplaza.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MiaplazaOnlineHighSchool_Page {

    public MiaplazaOnlineHighSchool_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /** Apply to Our School */
    @FindBy(xpath = "//img[@class='custom-logo svg-logo-image' and @alt='MiaPrep']")
    public WebElement assertPage;


    /** Apply to Our School */
    @FindBy(xpath = "//*[.='Apply to Our School']")
    public WebElement applyToOurSchool;



}