package com.example.demo;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@SpringBootApplication
public class DemoApplicationCMUSphinx {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplicationCMUSphinx.class, args);
        System.out.println("Loading models...");

        Configuration configuration = new Configuration();
        configuration.setSampleRate(8000);

        // Load model from the jar
        configuration
                .setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");

        // You can also load model from folder
        // configuration.setAcousticModelPath("file:en-us");

        configuration
                .setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration
                .setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

        StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(
                configuration);
        InputStream stream = new FileInputStream(new File("OSR_us_000_0018_8k.wav"));
        stream.skip(44);

        // Simple recognition with generic model
        recognizer.startRecognition(stream);
        SpeechResult result;
        String finalString = "";
        while ((result = recognizer.getResult()) != null) {
            finalString = finalString + "\n" + result.getHypothesis();

        }
        System.out.println("===================================Final Transcript from the file================================");
        System.out.println(finalString);
        recognizer.stopRecognition();

        // Live adaptation to speaker with speaker profiles

        /*stream = new FileInputStream(new File("OSR_us_000_0010_8k.wav"));
        stream.skip(44);

        // Stats class is used to collect speaker-specific data
        Stats stats = recognizer.createStats(1);
        recognizer.startRecognition(stream);
        while ((result = recognizer.getResult()) != null) {
            stats.collect(result);
        }
        recognizer.stopRecognition();

        // Transform represents the speech profile
        Transform transform = stats.createTransform();
        recognizer.setTransform(transform);

        // Decode again with updated transform
        stream = new FileInputStream(new File("OSR_us_000_0010_8k.wav"));
        stream.skip(44);
        recognizer.startRecognition(stream);
        while ((result = recognizer.getResult()) != null) {
            System.out.format("Hypothesis: %s\n", result.getHypothesis());
        }
        recognizer.stopRecognition();*/


    }

}
