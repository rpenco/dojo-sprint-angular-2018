package com.foo;


import com.foo.dto.FooDto;
import com.foo.dto.TechnoDto;
import com.foo.dto.TechnoLightDto;
import com.foo.storage.TechnoService;
import com.foo.storage.entity.TechnoEntity;
import com.foo.storage.repository.TechnoRepository;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@ComponentScan(basePackages = "com.foo")
@EnableJpaRepositories(basePackages = "com.foo")
@EntityScan(basePackages = "com.foo")
public class FooSpringBootApp extends SpringBootServletInitializer {

    /**
     * CORS configuration
     *
     * @return WebMvcConfigurer
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new CorsConfigurer();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FooSpringBootApp.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(FooSpringBootApp.class, args);
    }

}
