package LF8.application.security;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import LF8.application.Lf8Application;
import LF8.application.security.jwt.JwtUtils;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Lf8Application.class)
@AutoConfigureMockMvc
public class TokenAuthenticationTest {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    private MockMvc mvc;

    @Autowired
    AuthenticationManager authenticationManager;

    @Test
    public void shouldNotAllowAccessToUnauthenticatedUsers() throws Exception {
        log.info("Test access without valid token.");
        mvc.perform(MockMvcRequestBuilders.get("/api/messages/hello")).andExpect(status().isUnauthorized());
    }

    @Test
    public void shouldGenerateAuthToken() throws Exception {
        log.info("Test token authentication.");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        "test@hotmail.de",
                        "password"));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtUtils.generateJwtToken(authentication);

        assertThat(token).isNotNull();
        mvc.perform(MockMvcRequestBuilders.get("/api/messages/hello").header("Authorization", token))
                .andExpect(status().isOk());
    }

}