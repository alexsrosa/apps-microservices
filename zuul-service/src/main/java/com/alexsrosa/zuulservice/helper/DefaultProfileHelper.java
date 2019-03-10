package com.alexsrosa.zuulservice.helper;

import org.springframework.boot.SpringApplication;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;

import static com.alexsrosa.zuulservice.helper.Constants.SPRING_PROFILE_DEFAULT;
import static com.alexsrosa.zuulservice.helper.Constants.SPRING_PROFILE_LOCAL;

public final class DefaultProfileHelper {

    private DefaultProfileHelper() { }

    public static void addDefaultProfile(SpringApplication app, String[] args) {
        Map<String, Object> defProperties =  new HashMap<String, Object>();
        defProperties.put(SPRING_PROFILE_DEFAULT, SPRING_PROFILE_LOCAL);
        app.setDefaultProperties(defProperties);
    }

    public static String[] getActiveProfiles(Environment env) {
        String[] profiles = env.getActiveProfiles();
        if (profiles.length == 0) {
            return env.getDefaultProfiles();
        }
        return profiles;
    }
}
