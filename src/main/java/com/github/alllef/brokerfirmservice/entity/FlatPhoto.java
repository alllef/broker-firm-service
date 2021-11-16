package com.github.alllef.brokerfirmservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.File;
import java.util.Objects;

@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
@ToString
public class FlatPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flatPhotoId;
    private Long flatId;
    private String photoUrl;
}
