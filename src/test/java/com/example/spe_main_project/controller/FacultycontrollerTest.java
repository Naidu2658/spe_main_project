package com.example.spe_main_project.controller;

import com.example.spe_main_project.dto.AuthRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@AutoConfigureMockMvc
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FacultycontrollerTest extends AbstractTest {

    @Test
    public void faculty_login() throws Exception {
        String uri = "/facultylogin";
        AuthRequest req = new AuthRequest();
        req.setMail("abc@gmail.com");
        req.setPassword("123");

        String inputJson = super.mapToJson(req);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);  //A 201 status code indicates that a request was successful and as a result, a resource has been created
        String content = mvcResult.getResponse().getContentAsString();
        try {
            assertEquals(content, "login succesfull");
        }
        catch (Exception e)
        {
            System.out.println("faculty login test case failed");
        }
    }

}
