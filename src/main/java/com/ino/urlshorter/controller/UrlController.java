package com.ino.urlshorter.controller;

import com.ino.urlshorter.dto.ShortenUrlRequest;
import com.ino.urlshorter.dto.ShortenUrlResponse;
import com.ino.urlshorter.entities.UrlEntity;
import com.ino.urlshorter.repository.UrlRepository;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class UrlController {

    private final UrlRepository urlRepository;

    public UrlController(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @PostMapping(value = "/shorten-url")
    public ResponseEntity<ShortenUrlResponse> shortenUrl(@RequestBody ShortenUrlRequest request,
                                                         HttpServletRequest httpServletRequest, ServletResponse servletResponse) {

        String id;
        do {
            id = RandomStringUtils.randomAlphanumeric(5,10);
        } while (urlRepository.existsById(id));

        urlRepository.save(new UrlEntity(id, request.url(), LocalDateTime.now().plusMinutes(1)));

        var redirectUrl = httpServletRequest.getRequestURL().toString().replace("shorten-url", id);
        return ResponseEntity.ok(new ShortenUrlResponse(redirectUrl));
    }
}
