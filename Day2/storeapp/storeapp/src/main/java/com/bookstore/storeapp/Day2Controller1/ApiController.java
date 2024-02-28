package com.bookstore.storeapp.Day2Controller1;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
public class ApiController {
   @Autowired
   AppConfig conf;

   @GetMapping("/info")
   public String getApp() {
      return new String(conf.getAppName()+" "+conf.getAppVersion());
   }

}
