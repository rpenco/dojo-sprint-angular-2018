package com.auth;


import com.auth.service.TokenService;
import com.foo.CorsConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan(basePackages = "com.auth")
@EnableJpaRepositories(basePackages = "com.auth")
@EntityScan(basePackages = "com.auth")
public class AuthSpringBootApp extends SpringBootServletInitializer {

    /**
     * CORS configuration
     *
     * @return WebMvcConfigurer
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new CorsConfigurer();
    }

    @Bean(initMethod = "init")
    public TokenService tokenService() { return new TokenService();}

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AuthSpringBootApp.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AuthSpringBootApp.class, args);
    }

}
