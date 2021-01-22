package com.example.transcribe.repo;

import com.example.transcribe.dao.TranscribeDAO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface TranscribeRepository extends ElasticsearchRepository<TranscribeDAO, String> {

    List<TranscribeDAO> findByTranscribeText(String transcribeText);

    List<TranscribeDAO> findByTextFileName(String textFileName);
}
