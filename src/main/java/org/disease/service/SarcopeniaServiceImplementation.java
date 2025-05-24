package org.disease.service;



import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.disease.Entity.ScoreRecord;
import org.disease.repository.ScoreRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.IOException;
import java.util.List;

@Service
public class SarcopeniaServiceImplementation implements SarcopeniaService {

    @Autowired
    private ScoreRecordRepository scoreRecordRepository;

    @Override
    public void saveScore(ScoreRecord record) {
        scoreRecordRepository.save(record);
    }

    @Override
    public void exportScoresToExcel(HttpServletResponse response) throws IOException {
        List<ScoreRecord> scores = scoreRecordRepository.findAll();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sarcopenia Scores");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("User ID");
        headerRow.createCell(1).setCellValue("Score");

        int rowIdx = 1;
        for (ScoreRecord record : scores) {
            Row row = sheet.createRow(rowIdx++);
            row.createCell(0).setCellValue(record.getUserId());
            row.createCell(1).setCellValue(record.getScore());
        }

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
