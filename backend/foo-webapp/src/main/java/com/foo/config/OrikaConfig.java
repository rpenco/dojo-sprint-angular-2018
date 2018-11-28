package com.foo.config;

import com.foo.dto.TechnoDto;
import com.foo.dto.TechnoLightDto;
import com.foo.storage.entity.TechnoEntity;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrikaConfig {

    @Bean
    public MapperFactory mapperFactory() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        mapperFactory.classMap(TechnoDto.class, TechnoEntity.class).byDefault().register();
        mapperFactory.classMap(TechnoEntity.class, TechnoDto.class).byDefault().register();
        mapperFactory.classMap(TechnoEntity.class, TechnoLightDto.class).byDefault().register();

        return mapperFactory;
    }
}
