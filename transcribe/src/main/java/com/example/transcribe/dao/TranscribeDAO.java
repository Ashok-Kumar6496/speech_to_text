package com.example.transcribe.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "transcribe")
public class TranscribeDAO {
    @Id
    private String id;
    private String transcribeText;
    private String textFileName;
    private Long noOfOccurances;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTranscribeText() {
        return transcribeText;
    }

    public void setTranscribeText(String transcribeText) {
        this.transcribeText = transcribeText;
    }

    public String getTextFileName() {
        return textFileName;
    }

    public void setTextFileName(String textFileName) {
        this.textFileName = textFileName;
    }

    public Long getNoOfOccurances() {
        return noOfOccurances;
    }

    public void setNoOfOccurances(Long noOfOccurances) {
        this.noOfOccurances = noOfOccurances;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TranscribeDAO{");
        sb.append("id=").append(id);
        sb.append(", transcribeText='").append(transcribeText).append('\'');
        sb.append(", textFileName='").append(textFileName).append('\'');
        sb.append(", noOfOccurances=").append(noOfOccurances);
        sb.append('}');
        return sb.toString();
    }
}
