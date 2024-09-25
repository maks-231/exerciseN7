package com.microservices.countries.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@org.springframework.context.annotation.Configuration
public class Configuration {
  @Bean
  public SecurityFilterChain filterChaim(HttpSecurity http) {
    try {
      http
          .authorizeHttpRequests(authorize ->
                                     authorize.requestMatchers(antMatcher("/country/**")).permitAll()
                                         .requestMatchers(antMatcher("/city/**")).permitAll()
          );

      http.csrf().disable();
      http.headers().frameOptions().disable();
      return http.build();
    } catch (Exception e) {
      throw new RuntimeException("Cannot create a security chain");
    }
  }
}
