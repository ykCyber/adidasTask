package com.adidas.ApiTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public  class Pets {
     String Url="https://petstore.swagger.io/v2";
     String pet="fish";
    String jsonBody="{\n" +
            "  \"id\": 20,\n" +
            "  \"category\": {\n" +
            "    \"id\": 20,\n" +
            "    \"name\": \"string\"\n" +
            "  },\n" +
            "  \"name\": \"camel\",\n" +
            "  \"photoUrls\": [\n" +
            "    \"string\"\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": 0,\n" +
            "      \"name\": \"string\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"available\"\n" +
            "}";
         String Pet1="camel";


    String JsonBody1="{\n" +
            "  \"id\": 20,\n" +
            "  \"category\": {\n" +
            "    \"id\": 20,\n" +
            "    \"name\": \"string\"\n" +
            "  },\n" +
            "  \"name\": \"camel\",\n" +
            "  \"photoUrls\": [\n" +
            "    \"string\"\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": 0,\n" +
            "      \"name\": \"string\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"sold\"\n" +
            "}";
          String status="sold";

    @Test
    public  void getPet () {

        Response response = given().accept(ContentType.JSON)
                .and().queryParam("status", "available")
                .when().get(Url+"/pet/findByStatus/");

         response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json");
        Assert.assertTrue(response.body().asString().contains(pet));

    }
    @Test
    public  void PostPet (){
            Response response=given()
                .accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(jsonBody)
                .when().post(Url+"/pet");

            Assert.assertEquals("application/json",response.contentType());
            Assert.assertEquals(200,response.statusCode());
            Assert.assertTrue(response.body().asString().contains(Pet1));

}
    @Test
    public void putPet(){

          Response response=  given().and()
                .contentType(ContentType.JSON)
                .and()
                .body(JsonBody1).
                when()
                .put(Url+"/pet");

           Assert.assertEquals("application/json",response.contentType());
           Assert.assertEquals(200,response.statusCode());
           Assert.assertTrue(response.body().asString().contains(status));

    }
@Test
    public void deletePet(){

    Response response=  given().and()
            .contentType(ContentType.JSON)
            .and()
            .body(JsonBody1).
                    when()
            .delete(Url+"/pet/20");

    Assert.assertEquals(200,response.statusCode());
    Assert.assertFalse(response.body().asString().contains(Pet1));

}

}
