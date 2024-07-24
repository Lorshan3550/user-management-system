package com.developmentpractice.usermanagementsystemportal.dto;

import com.developmentpractice.usermanagementsystemportal.entity.OurUsers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqRes {

    private int statusCode;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String expirationTime;
    private String name;
    private String city;
    private String role;
    private String email;
    private String password;
    private OurUsers ourUsers;
    private List<OurUsers> ourUsersList;


}


/*
*
* @JsonInclude(JsonInclude.Include.NON_NULL): A Jackson annotation that specifies that properties with null values should be excluded from the JSON serialization.
*
@JsonIgnoreProperties(ignoreUnknown = true): A Jackson annotation that indicates that any properties not bound in this type should be ignored.
* This is useful when parsing JSON data with unknown properties, ensuring they do not cause errors.
*
*
* The ReqRes class is a Data Transfer Object (DTO) used to encapsulate data that will be sent to and received from the client.
* The class uses several annotations to simplify its implementation and ensure correct JSON serialization/deserialization:
*
* JSON serialization - dto object converted to json
* JSON deserialization - json converted to dto object

Lombok's @Data: Automatically generates common methods like getters, setters, toString(), etc.
Jackson's @JsonInclude(JsonInclude.Include.NON_NULL): Ensures that null properties are not included in the JSON output.
Jackson's @JsonIgnoreProperties(ignoreUnknown = true): Prevents errors when encountering unknown properties in the JSON input.
By using these annotations, the ReqRes class is concise and maintains the flexibility and robustness needed for JSON handling in a Spring Boot application.*/