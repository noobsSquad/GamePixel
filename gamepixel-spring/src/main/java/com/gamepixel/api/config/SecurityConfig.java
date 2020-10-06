package com.gamepixel.api.config;

import com.gamepixel.api.security.JwtAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // Injection
    private UserDetailsService userDetailsService;
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .antMatcher("/**")
//                .authorizeRequests()
//                .antMatchers("/api/auth/**")
//                .permitAll()
//                .and()
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().permitAll();
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/auth/**")
                .permitAll()
                .anyRequest()
                .authenticated();
        //NEED TO FIX THIS
//        httpSecurity
//                .csrf().disable()
//                .authorizeRequests().antMatchers("/api/auth/**").permitAll().anyRequest().authenticated();


        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    /***
     * Configure the AuthenticationManager to know where to load
     * user for matching credentials
     *  Use BCryptPasswordEncoder
     */
    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        Hard Coded:
//        auth
//                .inMemoryAuthentication()
//                .withUser("TomasChavez")
//                .password(passwordEncoder().encode("12345")).roles("USER");

        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
