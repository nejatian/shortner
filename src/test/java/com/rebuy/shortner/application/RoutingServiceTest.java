package com.rebuy.shortner.application;

import com.github.javafaker.Faker;
import com.rebuy.shortner.domain.Routing;
import com.rebuy.shortner.infrastructure.RoutingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RoutingServiceTest {
    @Autowired
    RoutingService routingService;
    @MockBean
    RoutingRepository routingRepository;

    @Test
    void should_return_same_short_link_successfully(){
     String url1 = "www.yahoo.com";
     String url2 = "www.yahoo.com";
     String short1 = routingService.generateUrl(url1);
     String short2= routingService.generateUrl(url2);

     assertThat(short1).isEqualTo(short2);
    }
}
