package com.ino.urlshorter.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;

@Document(collection = "urls")
public class UrlEntity {
    @Id
    private String id;
    private String url;
    private String fullUrl;
    private LocalTime expireAt;

    public UrlEntity() {

    }

    public UrlEntity(String id, String url, String fullUrl, LocalTime expireAt) {
        this.id = id;
        this.url = url;
        this.fullUrl = fullUrl;
        this.expireAt = expireAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public LocalTime getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(LocalTime expireAt) {
        this.expireAt = expireAt;
    }
}
