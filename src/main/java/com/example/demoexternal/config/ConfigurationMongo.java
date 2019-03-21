package com.example.demoexternal.config;

import com.mongodb.MongoClient;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class ConfigurationMongo {

//    @Primary
//    @Bean
//    @ConfigurationProperties(prefix = "mongodb")
//    public MongoProperties getSecondary() {
//        return new MongoProperties();
//    }
//
//    @Bean
//    public MongoTemplate secondaryMongoTemplate() {
//        return new MongoTemplate(secondaryFactory(getSecondary()));
//    }
//
//    @Bean
//    public MongoDbFactory secondaryFactory(final MongoProperties mongo) {
//        return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
//                mongo.getDatabase());
//    }
}
