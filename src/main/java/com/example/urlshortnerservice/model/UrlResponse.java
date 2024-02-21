package com.example.urlshortnerservice.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UrlResponse {
    private String originalUrl;
    private String tinyUrl;
    private LocalDateTime expiryDate;

    public UrlResponse(String originalUrl, String tinyUrl, LocalDateTime expiryDate) {
        this.originalUrl = originalUrl;
        this.tinyUrl = tinyUrl;
        this.expiryDate = expiryDate;
    }

    public UrlResponse() {

    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getTinyUrl() {
        return tinyUrl;
    }

    public void setTinyUrl(String tinyUrl) {
        this.tinyUrl = tinyUrl;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "UrlResponse{" +
                "originalUrl='" + originalUrl + '\'' +
                ", tinyUrl='" + tinyUrl + '\'' +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
