package com.rebuy.shortner.application;

import com.rebuy.shortner.domain.Routing;
import com.rebuy.shortner.infrastructure.RoutingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class RoutingServiceTest {
    @Autowired
    RoutingService routingService;
    @MockBean
    RoutingRepository routingRepository;

    @Test
    void should_return_url_successfully(){
        Routing expected = new Routing("Q8jk","www.rebuy.de");


    }
}
