package com.foo.dto;

import lombok.Data;
import lombok.experimental.Accessors;

//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;


/**
 * foo pojo
 *
 * @author J.GROCH
 */
@Data
@Accessors(chain = true)
public class FooDto {

    //    @NotEmpty
//    @Size(max = 200)
    private String a;
    //
//    @NotEmpty
//    @Size(min = 18, max = 100)
    private int b;
}
