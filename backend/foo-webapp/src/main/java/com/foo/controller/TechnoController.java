package com.foo.controller;

import com.foo.dto.TechnoDto;
import com.foo.dto.TechnoLightDto;
import com.foo.storage.TechnoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/technos")
public class TechnoController {

    @Autowired
    private TechnoService technoService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(method = POST)
    public ResponseEntity<TechnoDto> createTechnos(@RequestBody TechnoDto technoDto) {

        TechnoDto createdTechno = technoService.createTechno(technoDto);
        return new ResponseEntity<>(createdTechno, CREATED);
    }

    @RequestMapping(method = GET)
    public ResponseEntity<List<TechnoLightDto>> getAllTechnos() {

        List<TechnoLightDto> listTechno = technoService.getAllTechnos();
        return new ResponseEntity<>(listTechno, OK);
    }

    @RequestMapping(method = GET, value = "/{id}")
    public ResponseEntity<TechnoDto> getTechno(@PathVariable("id") String id) {

        TechnoDto technoDto = technoService.getTechno(id);

        if (technoDto == null) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(technoDto, OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TechnoDto> deleteOneTechno(@PathVariable("id") String id){
        this.technoService.deleteTechno(id);
        return new ResponseEntity<>(OK);
    }

}
