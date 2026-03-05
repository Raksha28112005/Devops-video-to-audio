package com.example.video_audio;

import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class VideoController {

    @PostMapping("/convert")
    public ResponseEntity<FileSystemResource> convertVideo(@RequestParam("file") MultipartFile file) {

        try {

           File uploadDir = new File(System.getProperty("user.dir") + "/uploads");
           if (!uploadDir.exists()) {
             uploadDir.mkdirs();
            }
            File inputFile = new File(uploadDir.getAbsolutePath() + "/input.mp4");
            file.transferTo(inputFile);
            File outputFile = new File(uploadDir.getAbsolutePath() + "/output.mp3");
            // Run FFmpeg command
            ProcessBuilder pb = new ProcessBuilder(
                    "ffmpeg",
                    "-y",
                    "-i",
                    inputFile.getAbsolutePath(),
                    outputFile.getAbsolutePath()
            );

            pb.redirectErrorStream(true);
            Process process = pb.start();

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            process.waitFor();

            if (!outputFile.exists()) {
                return ResponseEntity.internalServerError().build();
            }

            FileSystemResource resource = new FileSystemResource(outputFile);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=audio.mp3")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}