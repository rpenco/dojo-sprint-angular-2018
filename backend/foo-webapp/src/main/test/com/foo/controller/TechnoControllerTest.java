package com.foo.controller;

import com.foo.dto.TechnoDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TechnoControllerTest {

    @Autowired
    private TechnoController portalController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() {
        assertThat(portalController).isNotNull();
    }

    @Test
    public void postNewTechnoTest() throws Exception {

        TechnoDto technoDto = new TechnoDto();
        technoDto.setName("Angular");
        technoDto.setVersion("1.0.0");
        technoDto.setCreatedDate(ZonedDateTime.now());

        this.mockMvc.perform(
                post("/technos", technoDto))
                .andDo(print())
                .andExpect(status()
                        .isCreated());
    }
}
