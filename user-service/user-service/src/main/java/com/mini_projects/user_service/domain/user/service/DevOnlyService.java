package com.mini_projects.user_service.domain.user.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DevOnlyService {

    public String getDevOnlyMessage() {
        return "This is only available in the dev profile!";
    }
}