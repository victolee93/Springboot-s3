package com.victolee.s3exam.controller;

import com.victolee.s3exam.dto.GalleryDto;
import com.victolee.s3exam.service.GalleryService;
import com.victolee.s3exam.service.S3Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@AllArgsConstructor
public class GalleryController {
    private S3Service s3Service;
    private GalleryService galleryService;

    @GetMapping("/gallery")
    public String dispWrite(Model model) {
        List<GalleryDto> galleryDtoList = galleryService.getList();

        model.addAttribute("galleryList", galleryDtoList);

        return "/gallery";
    }

    @PostMapping("/gallery")
    public String execWrite(GalleryDto galleryDto, MultipartFile file) throws IOException {
        String imgPath = s3Service.upload(galleryDto.getFilePath(), file);
        galleryDto.setFilePath(imgPath);

        galleryService.savePost(galleryDto);

        return "redirect:/gallery";
    }
}

