package com.example.springex.sample;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@Log4j2
@ExtendWith(SpringExtension.class)  //Spring test설정
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml") //스프링 설정 정보를 로딩하기 위해서 가져옴(XML이기에 이런식으로 가져옴)
class SampleServiceTest {
        @Autowired
        private SampleService sampleService;

        @Test
        public void testService1(){
            log.info(sampleService);
            Assertions.assertNotNull(sampleService);
        }
}