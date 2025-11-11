package Pages;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.runner.Request;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class APIPage {
    public String BaseUrl;
    public RequestSpecification reqsep;
    public String requestBody;
    public Response response;

    public void setUrl(String url){
        BaseUrl=url;
        reqsep= new RequestSpecBuilder()
                .setBaseUri(BaseUrl)
                .setContentType("application/json")
                .build();
        System.out.println(reqsep);
    }
    public void i_create_request_body(String file , Map datatable) throws IOException {
        requestBody=readJsonFile("src/test/resources/APITemp/"+file);
        Map<String,String>entries=datatable;
        for(Map.Entry<String,String>en:entries.entrySet()){
            if (requestBody.contains("<"+en.getKey()+">")){
                requestBody=requestBody.replace("<"+en.getKey()+">",en.getValue());
            }
        }
        System.out.println(requestBody);
    }
    public static String readJsonFile(String file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
    public void SetPostMethod(){
        response=given()
                .spec(reqsep)
                .body(requestBody)
                .when()
                .post("")
                .then()
                .extract().response();
        System.out.println(response);
    }

    public void ValidateStatusCode(int status){

        Assert.assertEquals(status,response.getStatusCode());
    }



}
