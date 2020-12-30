package com.jyoshita.sample.ecsspringbootbff.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@ConfigurationProperties(prefix="service")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceProperties {
  private String dns;
}
