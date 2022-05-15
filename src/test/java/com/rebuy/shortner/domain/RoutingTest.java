package com.rebuy.shortner.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RoutingTest {
    @Test
    void should_create_a_routing_successfully(){
        Routing routing = new Routing("bi3L","www.google.com");
        assertThat(routing.getOriginalUrl()).isEqualTo("www.google.com");
    }
}
