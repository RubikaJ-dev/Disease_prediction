package org.disease.repository;
import org.disease.Entity.ScoreRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRecordRepository extends JpaRepository<ScoreRecord,Integer> {
}
