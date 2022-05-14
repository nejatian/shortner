package com.rebuy.shortner.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "routing")
public class Routing {
    @Id
    @Column(name = "shorted_link", length = 4)
    private String shortUrl;
    @Column(name = "original_link", columnDefinition = "text")
    private String originalUrl;
}
