package com.rebuy.shortner.application;

import com.rebuy.shortner.domain.Routing;
import com.rebuy.shortner.infrastructure.RoutingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoutingServiceImpl implements RoutingService{
    private final RoutingRepository routingRepository;

    public RoutingServiceImpl(RoutingRepository routingRepository) {
        this.routingRepository = routingRepository;
    }

    @Override
    public String generateUrl(String url) {
        return null;
    }

    @Override
    public String redirectToUrl(String id) {
        String url = "";
        Optional<Routing> routing = routingRepository.findById(id);
        if(routing.isPresent()){
           url = routing.get().getOriginalUrl();
       }
        return url;
    }
}
