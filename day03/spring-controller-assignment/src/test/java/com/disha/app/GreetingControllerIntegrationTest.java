package com.disha.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@RunWith(SpringRunner.class)
@WebMvcTest({GreetingController.class})
public class GreetingControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGreetingControllerGreet() throws Exception {
        ResultActions responseEntity  = mockMvc.perform(get("/greet"));
        responseEntity.andExpect(status().isOk());
        String result = responseEntity.andReturn().getResponse().getContentAsString();
        assertEquals("Greet from App", result);
    }

    @Test
    public void testHelloControllerRequestWelcome() throws Exception {
        ResultActions responseEntity  = mockMvc.perform(get("/welcome"));
        responseEntity.andExpect(status().isOk());
        String result = responseEntity.andReturn().getResponse().getContentAsString();
        assertEquals("Welcome from App", result);
    }
    @Test
    public void testHelloControllerRequestHi() throws Exception {
        ResultActions responseEntity  = mockMvc.perform(get("/hi"));
        responseEntity.andExpect(status().isOk());
        String result = responseEntity.andReturn().getResponse().getContentAsString();
        assertEquals("Hi from App", result);
    }
    @Test
    public void testHelloControllerRequestThanks() throws Exception {
        ResultActions responseEntity  = mockMvc.perform(get("/thanks"));
        responseEntity.andExpect(status().isOk());
        String result = responseEntity.andReturn().getResponse().getContentAsString();
        assertEquals("Thanks from App", result);
    }
}




