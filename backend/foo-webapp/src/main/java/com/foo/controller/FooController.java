package com.foo.controller;

import com.foo.dto.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * foo controller
 *
 * @author J.GROCH
 */
@RestController
@RequestMapping(value = "/foo")
public class FooController {

    private static final Logger logger = LoggerFactory.getLogger(FooController.class);

    @Autowired
    private UserContext userContext;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> foo() {

        logger.info("hello world");
        return new ResponseEntity<>("Hello " + userContext.getNom() + " cmp : " + userContext.getCmp(), HttpStatus.OK);
    }
}
