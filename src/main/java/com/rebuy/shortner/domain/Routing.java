package com.rebuy.shortner.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "routing")
public class Routing {
    @Id
    @Column(name = "shorted_link", length = 4)
    private String shortUrl;
    @Column(name = "original_link", columnDefinition = "text")
    private String originalUrl;
}
