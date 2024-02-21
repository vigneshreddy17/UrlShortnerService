package com.example.urlshortnerservice.service;

import com.example.urlshortnerservice.UrlShortnerServiceApplication;
import com.example.urlshortnerservice.model.Url;
import com.example.urlshortnerservice.model.UrlDto;
import com.example.urlshortnerservice.repository.UrlRepository;
import com.google.common.hash.Hashing;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class UrlServiceImplementation implements UrlService{

    private final UrlRepository urlRepository;

    @Autowired
    public UrlServiceImplementation(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public Url generateTinyUrl(UrlDto urlDto) {
        if(StringUtils.isNotEmpty(urlDto.getUrl()))
        {
            String encodedUrl = encodeUrl(urlDto.getUrl());
            Url urlToPersist = new Url();
            urlToPersist.setCreationDate(LocalDateTime.now());
            urlToPersist.setOriginalUrl(urlDto.getUrl());
            urlToPersist.setTinyUrl(encodedUrl);
            urlToPersist.setExpirationDate(getExpirationDate(urlToPersist.getCreationDate()));
            Url urlToRet = persistTinyUrl(urlToPersist);

            if(urlToRet != null)
                return urlToRet;

            return null;
        }
        return null;
    }

    private LocalDateTime getExpirationDate(LocalDateTime creationDate) {
        return creationDate.plusMinutes(10);
    }

    private String encodeUrl(String url) {
        String encodedUrl = "";
        LocalDateTime time = LocalDateTime.now();
        encodedUrl = Hashing.adler32().hashString(url.concat(time.toString()), StandardCharsets.UTF_8).toString();
        return encodedUrl;
    }

    @Override
    public Url persistTinyUrl(Url url) {
        Url urlToSave = urlRepository.save(url);
        return urlToSave;
    }

    @Override
    public Url getTinyUrl(String url) {
        Url getUrl = urlRepository.findByTinyUrl(url);
        return getUrl;

    }

    @Override
    public void deleteTinyUrl(Url url) {
        urlRepository.delete(url);
    }

    @Override
    public List<Url> getAllUrls() {
        return urlRepository.findAll();
    }
}
