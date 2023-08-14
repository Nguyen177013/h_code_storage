//package com.example.storage.ecchi.config;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class AuthConfig {
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((authorize) -> authorize
//                .requestMatchers("/api/**").permitAll()
//                .requestMatchers(HttpMethod.POST, "/api/**").permitAll()
//                .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
//                .requestMatchers(HttpMethod.PUT, "/api/**").permitAll()
//                .requestMatchers(HttpMethod.DELETE, "/api/**").permitAll()
//                .requestMatchers(HttpMethod.OPTIONS, "/api/**").permitAll()
//                .anyRequest().authenticated()
//            )
//            .cors(Customizer.withDefaults())
//            .csrf(csrf->csrf.disable())
//            .httpBasic();
//        
//        return http.build();
//    }
//    
//    @Bean
//    InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User.builder()
//            .username("hentaibu")
//            .password("{noop}507c6e34b77b5916c3b791e2ff627114")
//            .roles("USER")
//            .build();
//        return new InMemoryUserDetailsManager(user);
//    }
//
//}
