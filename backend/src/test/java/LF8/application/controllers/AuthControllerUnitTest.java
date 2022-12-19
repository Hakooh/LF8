package LF8.application.controllers;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import LF8.application.Lf8Application;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Lf8Application.class)
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class AuthControllerUnitTest {

	@Autowired
	private MockMvc mvc;

	private final String SIGN_UP_BODY = "{\"email\": \"testuser@mail.de\",\"password\": \"password\",\"firstName\":\"test\",\"lastName\":\"user\",\"gender\":\"test\",\"dateOfBirth\":\"1980-10-10\"}";
	private final String LOG_IN_BODY = "{\"email\": \"testuser@mail.de\",\"password\": \"password\"}";


	@Test
	@Order(1)
	public void loginBeforeSignUpTest() throws Exception {
		log.info("Log in user before signup");
		mvc.perform(MockMvcRequestBuilders.post("/api/auth/signin").contentType(MediaType.APPLICATION_JSON)
				.content(LOG_IN_BODY)).andExpect(status().isBadRequest());
	}

	@Test
	@Order(2)
	public void signUpTest() throws Exception {
		log.info("Sign up user");
		mvc.perform(MockMvcRequestBuilders.post("/api/auth/signup").contentType(MediaType.APPLICATION_JSON)
				.content(SIGN_UP_BODY)).andExpect(status().isOk());
	}

	@Test
	@Order(3)
	public void signUpSameUserTest() throws Exception {
		log.info("Sign up identical user");
		log.info(SIGN_UP_BODY);
		mvc.perform(MockMvcRequestBuilders.post("/api/auth/signup").contentType(MediaType.APPLICATION_JSON)
				.content(SIGN_UP_BODY)).andExpect(status().isBadRequest());
	}

	@Test
	@Order(4)
	public void loginTest() throws Exception{
		log.info("Log in user");
		mvc.perform(MockMvcRequestBuilders.post("/api/auth/signin").contentType(MediaType.APPLICATION_JSON)
				.content(LOG_IN_BODY)).andExpect(status().isOk());
	}

}