package com.victolee.s3exam.dto;

import com.victolee.s3exam.domain.entity.GalleryEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GalleryDto {
    private Long id;
    private String title;
    private String filePath;

    public GalleryEntity toEntity(){
        GalleryEntity build = GalleryEntity.builder()
                .id(id)
                .title(title)
                .filePath(filePath)
                .build();
        return build;
    }

    @Builder
    public GalleryDto(Long id, String title, String filePath) {
        this.id = id;
        this.title = title;
        this.filePath = filePath;
    }
}
