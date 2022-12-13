package LF8.application.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import LF8.application.persistence.UserEntity;
import LF8.application.persistence.UserEntityRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserEntityRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String eMail) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByeMail(eMail)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + eMail));

		return UserDetailsImpl.build(user);
	}

}