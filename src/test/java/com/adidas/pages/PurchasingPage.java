package com.adidas.pages;

import com.adidas.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class  PurchasingPage extends BasePage{

    public PurchasingPage() {
        PageFactory.initElements(Driver.get(), this);

    }

    private String alfa;

    @FindBy(xpath = "//body/div[10]/p[1]")
    public WebElement confirmationPupUpBox;

    public String getTextofReport(){
        return confirmationPupUpBox.getText().replaceAll(" ","");

            }
    public int getID() {
        /*
        2323232323
        Amount:759USD
        Card:.......
        .........:::
        */
        int indexOfAmount= getTextofReport().indexOf("Amount");
        String id = getTextofReport().substring(getTextofReport().indexOf("Id:"),indexOfAmount).trim();
        int idNum = Integer.parseInt(id.replace("Id:",""));
        return idNum;
    }

    public int getPrice() {
        int indexOfCard = getTextofReport().indexOf("Card");
        int indexOfAmount= getTextofReport().indexOf("Amount");
        String amount = getTextofReport().substring(indexOfAmount, indexOfCard).trim();
        int price = Integer.parseInt(amount.replace("Amount:", "").replace("USD","").trim());
        return price;
    }
}
