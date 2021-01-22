package com.example.transcribe.service;

import com.example.transcribe.dao.TranscribeDAO;

import java.util.List;
import java.util.Optional;

public interface TranscribeService {

    TranscribeDAO save(TranscribeDAO transcribeDAO);

    void delete(TranscribeDAO transcribeDAO);

    void delete(String id);

    Optional<TranscribeDAO> findOne(String id);

    Iterable<TranscribeDAO> findAll();

    List<TranscribeDAO> findByTranscribeText(String transcribeText);

    List<TranscribeDAO> findByTextFileName(String title);
}
