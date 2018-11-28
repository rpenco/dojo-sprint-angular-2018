package com.foo.storage;

import org.springframework.data.auditing.DateTimeProvider;

import java.time.temporal.TemporalAccessor;
import java.util.Optional;

public class AuditingDateTimeProvider implements DateTimeProvider {

    private final DateTimeService dateTimeService;

    public AuditingDateTimeProvider(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }

//    @Override
//    public Calendar getNow() {
//        return GregorianCalendar.from(dateTimeService.getCurrentDateAndTime());
//    }

    @Override
    public Optional<TemporalAccessor> getNow() {
        return Optional.of(dateTimeService.getCurrentDateAndTime());
    }

}