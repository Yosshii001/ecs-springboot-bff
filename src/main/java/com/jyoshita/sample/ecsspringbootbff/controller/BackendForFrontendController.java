package com.jyoshita.sample.ecsspringbootbff.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestOperations;

import com.jyoshita.sample.ecsspringbootbff.config.ServiceProperties;
import com.jyoshita.sample.ecsspringbootbff.model.User;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BackendForFrontendController {

//  private final RestOperations restOperations;
  private final ServiceProperties serviceProperties;
  private final RestTemplateBuilder restTemplateBuilder;

  @GetMapping(value = "users")
  public String getUsers(Model model){

    RestOperations restOperations = restTemplateBuilder
        .rootUri(serviceProperties.getDns())
        .build();

    String service = "/backend/api/v1/users";
    model.addAttribute("users",
        restOperations.getForObject(service, User[].class));
    return "users";
  }
}
