package com.automation.tests.day02;

import io.restassured.http.Header;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ExchangeRatesAPITests {
    private String baseURI = "http://api.openrates.io/";

    @Test
    public void test1() {
        Response response = given().
                get(baseURI + "latest");
        assertEquals(200, response.getStatusCode());
        System.out.println(response.prettyPrint());
    }

    @Test
    public void test2() {
        Response response = given().
                get(baseURI+"latest");
        assertEquals(200,response.getStatusCode());
        assertEquals("application/json",response.getHeader("Content-Type"));
        assertEquals("application/json",response.getContentType());

    }

}