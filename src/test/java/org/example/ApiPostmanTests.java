package org.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiPostmanTests {

    @BeforeEach
    public void setUp(){
        RestAssured.baseURI = "https://postman-echo.com";
    }
    @Test
    @DisplayName("GET Request")
    public void getRequest(){
        given()
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when().get("/get?foo1=bar1&foo2=bar2")
                .then()
                .assertThat().statusCode(200)
                .and().body("args.foo1", equalTo("bar1"))
                .and().body("args.foo2", equalTo("bar2"));
    }

    @Test
    @DisplayName("POST Raw Text")
    public void postRawTest(){
        given()
                .body("This is expected to be sent back as part of response body.")
                .when().post("/post")
                .then()
                .assertThat().statusCode(200)
                .and().body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test
    @DisplayName("POST Form Data")
    public void postFormData(){
        given()
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .header("content-type","application/x-www-form-urlencoded;charset=UTF-8")
                .when().post("/post")
                .then()
                .assertThat().statusCode(200)
                .and().body("form.foo1", equalTo("bar1"))
                .and().body("form.foo2", equalTo("bar2"));
    }

    @Test
    @DisplayName("PUT Request")
    public void putRequest(){
        given()
                .body("This is expected to be sent back as part of response body.")
                .when().put("/put")
                .then()
                .assertThat().statusCode(200)
                .and().body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test
    @DisplayName("PATCH Request")
    public void patchRequest(){
        given()
                .body("This is expected to be sent back as part of response body.")
                .when().patch("/patch")
                .then()
                .assertThat().statusCode(200)
                .and().body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test
    @DisplayName("Delete Request")
    public void deleteRequest(){
        given()
                .body("This is expected to be sent back as part of response body.")
                .when().delete("/delete")
                .then()
                .assertThat().statusCode(200)
                .and().body("data", equalTo("This is expected to be sent back as part of response body."));
    }
}
