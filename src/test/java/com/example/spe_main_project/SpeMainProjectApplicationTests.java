package com.example.spe_main_project;

import com.example.spe_main_project.dto.AuthRequest;
import com.example.spe_main_project.dto.AuthRequestStudentDto;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.example.spe_main_project.dto.AuthRequest;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.hamcrest.Matchers.*;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import  org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
@WebAppConfiguration
@SpringBootTest
public
class SpeMainProjectApplicationTests {

    @Test
    void contextLoads() {
    }
//required resuorces for api testing
    protected MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    protected void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
    protected <T> T mapFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }


//    testing faculty controller
    @Test
    public void faculty_login() throws Exception {
        String uri = "/studentlogin";
        AuthRequestStudentDto req= new AuthRequestStudentDto();
        req.setStudent_mail("user@gmail.com");
        req.setPassword("123");
        this.setUp();
        String inputJson = mapToJson(req);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);  //A 201 status code indicates that a request was successful and as a result, a resource has been created
        System.out.println(mvcResult.getResponse());
        String content = mvcResult.getResponse().getContentAsString();

        System.out.println("hellooo");
        System.out.println("this is " + content);
       // System.out.println(content1);
        try {
       //    assertEquals(content, "you are not registered");
        }
        catch (Exception e)
        {
            System.out.println("faculty login test case failed");
        }
    }

//    @Test
//    public void faculty_login() throws Exception {
//        String uri = "/studentlogin";
//        AuthRequestStudentDto req= new AuthRequestStudentDto();
//        req.setStudent_mail("user@gmail.com");
//        req.setPassword("123");
//        this.setUp();
//        String inputJson = mapToJson(req);
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
//                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);  //A 201 status code indicates that a request was successful and as a result, a resource has been created
//        System.out.println(mvcResult.getResponse());
//        String content = mvcResult.getResponse().getContentAsString();
//
//        System.out.println("hellooo");
//        System.out.println("this is " + content);
//        // System.out.println(content1);
//        try {
//            //    assertEquals(content, "you are not registered");
//        }
//        catch (Exception e)
//        {
//            System.out.println("faculty login test case failed");
//        }
//    }
}
