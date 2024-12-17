package com.ino.urlshorter.repository;

import com.ino.urlshorter.entities.UrlEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository  extends MongoRepository<UrlEntity, String> {

}
