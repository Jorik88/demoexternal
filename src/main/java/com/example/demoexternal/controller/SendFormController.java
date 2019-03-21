package com.example.demoexternal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SendFormController {

    @GetMapping("/send")
    public String sendForm(Model model) {
        model.addAttribute("token", "some token");
        model.addAttribute("paymentSystemUrl", "http://localhost:8080/form");
        return "bepaid";
    }

    @GetMapping("test1")
    public String test(Model model) {
        System.out.println();
//        model.addAttribute("url", "https://unitpay.ru/pay/demo/qiwi?sum=10&account=demo&desc=testPayment&sign=6e44a7a6e6f28105ac54eabee47c1860");
        model.addAttribute("url", "https://unitpay.ru/pay/demo/card");
        model.addAttribute("sum", "5345.55");
        model.addAttribute("account", "demo");
        model.addAttribute("desc", "testPayment");
        return "test2";
    }
}
