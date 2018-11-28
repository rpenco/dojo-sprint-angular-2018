package com.foo.storage;

import com.foo.dto.TechnoDto;
import com.foo.storage.entity.TechnoEntity;
import com.foo.storage.repository.TechnoRepository;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.ZonedDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PortalServiceTest {

    @Mock
    private TechnoRepository technoRepository;

    private TechnoService portalService = new TechnoService();

    @Before
    public void init() {
        when(technoRepository.save(any(TechnoEntity.class))).thenReturn(any(TechnoEntity.class));

        portalService.technoRepository = technoRepository;
        portalService.mapperFactory = new DefaultMapperFactory.Builder().build();
    }

    @Test(expected = Test.None.class)
    public void createTechnoTest() {
        TechnoDto technoDtoGiven = new TechnoDto();
        technoDtoGiven.setName("Angular");
        technoDtoGiven.setVersion("1.0.0");
        technoDtoGiven.setCreatedDate(ZonedDateTime.now());

        portalService.createTechno(technoDtoGiven);
    }
}
