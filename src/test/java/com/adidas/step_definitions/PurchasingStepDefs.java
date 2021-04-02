package com.adidas.step_definitions;

import com.adidas.pages.PurchasingPage;
import com.adidas.utilities.BrowserUtils;
import com.adidas.utilities.ConfigurationReader;
import com.adidas.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

public class PurchasingStepDefs {

    PurchasingPage purchasingPage=new PurchasingPage();



    @Given("the customer is on the homePage")
    public void the_customer_is_on_the_homePage() {

        String url= ConfigurationReader.get("url");
        Driver.get().get(url);

    }

    @When("the customer  clicks on Laptops")
    public void the_customer_clicks_on_Laptops() {
       BrowserUtils.waitFor(2);

        purchasingPage.Laptops.click();

    }

    @Then("the customer  clicks on Sony vaio i5")
    public void the_customer_clicks_on_Sony_vaio_i5() {

        BrowserUtils.waitFor(2);
        purchasingPage.Sony.click();

    }

    @Then("the customer  clicks on Add to cart")
    public void the_customer_clicks_on_Add_to_cart() {

        BrowserUtils.waitFor(2);
       purchasingPage.AddToCart.click();


    }

    @Then("the customer  Accept pop up confirmation")
    public void the_customer_Accept_pop_up_confirmation() {
        BrowserUtils.waitFor(2);
       Alert alert = Driver.get().switchTo().alert();
       alert.accept();


    }

    @When("the customer clicks Home button to return to the HomePage")
    public void the_customer_clicks_Home_button_to_return_to_the_HomePage() {

        BrowserUtils.waitFor(2);
        purchasingPage.HomePageModule.click();

    }

    @Then("the customer  clicks on Dell i7 8gb")
    public void the_customer_clicks_on_Dell_i7_8gb() {

        BrowserUtils.waitFor(2);
        purchasingPage.Dell.click();

    }

    @Then("the customer  clicks to Cart module")
    public void the_customer_clicks_to_Cart_module() {

        BrowserUtils.waitFor(2);
        purchasingPage.Cart.click();

    }

    @Then("the customer  deletes Dell i7 8gb from Cart")
    public void the_customer_deletes_Dell_i7_8gb_from_Cart() {
        BrowserUtils.waitFor(2);
        String expectedDell = "Dell i7 8gb";

        for (int i = 1; i <= purchasingPage.Table.size(); i++) {

            if (Driver.get().findElement(By.xpath("//table/tbody/tr[" + i + "]/td[2]")).getText().equals(expectedDell)) {
                BrowserUtils.waitFor(2);

                Driver.get().findElement(By.xpath("//table/tbody/tr[" + i + "]/td[4]/a")).click();
                break;

            }

        }
    }

    @Then("the customer  clicks on Place order button")
    public void customer_click_on_Place_order() {

        BrowserUtils.waitFor(2);
        purchasingPage.PlaceOrder.click();

    }

    @Then("the customer  fills in all web form fields and click Purchase")
    public void the_customer_fills_in_all_web_form_fields_and_click_Purchase() {

        BrowserUtils.waitFor(2);
        purchasingPage.Name.sendKeys("Nesem");
        purchasingPage.Country.sendKeys("Turkey");
        purchasingPage.City.sendKeys("Kirsehir");
        purchasingPage.CreditCard.sendKeys("21548796563");
        purchasingPage.Month.sendKeys("6");
        purchasingPage.Year.sendKeys("2024");

        purchasingPage.Purchase.click();

    }

    @Then("the customer  captures and logs purchase Id and Amount")
    public void the_customer_captures_and_logs_purchase_Id_and_Amount() {

        BrowserUtils.waitFor(2);
        List<String> elemTexts = new ArrayList<>();

        for (WebElement el : purchasingPage.Id) {
            elemTexts.add(el.getText());
            Assert.assertTrue(el.getText().contains("Amount"));
            if(el.getText().contains("Id") ){
                System.out.println(el.getText());
                break;
            }
        }



//
//        Iterator<Object> itr = fis.iterator();
//        while(itr.hasNext()) {
//            System.out.println(itr.next());
//        }

     //  System.out.println(purchasingPage.Id.getText());
//
//        List<Object> elemTexts = Arrays.asList(purchasingPage.Id);
//
//        System.out.println(elemTexts);
//        for (Object el : elemTexts) {
//
//            if(el.equals("Id") || el.equals("Amount")){
//                System.out.println(el);
//                break;
//            }
//
//        }








    }

    @Then("purchase amount equals expected")
    public void purchase_amount_equals_expected() {
        BrowserUtils.waitFor(2);
        String ExpectedAmount="Amount: 790 USD";
       System.out.println(purchasingPage.a.getText());

    }

    @Then("the customer  clicks on Ok")
    public void the_customer_clicks_on_Ok() {
        BrowserUtils.waitFor(2);
        purchasingPage.OkButton.click();
    }





}
