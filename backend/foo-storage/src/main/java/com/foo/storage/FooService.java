package com.foo.storage;

import com.foo.dto.FooDto;
import com.foo.storage.entity.FooEntity;
import com.foo.storage.repository.FooRepository;
import ma.glasnost.orika.MapperFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * foo service
 *
 * @author J.GROCH
 */
@Component
public class FooService {

    private static final Logger logger = LoggerFactory.getLogger(FooService.class);

    @Autowired
    private FooRepository fooRepository;

    @Autowired
    private MapperFactory mapperFactory;

    public FooDto findOne(String id) {
        FooEntity fooEnt = fooRepository.findById(id).orElseThrow(() -> {
            logger.error("findOne - foo not found for : " + id);
            return new RuntimeException("oups !");
        });
        FooDto fooDto = new FooDto();

        fooDto.setA("bar");
         mapperFactory.getMapperFacade().map(fooEnt, fooDto);
         return fooDto;
    }
}
