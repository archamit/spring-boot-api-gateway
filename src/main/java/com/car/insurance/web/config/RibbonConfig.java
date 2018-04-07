package com.car.insurance.web.config;

import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;

class RibbonConfig {
    @Bean
    ServerList<Server> ribbonServerList() {
        return new StaticServerList<>(new Server("httpbin.org", 80));
    }
}