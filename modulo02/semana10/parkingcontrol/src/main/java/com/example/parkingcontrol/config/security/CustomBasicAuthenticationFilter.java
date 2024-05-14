package com.example.parkingcontrol.config.security;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.parkingcontrol.models.UserModel;
import com.example.parkingcontrol.repositories.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomBasicAuthenticationFilter extends OncePerRequestFilter{

    private static final String AUTHORIZATION = "Authorization";
    private static final String BASIC = "Basic ";

    @Autowired
    UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException{

        if(isBasicAuthentication(request)){
            String[] credentials = decodeBase64(getHeader(request)
                                        .replace(BASIC, ""))
                                        .split(":");
            String username = credentials[0];
            String password = credentials[1];

            UserModel user = userRepository.findByUsernameFetchRoles(username);

            if(user == null){
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Usuario nao existe!");
                return;
            }

            boolean valid = checkPassword(user.getPassword(), password);            

            if(!valid){
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Senhas nao correspondem!");
                return;
            }

            setAuthentication(user);

        }

        filterChain.doFilter(request, response);
    }

    private void setAuthentication(UserModel user){
        Authentication authentication = createAuthenticationToken(user);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private Authentication createAuthenticationToken(UserModel user){
        UserPrincipal userPrincipal = UserPrincipal.create(user);
        return new UsernamePasswordAuthenticationToken(userPrincipal, null, userPrincipal.getAuthorities());
    }

    private boolean isBasicAuthentication(HttpServletRequest request){
        String header = getHeader(request);
        return header != null && header.startsWith(BASIC);
    }

    private String getHeader(HttpServletRequest request){
        return request.getHeader(AUTHORIZATION);
    }

    private String decodeBase64(String replace){
        byte[] decodeBytes = Base64.getDecoder().decode(replace);
        return new String(decodeBytes);
    }

    private boolean checkPassword(String userPassword, String loginPassword){
        return passwordEncoder().matches(loginPassword, userPassword);
    }

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
}
