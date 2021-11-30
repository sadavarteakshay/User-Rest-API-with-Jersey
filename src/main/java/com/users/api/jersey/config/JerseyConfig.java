package com.users.api.jersey.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.users.api.jersey.resource.UsersResource;

@Component
public class JerseyConfig extends ResourceConfig 
{
    public JerseyConfig() 
    {
        register(UsersResource.class);
    }
}