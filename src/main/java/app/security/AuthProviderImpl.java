package app.security;

import app.models.Users;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AuthProviderImpl implements AuthenticationProvider {

    private String passwordFromDb;

    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String name = authentication.getName();
        Users persons = userRepository.getName(name);
        passwordFromDb = persons.getPassword();

        String password = authentication.getCredentials().toString();
        PasswordCoder passwordCoder = null;
        try {
            passwordCoder = new PasswordCoder(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


        if (persons == null) {
            throw new UsernameNotFoundException("Users not found");
        }


        assert passwordCoder != null;
        System.out.println("1 - " + passwordFromDb + "\n" + "2 - " + passwordCoder.getExistingPassword());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (!passwordEncoder.matches(password, passwordFromDb )) {

            throw new UsernameNotFoundException("Users or password not found");

        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        System.out.println("!!!!!" + encoder.matches(password, passwordFromDb));

        List<GrantedAuthority> authorities = new ArrayList<>();

        return new UsernamePasswordAuthenticationToken(persons, null, authorities);


    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }

}

