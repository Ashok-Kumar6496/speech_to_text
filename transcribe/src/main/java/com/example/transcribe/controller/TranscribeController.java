package com.example.transcribe.controller;

import com.example.transcribe.dao.TranscribeDAO;
import com.example.transcribe.service.TranscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/transcribe")
public class TranscribeController {

    @Autowired
    private TranscribeService transcribeService;

    @GetMapping(value = "/search-key", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<TranscribeDAO> searchByKeyWord(@RequestParam final String keyWord) {
        return transcribeService.findByTranscribeText(keyWord);
    }

    @GetMapping(value = "/search-file", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<TranscribeDAO> searchByFileName(@RequestParam final String fileName) {
        return transcribeService.findByTextFileName(fileName);
    }

    @PostMapping(value = "/save-transcribe", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TranscribeDAO saveTranscribe(@RequestBody final TranscribeDAO genericDAO) {
        return transcribeService.save(genericDAO);
    }

    @GetMapping("/health-check")
    public String getHealthStatus() {
        return "Application successfully working at : " + new Date();
    }
}
