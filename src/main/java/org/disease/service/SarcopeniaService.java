package org.disease.service;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.http.impl.bootstrap.HttpServer;
import org.disease.Entity.ScoreRecord;

import java.io.IOException;

public interface SarcopeniaService {

    void saveScore(ScoreRecord record);
    void exportScoresToExcel(HttpServletResponse response) throws IOException;
}
