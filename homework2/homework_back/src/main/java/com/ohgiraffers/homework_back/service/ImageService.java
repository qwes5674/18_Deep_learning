package com.ohgiraffers.homework_back.service;

import com.ohgiraffers.homework_back.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@Slf4j
public class ImageService {

    // 요청 보낼 url
    private final String FAST_API_SERVER_URL = "http://localhost:8000/analyze";

    public static ResponseDTO analyzeimage(MultipartFile file) {

        // 파일 가져오기
        ResponseDTO fileName = file.getOriginalFilename();

        // 파일 저장
        File destinationFile = new File(fileName);
        try{
            file.transferTo(destinationFile);
            return "파일이 성공적으로 업로드되었습니다: " + fileName;
        }catch(IOException e){
            e.printStackTrace();;
            return "파일 업로드 중 오류 발생" + e.getMessage();
        }

    }
}
