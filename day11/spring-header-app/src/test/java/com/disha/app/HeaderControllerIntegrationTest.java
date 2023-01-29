package com.disha.app;

import com.disha.app.controller.HeaderController;
import com.disha.app.model.Data;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.Base64Utils;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({HeaderController.class})
@ActiveProfiles(value="test")
public class HeaderControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Value("${post.url}")
    String postUrl;

    @Test
    public void testSavePostData() throws Exception{
        String secret = "Basic" + Base64Utils.encodeToString(("user123" + ":"+ "password").getBytes());
        Data data = new Data("1","data01");
        ResultActions responseEntity = mockMvc.perform(post(postUrl).header(HttpHeaders.AUTHORIZATION, secret).header("sessionId","123").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(data)));
        responseEntity.andExpect(status().isOk());

    }

    private String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
