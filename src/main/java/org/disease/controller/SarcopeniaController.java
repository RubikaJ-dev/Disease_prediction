package org.disease.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.disease.Entity.ScoreRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.disease.service.SarcopeniaService;

import java.io.IOException;

@RestController
@RequestMapping("/api/user")
public class SarcopeniaController {

    @Autowired
    private SarcopeniaService sarcopeniaService; // Ensure this class exists

    @PostMapping("/saveScore")
    public ResponseEntity<String> saveScore(@RequestBody ScoreRecord record) { // Ensure ScoreRecord class exists
        sarcopeniaService.saveScore(record);
        return ResponseEntity.ok("Score saved successfully");
    }

    @GetMapping("/export")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=sarcopenia_scores.xlsx");

        sarcopeniaService.exportScoresToExcel(response);
    }
}
