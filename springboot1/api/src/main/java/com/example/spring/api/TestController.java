package com.example.spring.api;

import com.example.spring.User;
import com.example.spring.annotation.InjectUserInfo;
import com.example.spring.core.TestInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class TestController {

    @Autowired private TestInt testInt;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test() {
        return testInt.test();
        //return "agjfasgfja";
    }

    @RequestMapping(value = "inject", method = RequestMethod.GET)
    public User testInject(@InjectUserInfo(name = "XTB") User user) {
        return user;
    }
}
