package com.pj.portfoliosite.coolsms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pj.portfoliosite.coolsms.service.CoolsmsService;

@RestController
@RequiredArgsConstructor
public class CoolsmsController {
    private final CoolsmsService coolsmsService;
    @PostMapping("/api/send")
    public HttpEntity<String> sendMessage(@RequestBody String message) {
        System.out.println("message = " + message);
        coolsmsService.sendMessage(message);
     return new HttpEntity<>("전송 성공");
    }
}
