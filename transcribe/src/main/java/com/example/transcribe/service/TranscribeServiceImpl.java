package com.example.transcribe.service;

import com.example.transcribe.dao.TranscribeDAO;
import com.example.transcribe.repo.TranscribeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TranscribeServiceImpl implements TranscribeService {

    private TranscribeRepository transcribeRepository;

    @Autowired
    public void setTranscribeRepository(TranscribeRepository transcribeRepository) {
        this.transcribeRepository = transcribeRepository;
    }

    @Override
    public TranscribeDAO save(TranscribeDAO transcribeDAO) {
        return transcribeRepository.save(transcribeDAO);
    }

    @Override
    public void delete(TranscribeDAO transcribeDAO) {
        transcribeRepository.delete(transcribeDAO);
    }

    @Override
    public void delete(String id) {
        transcribeRepository.deleteById(id);
    }

    @Override
    public Optional<TranscribeDAO> findOne(String id) {
        return transcribeRepository.findById(id);
    }

    @Override
    public Iterable<TranscribeDAO> findAll() {
        return transcribeRepository.findAll();
    }

    @Override
    public List<TranscribeDAO> findByTranscribeText(String transcribeText) {
        List<TranscribeDAO> list = transcribeRepository.findByTranscribeText(transcribeText);
        setOccuranceCount(list, transcribeText);
        return list;
    }

    private void setOccuranceCount(List<TranscribeDAO> list, String keyWord) {
        list.forEach(transcribeDAO -> {
            String[] text = transcribeDAO.getTranscribeText().split(" ");
            int count = 0;
            for (String s : text) {
                if (keyWord.equalsIgnoreCase(s))
                    count++;
                transcribeDAO.setNoOfOccurances((long) count);
            }
        });
    }

    @Override
    public List<TranscribeDAO> findByTextFileName(String title) {
        return transcribeRepository.findByTextFileName(title);
    }
}
