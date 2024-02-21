package com.example.urlshortnerservice.repository;

import com.example.urlshortnerservice.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    public Url findByTinyUrl(String tinyUrl);
}
