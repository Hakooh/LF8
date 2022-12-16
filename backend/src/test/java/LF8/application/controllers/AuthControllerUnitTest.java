package LF8.application.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import LF8.application.Lf8Application;
import LF8.application.payload.request.SignupRequest;
import LF8.application.persistence.UserEntity;
import LF8.application.persistence.UserEntityRepository;



@ExtendWith(SpringExtension.class)
@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.MOCK,
  classes = Lf8Application.class)
public class AuthControllerUnitTest{
	@Autowired
    AuthController controller;

	@Autowired
    UserEntityRepository userEntityRepository;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Test
	public void signUpTest(){
		//given
		SignupRequest request = new SignupRequest();
		String testString = "vlatest";
		request.setEMail(testString);
		request.setFirstName(testString);
		request.setLastName(testString);
		request.setPassword(testString);
		request.setGender(testString);
		request.setDateOfBirth(LocalDate.parse("2005-11-12"));

		//when
		controller.registerUser(request);
	 
		assertThat(userEntityRepository.existsByeMail(request.getEMail()));
		Optional<UserEntity> user = userEntityRepository.findByeMail(request.getEMail());
		assertThat(user).isPresent();
		assertThat(user.get().getDayOfBirth()).isEqualTo(LocalDate.parse("2005-11-12"));
		assertThat(user.get().getEMail()).isEqualTo(testString);
		assertThat(user.get().getFirstName()).isEqualTo(testString);
		assertThat(user.get().getLastName()).isEqualTo(testString);
		//assertThat(user.get().getPassword()).isEqualTo(passwordEncoder.encode(testString));
		assertThat(user.get().getGender()).isEqualTo(testString);
	}


	@Test
	public void loginTest(){
		//given
		SignupRequest request = new SignupRequest();
		String testString = "vlatest";
		request.setEMail(testString);
		request.setPassword(testString);

		//when
		controller.registerUser(request);
	 
		assertThat(userEntityRepository.existsByeMail(request.getEMail()));
	}

}