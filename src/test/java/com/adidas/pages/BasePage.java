package com.adidas.pages;

import com.adidas.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(linkText = "Laptops")
    public WebElement Laptops;

    @FindBy(xpath = "//a[@class='hrefch']")
    public WebElement Sony;

    @FindBy(linkText = "Add to cart")
    public WebElement AddToCart;

    @FindBy(xpath = "//a[@class='nav-link']")
    public WebElement HomePageModule;

    @FindBy(xpath = "(//a[@class='hrefch'])[4]")
    public WebElement Dell;

    @FindBy(id  = "cartur")
    public WebElement Cart;

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> Table;

    @FindBy(css = "button.btn.btn-success")
    public WebElement PlaceOrder;

    @FindBy(id = "name")
    public WebElement Name;

    @FindBy(id = "country")
    public WebElement Country;

    @FindBy(id = "city")
    public WebElement City;

    @FindBy(id = "card")
    public WebElement CreditCard;

    @FindBy(id = "month")
    public WebElement Month;

    @FindBy(id = "year")
    public WebElement Year;

    @FindBy(xpath = "//button[@onclick='purchaseOrder()']")
    public WebElement Purchase;

    @FindBy (css="p.lead.text-muted")
    public List<WebElement> Id;

    @FindBy (xpath = "//br/preceding::text()[2]")
    public WebElement a;

    @FindBy(xpath = "(//div[@tabindex='-1'])[11]/p/br[2]")
    public WebElement Id2;


    @FindBy(xpath = "//p[@class='lead text-muted ']/br")
    public List<WebElement> Amount;

    @FindBy(css = "button.confirm.btn.btn-lg.btn-primary")
    public WebElement OkButton;













}
