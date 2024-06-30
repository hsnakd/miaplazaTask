package com.miaplaza.pages;

import com.miaplaza.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MiaplazaApplyToOurSchool_Page {

    public MiaplazaApplyToOurSchool_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    /** Apply to Our School */
    @FindBy(xpath = "(//em[normalize-space()='MOHS Initial Application'])[1]")
    public WebElement MOHSInitialApplicationTitle;
}