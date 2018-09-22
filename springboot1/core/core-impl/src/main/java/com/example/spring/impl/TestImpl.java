package com.example.spring.impl;

import com.example.spring.core.TestInt;
import org.springframework.stereotype.Service;

@Service
public class TestImpl implements TestInt {


    @Override
    public String test() {
        return "Hello World!";
    }
}
