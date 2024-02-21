package com.example.urlshortnerservice.Controller;

import com.example.urlshortnerservice.model.Url;
import com.example.urlshortnerservice.model.UrlDto;
import com.example.urlshortnerservice.model.UrlResponse;
import com.example.urlshortnerservice.repository.UrlRepository;
import com.example.urlshortnerservice.service.UrlService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class UrlController {
    private final UrlService urlService;
    private final String BASE_URL = "";

    @Autowired
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/generate")
    public ResponseEntity<?> generateTinyUrl(@RequestBody UrlDto urlDto) {
        System.out.println("Received URL:" + urlDto.getUrl());
        Url urlToConvert = urlService.generateTinyUrl(urlDto);
        if (urlToConvert != null) {
            UrlResponse urlResponse = new UrlResponse();
            urlResponse.setTinyUrl(urlToConvert.getTinyUrl());
            urlResponse.setOriginalUrl(urlDto.getUrl());
            urlResponse.setExpiryDate(urlToConvert.getExpirationDate());
            return new ResponseEntity<UrlResponse>(urlResponse, HttpStatus.OK);
        }
        return (ResponseEntity<?>) ResponseEntity.noContent();
    }

    @GetMapping("/get-all")
    public List<Url> getAllUrls() {
        return urlService.getAllUrls();
    }

    @GetMapping("/{tinyUrl}")
    public void redirectToOriginalUrl(@PathVariable String tinyUrl, HttpServletResponse response) throws IOException {
        Url urlToReturn = urlService.getTinyUrl(tinyUrl);
        if (urlToReturn != null) {
            response.sendRedirect(urlToReturn.getOriginalUrl());
        }
    }
    @DeleteMapping("/delete/{tinyUrl}")
    public ResponseEntity<?> deleteTinyUrl(@PathVariable String tinyUrl) {
        Url urlToDelete = urlService.getTinyUrl(tinyUrl);
        UrlResponse urlResponse = new UrlResponse();
        if (urlToDelete != null) {
            urlService.deleteTinyUrl(urlToDelete);
            return new ResponseEntity<UrlResponse>(urlResponse, HttpStatus.OK);
        }
        return (ResponseEntity<?>) ResponseEntity.notFound();
    }
}
