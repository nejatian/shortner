package com.rebuy.shortner.infrastructure;

import com.rebuy.shortner.domain.Routing;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RoutingRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    RoutingRepository routingRepository;

    @Test
    void should_retrieve_routing_successfully(){
        //given
        Routing routing = new Routing("B2nj","www.yahoo.com");
        entityManager.persist(routing);
        entityManager.flush();

        //when
        Routing found = routingRepository.getById("B2nj");

        //then
        assertThat(found.getShortUrl()).isEqualTo(routing.getShortUrl());
    }
    @Test
    void should_retrieve_routing_by_original_url_successfully(){
        //given
        Routing routing = new Routing("B2nj","www.yahoo.com");
        entityManager.persist(routing);
        entityManager.flush();

        //when
        Routing found = routingRepository.findRoutingByOriginalUrl("www.yahoo.com").get();

        //then
        assertThat(found.getShortUrl()).isEqualTo(routing.getShortUrl());
    }
}
