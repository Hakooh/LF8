package LF8.application.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import LF8.application.Lf8Application;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Lf8Application.class )
@AutoConfigureMockMvc(addFilters=false)
public class MessageControllerUnitTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getAPIMessage() throws Exception {
        log.info("Getting Test API Message");
        MvcResult result = mvc
                .perform(MockMvcRequestBuilders.get("/api/messages/hello"))
                .andExpect(status().isOk()).andReturn();

        assertThat(result.getResponse().getContentAsString()).isEqualTo("Full Stack Java with Spring Boot & VueJS!");
    }
}