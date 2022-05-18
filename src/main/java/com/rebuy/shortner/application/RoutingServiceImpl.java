package com.rebuy.shortner.application;

import com.rebuy.shortner.domain.Routing;
import com.rebuy.shortner.infrastructure.RoutingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoutingServiceImpl implements RoutingService{
    private final RoutingRepository routingRepository;
    private final CRC16Generator crc16Generator;

    public RoutingServiceImpl(RoutingRepository routingRepository, CRC16Generator crc16Generator) {
        this.routingRepository = routingRepository;
        this.crc16Generator = crc16Generator;
    }

    @Override
    public String generateUrl(String url) {
            String shortUrl = crc16Generator.generateHashUrl(url);
            Routing routing = new Routing();
            routing.setShortUrl(shortUrl);
            routing.setOriginalUrl(url);

            try{
                routingRepository.save(routing);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        shortUrl = "localhost:8080/" + shortUrl;
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
