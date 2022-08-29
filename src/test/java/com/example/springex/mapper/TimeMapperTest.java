package com.example.springex.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
class TimeMapperTest {

    @Autowired(required = false)
    private TimeMapper mapper;

    @Autowired(required = false)
    private TimeMapper2 mapper2;

    @Test
    public void testGetTime(){
        log.info(mapper2.getNow());
    }
}