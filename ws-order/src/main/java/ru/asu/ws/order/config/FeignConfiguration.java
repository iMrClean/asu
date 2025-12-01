package ru.asu.ws.order.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = "ru.asu.ws.order.client")
@Configuration
public class FeignConfiguration { }
