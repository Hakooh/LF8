package LF8.application.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Lf8Application.class)
@AutoConfigureMockMvc(addFilters = false)
@TestMethodOrder(OrderAnnotation.class)
public class FestivalControllerUnitTest {

    @Autowired
    private MockMvc mvc;

    private final String ALL_FESTIVALS = "[{\"id\":1,\"name\":\"Dom\",\"festivalPlace\":\"Hamburg\",\"address\":\"Musterstrasse 8\",\"startDate\":\"2022-01-01\",\"endDate\":\"2022-01-03\",\"shops\":[{\"id\":1,\"name\":\"Meyers Mandelbude\",\"type\":\"FOODSTORE\",\"ratings\":[{\"id\":1,\"comment\":\"Freshe Sache\",\"rating\":5,\"user\":{\"id\":1,\"firstName\":\"Dieter\",\"lastName\":\"Detlefs\",\"dayOfBirth\":\"1986-04-20\",\"gender\":\"Male\",\"password\":\"$2a$10$Ht0IWia5s1MXdYekb1H9helRh.6S/9.uNseZN7/wph3pT2o9trixi\",\"lastLogin\":\"2022-08-12\",\"email\":\"geilertyp@hotmail.de\"},\"commentDate\":\"2022-08-12\"}]}]}]";

    @Test
    @Order(1)
    public void getAllFestivals() throws Exception {
        log.info("Getting all festivals in database.");
        MvcResult result = mvc
                .perform(MockMvcRequestBuilders.get("/api/festival/all"))
                .andExpect(status().isOk()).andReturn();
        assertThat(result.getResponse().getContentAsString()).isEqualTo(ALL_FESTIVALS);
    }

    @Test
    @Order(2)
    public void deleteFestival() throws Exception {
        log.info("Getting all festivals in database.");
        mvc.perform(MockMvcRequestBuilders.delete("/api/festival/delete/id/{id}", 1))
                .andExpect(status().isOk());

        MvcResult result = mvc
                .perform(MockMvcRequestBuilders.get("/api/festival/all"))
                .andExpect(status().isOk()).andReturn();
        assertThat(result.getResponse().getContentAsString()).isEqualTo("[]");
    }
}