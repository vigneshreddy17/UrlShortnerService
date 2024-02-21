package com.example.urlshortnerservice.service;

import com.example.urlshortnerservice.model.Url;
import com.example.urlshortnerservice.model.UrlDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UrlService {
    public Url generateTinyUrl(UrlDto urlDto);
    public Url persistTinyUrl(Url url);
    public Url getTinyUrl(String url);
    public void deleteTinyUrl(Url url);
    public List<Url> getAllUrls();
}
