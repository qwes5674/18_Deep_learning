package com.ohgiraffers.homework_back.controller;

import com.ohgiraffers.homework_back.dto.ResponseDTO;
import com.ohgiraffers.homework_back.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/analyze")
@Slf4j
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService){
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public ResponseDTO analyzeFile(@RequestBody MultipartFile file){

        ResponseDTO responseDTO = ImageService.analyzeimage(file);
        return responseDTO;

    }

}
