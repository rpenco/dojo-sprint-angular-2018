package com.foo.storage;

import com.foo.dto.TechnoDto;
import com.foo.dto.TechnoLightDto;
import com.foo.storage.entity.TechnoEntity;
import com.foo.storage.repository.TechnoRepository;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class TechnoService {

    @Autowired
    MapperFactory mapperFactory;

    @Autowired
    TechnoRepository technoRepository;


    public TechnoDto createTechno(TechnoDto technoDto) {

        TechnoEntity technoEntity = mapperFactory.getMapperFacade().map(technoDto, TechnoEntity.class);
        technoEntity.setCreatedDate(ZonedDateTime.now());
        TechnoDto createdDto = mapperFactory.getMapperFacade().map(technoRepository.save(technoEntity), TechnoDto.class);

        return createdDto;
    }

    public List<TechnoLightDto> getAllTechnos() {
        List<TechnoEntity> technoEntityList = technoRepository.findAll();
        return mapperFactory.getMapperFacade().mapAsList(technoEntityList, TechnoLightDto.class);
    }

    public TechnoDto getTechno(String id) {
        Optional<TechnoEntity> technoEntity = technoRepository.findById(id);
        if (technoEntity.isPresent()) {
            return mapperFactory.getMapperFacade().map(technoEntity.get(), TechnoDto.class);
        }

        return null;
    }

    @Transactional
    public void deleteTechno(String id) {
        this.technoRepository.deleteById(id);
    }


    public List<TechnoLightDto> getTechnoLight() {
        List<TechnoEntity> technoEntityList = technoRepository.findAll();
        return mapperFactory.getMapperFacade().mapAsList(technoEntityList, TechnoLightDto.class);
    }
}
