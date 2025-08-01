package pro.samgerstner.licensexpress.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig
{
   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
   {
      http.csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers("/login").permitAll()
            .requestMatchers("/").permitAll()
            .requestMatchers("/home").permitAll()
            .requestMatchers("/register").permitAll()
            .requestMatchers("/logout").permitAll()
            .requestMatchers("/confirm-registration").permitAll()
            .requestMatchers("/username-availability").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin();
      return http.build();
   }

   @Bean
   public PasswordEncoder passwordEncoder()
   {
      return new BCryptPasswordEncoder();
   }
}