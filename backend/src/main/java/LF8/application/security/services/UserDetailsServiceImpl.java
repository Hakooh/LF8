package LF8.application.security.services;


import LF8.application.persistence.UserEntity;
import LF8.application.persistence.UserEntityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserEntityRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        UserEntity user = userRepository.findByeMail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User Not Found with email: " + email)
                );

        return UserDetailsImpl.build(user);
    }
}