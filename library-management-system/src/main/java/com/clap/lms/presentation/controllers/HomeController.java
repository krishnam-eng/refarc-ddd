package com.clap.lms.presentation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HomeController {

  @GetMapping("/")
  public void showAPIs(HttpServletResponse response) throws IOException {
    response.sendRedirect("/swagger-ui/index.html");
  }
}
