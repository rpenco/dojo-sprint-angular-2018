package com.foo.storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component("dateTimeService")
public class CurrentTimeDateTimeService implements DateTimeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentTimeDateTimeService.class);

    @Override
    public ZonedDateTime getCurrentDateAndTime() {
        ZonedDateTime currentDateAndTime = ZonedDateTime.now();
        LOGGER.info("===> CurrentDateTime : ", currentDateAndTime);
        return currentDateAndTime;
    }
}