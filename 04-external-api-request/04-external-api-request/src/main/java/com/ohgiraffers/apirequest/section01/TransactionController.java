package com.ohgiraffers.apirequest.section01;

import com.ohgiraffers.apirequest.section01.dto.RequestDTO;
import com.ohgiraffers.apirequest.section01.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/*
 * Spring에서 외부 API 요청 및 처리
 *
 * 대표적인 라이브러리
 * - HttpClient
 * - RestTemplate
 * - WebClient
 * - OpenFeign
 *
 * 주의할점
 * - request와 response가 외부서버와 맞게 설정되어있는지 확인!
 * */
@RestController
@RequestMapping("/translate")
@Slf4j
public class TransactionController {

    private final RestTemplateService restTemplateService;
    private final WebClientService webClientService;

    // 생성자 주입
    public TransactionController(RestTemplateService restTemplateService,WebClientService webClientService) {
        this.restTemplateService = restTemplateService;
        this.webClientService = webClientService;
    }

    @GetMapping("/test")
    public String test() {

        log.info("/test 로 get 요청 들어옴...");

        return "test success";
    }

    @PostMapping("/restTemplate")
    public ResponseDTO translateByRestTemplate(@RequestBody RequestDTO requestDTO) {

        log.info("번역[RestTemplate] Controller 요청 들어옴...");
        log.info("text: {}, lang: {}", requestDTO.getText(), requestDTO.getLang());

        ResponseDTO result = restTemplateService.translateText(requestDTO);

        return result;
    }

    @PostMapping("/webClient")
    public ResponseDTO translateByWebTemplate(@RequestBody RequestDTO requestDTO) {

        log.info("번역[RestTemplate] Controller 요청 들어옴...");
        log.info("text: {}, lang: {}", requestDTO.getText(), requestDTO.getLang());

        ResponseDTO result = webClientService.translateText(requestDTO);

        return result;
    }
}