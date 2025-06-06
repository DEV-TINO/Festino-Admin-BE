package com.DevTino.festino_admin.user.jwt;
import com.DevTino.festino_admin.user.bean.small.GetUserDAOBean;
import com.DevTino.festino_admin.user.domain.RoleType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    GetUserDAOBean getUserDAOBean;

    @Value("${JWT_SECRET_KEY}")
    String secretKey;

    @Autowired
    public WebSecurityConfig(GetUserDAOBean getUserDAOBean) {
        this.getUserDAOBean = getUserDAOBean;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .httpBasic(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                //.requestMatchers(HttpMethod.GET, "/admin/reservation/reserve/booth/bcb6ddc2-1116-4729-a643-fa8f3bb5408f").permitAll()
                                //.requestMatchers(HttpMethod.POST, "/admin/talent/show").permitAll()
                                //.requestMatchers(HttpMethod.POST, "/admin/image").permitAll()
                                //.requestMatchers(HttpMethod.POST, "/admin/message").permitAll()
                                //.requestMatchers(HttpMethod.GET, "/admin/message/all").permitAll()
                                //.requestMatchers(HttpMethod.GET, "/admin/booth/night/all").permitAll()
                                //.requestMatchers(HttpMethod.POST, "/admin/order/table").permitAll()
                                .requestMatchers(HttpMethod.GET, "/admin/booth/cc958624-20ae-4621-8ea1-d968886d8d6c/order/table/0").permitAll()
                                .requestMatchers(HttpMethod.POST, "/admin/order/table").permitAll()
                                .requestMatchers("/admin/booth/bcb6ddc2-1116-4729-a643-fa8f3bb5408f/order/visualization/0").permitAll()
                                .requestMatchers("/admin/booth/bcb6ddc2-1116-4729-a643-fa8f3bb5408f/order/visualization/3").permitAll()
                                .requestMatchers("/").permitAll()
                                .requestMatchers("/admin/user/login").permitAll()
                                .requestMatchers("/admin/user/role").permitAll()
                                .requestMatchers(HttpMethod.POST, "/admin/user/logout").permitAll()
                                //.requestMatchers("/admin/message/send").permitAll()
                                .requestMatchers("/admin/user/all").hasAuthority(RoleType.MEMBER.name())
                                .requestMatchers("/admin/user/booth").hasAuthority(RoleType.MEMBER.name())
                                .requestMatchers("/admin/user/**").hasAuthority(RoleType.ADMIN.name())
                                // .requestMatchers("/admin/user/**").authenticated().hasRole("ADMIN")
                                // .requestMatchers("/admin/user/**").authenticated()
                                .anyRequest().authenticated()
                )
                .sessionManagement(sessionManagement ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(new JwtFilter(getUserDAOBean, secretKey), UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8080", "http://localhost:5173", "https://admin.festino.dev-tino.com"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}