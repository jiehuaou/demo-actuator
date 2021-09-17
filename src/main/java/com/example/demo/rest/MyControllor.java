package com.example.demo.rest;

import com.example.demo.config.HelloConfig;
import com.example.demo.pojo.MyDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class MyControllor {
    @Autowired
    HelloConfig config;

    @RequestMapping("/hello")
    public String hello() {
        return config.getGreeting();
    }

    @RequestMapping("/hello/{id}")
    public MyDoc helloDoc(@PathVariable("id") String id
            , @RequestHeader("my-data") Optional<String> myHeader){
        MyDoc doc = new MyDoc(id, config.getGreeting(), myHeader.orElse("other"));
        return doc;
    }

    @RequestMapping("/hi")
    public MyDoc hi(@RequestParam(name="id") Optional<String> id,
                    @RequestHeader("my-data") Optional<String> myHeader){
        // hi?id=abc

        final String myId = id.orElse("not provided");
        MyDoc doc = new MyDoc(myId, config.getGreeting(), myHeader.orElse("other"));

        return doc;
    }
}
