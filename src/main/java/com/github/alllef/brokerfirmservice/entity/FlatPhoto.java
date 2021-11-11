package com.github.alllef.brokerfirmservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.File;
import java.util.Objects;

@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class FlatPhoto {
    @Id
    private Long flatPhotoId;
    private Long flatId;
    private File photo;
}
