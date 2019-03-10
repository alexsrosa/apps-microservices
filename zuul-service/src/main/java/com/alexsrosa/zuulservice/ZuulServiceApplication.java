package com.alexsrosa.zuulservice;

import com.alexsrosa.zuulservice.helper.Constants;
import com.alexsrosa.zuulservice.helper.DefaultProfileHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collection;

@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
public class ZuulServiceApplication {

    private static final Logger log = LoggerFactory.getLogger(ZuulServiceApplication.class);

    @Autowired
    private Environment env;

    @PostConstruct
    public void initApplication() throws Exception {
        log.info("Running with Spring profile(s) : {}", Arrays.toString(env.getActiveProfiles()));
        Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
        if (activeProfiles.contains(Constants.SPRING_PROFILE_LOCAL)
                && activeProfiles.contains(Constants.SPRING_PROFILE_PRODUCTION)) {
            log.error("'local' and 'prod' profiles at the same time is not allowed.");
        }
    }

    public static void main(String[] args) throws Exception {
        SpringApplication zuulServiceApplication = new SpringApplication(ZuulServiceApplication.class);
        DefaultProfileHelper.addDefaultProfile(zuulServiceApplication, args);
        zuulServiceApplication.run(args);
    }

}
