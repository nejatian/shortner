package com.rebuy.shortner.application;

public interface RoutingService {
    String generateUrl(String url);
    String redirectToUrl(String id);
}
