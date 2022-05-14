package com.rebuy.shortner.infrastructure;

import com.rebuy.shortner.domain.Routing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoutingRepository extends JpaRepository<Routing, String> {
    @Override
    Optional<Routing> findById(String id);
}
