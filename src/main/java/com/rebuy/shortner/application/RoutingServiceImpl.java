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
        String shortUrl = "";
        Optional<Routing> existingURL =routingRepository.findRoutingByOriginalUrl(url);
        if(existingURL.isPresent()){
            shortUrl =  existingURL.get().getShortUrl();
        }
        else {
            //todo: generate
            Routing routing = new Routing();
            routing.setShortUrl(shortUrl);
            routing.setOriginalUrl(url);
            //todo: retry to save
            try{
                routingRepository.save(routing);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        shortUrl = "localhost/" + shortUrl;
        return shortUrl;
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
