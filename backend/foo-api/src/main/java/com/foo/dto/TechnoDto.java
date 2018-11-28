package com.foo.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class TechnoDto extends TechnoLightDto {

    private String version;

    private ZonedDateTime createdDate;
}
