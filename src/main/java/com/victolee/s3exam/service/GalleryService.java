package com.victolee.s3exam.service;

import com.victolee.s3exam.domain.repository.GalleryRepository;
import com.victolee.s3exam.dto.GalleryDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GalleryService {
    private GalleryRepository galleryRepository;

    public void savePost(GalleryDto galleryDto) {
        galleryRepository.save(galleryDto.toEntity());
    }
}
