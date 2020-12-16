package com.automation.tests.day02;

import io.restassured.http.Header;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ORDSTests {

    private String baseURL = "http://ec2-18-208-151-119.compute-1.amazonaws.com:1000/ords/hr";

    @Test
    public void test1() {
        Response response = given().get(baseURL + "/employees");
        //System.out.println(response.getBody().asString());

        assertEquals(200, response.getStatusCode());
        System.out.println(response.prettyPrint()); // print code like Postman
    }

    //#TASK: get employee with id 100 and verify status code 200 and print body

    @Test
    public void test2(){
        //header stands for meta data, it's used to include cookies
        Response response = given().
                header("accept","application/json").
                get(baseURL + "/employees/100");
        assertEquals(200, response.getStatusCode());
        System.out.println(response.prettyPrint());
    }

    //#Task: perform GET request to /regions, print body and all headers.
    @Test
    public void test3(){
        Response response = given().get(baseURL+"/regions");
        assertEquals(200, response.getStatusCode());
        //to get specific header
        Header header = response.getHeaders().get("Content-Type");
        //print all headers one by one
        for(Header h: response.getHeaders()){
            System.out.println(h);
        }
        System.out.println("##########################");
        System.out.println(response.prettyPrint());
        System.out.println("sami gumus");
    }

}
