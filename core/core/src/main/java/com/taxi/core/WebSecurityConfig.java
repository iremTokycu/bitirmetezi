package com.taxi.core;

import com.taxi.core.userapp.user.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()

                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                //Driver icin
                .antMatchers("/driverapp-api/**").authenticated()
                .antMatchers("/public-driverapp-api/**").permitAll()

                //Kullanici icin
                .antMatchers("/userapp-api/**").authenticated()
                .antMatchers("/public-userapp-api/**").permitAll()


                .anyRequest().authenticated()
                .and()
                .httpBasic();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationService);
    }

}
