package com.alexsrosa.zuulservice.config;

import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.route.RibbonCommandFactory;
import org.springframework.cloud.netflix.zuul.filters.route.apache.HttpClientRibbonCommandFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfig {

    /**
     * The default RestClientRibbonCommandFactory doesn't support PATCH method.
     * That is why we are using HttpClientRibbonCommandFactory instead.
     */
    @Bean
    public RibbonCommandFactory ribbonCommandFactory(SpringClientFactory clientFactory, ZuulProperties zuulProperties) {
        return new HttpClientRibbonCommandFactory(clientFactory, zuulProperties);
    }
}
