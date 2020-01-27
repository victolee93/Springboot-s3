package com.victolee.s3exam.domain.repository;

import com.victolee.s3exam.domain.entity.GalleryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryRepository extends JpaRepository<GalleryEntity, Long> {
}
