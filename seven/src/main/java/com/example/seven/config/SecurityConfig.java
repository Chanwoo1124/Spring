package com.example.seven.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    //비밀번호 암호화용 Bean
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){

        //security 필터를 구획을 내마음대로 커스텀

        http
                .csrf(csrf -> csrf.disable());
        //로그인 필터
        http
                .formLogin(login -> login
                        .loginProcessingUrl("/login")
                        .loginPage("/login"));


        return http.build();
    }
}
