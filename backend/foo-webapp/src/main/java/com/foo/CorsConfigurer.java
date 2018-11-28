package com.foo;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author J.GROCH
 */
public class CorsConfigurer implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // Origins
                .allowedOrigins("https://www.foo.com", "http://www.foo.com")

                // Headers
                .allowedHeaders("Authorization", "Content-Type", "accept")

                // methods
                .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE")

                // age
                .maxAge(10);
    }
}
