package com.example.demoexternal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UnitPayController {

    @GetMapping(value = "/HELP.md")
    public ResponseEntity test(HttpServletRequest request) {
        System.out.println("done");
        return ResponseEntity.ok().build();
    }

    @PostMapping("/form")
    public ResponseEntity formHandle(@RequestParam String token) {
        System.out.println("handle");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/verification-f612c.txt")
    public String test() {
        return "verification-f612c.txt";
    }
}
