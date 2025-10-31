package com.angela.zodiac.repository;

import com.angela.zodiac.entity.Knights;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface KnightRepository extends MongoRepository<Knights, String> {
    
    List<Knights> findByNameContainingIgnoreCase(String name);
    
    List<Knights> findByConstellation(String constellation);
    
    List<Knights> findByRank(int rank);
    
    List<Knights> findByRankGreaterThanEqual(int rank);
}
