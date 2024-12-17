package com.ino.urlshorter.controller;

import com.ino.urlshorter.dto.ShortenUrlRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlController {
    @PostMapping(value = "/shorten-url")
    public ResponseEntity<Void> shortenurl(@RequestBody ShortenUrlRequest request) {

        return ResponseEntity.ok().build();
    }
}
