package com.gamepixel.api.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    /***
     * Works like Servlet filters
     * Sets the authentication manager which was configured to override configure(authenticationManagerBuilder auth)
     * @param authenticationManager
     */

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager){
        this.setAuthenticationManager(authenticationManager);
        // This method set a URL preference for the authentication end point
        setFilterProcessesUrl("/api/login");
    }
}
