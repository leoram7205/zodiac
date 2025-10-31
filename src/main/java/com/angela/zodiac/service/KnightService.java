package com.angela.zodiac.service;

import com.angela.zodiac.entity.Knights;
import com.angela.zodiac.repository.KnightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class KnightService {
    
    @Autowired
    private KnightRepository knightRepository;
    
    public List<Knights> getAllKnights() {
        return knightRepository.findAll();
    }
    
    public Optional<Knights> getKnightById(String id) {
        return knightRepository.findById(id);
    }
    
    public Knights createKnight(Knights knight) {
        return knightRepository.save(knight);
    }
    
    public Knights updateKnight(String id, Knights knightDetails) {
        Optional<Knights> optionalKnight = knightRepository.findById(id);
        if (optionalKnight.isPresent()) {
            Knights knight = optionalKnight.get();
            knight.setName(knightDetails.getName());
            knight.setConstellation(knightDetails.getConstellation());
            knight.setRank(knightDetails.getRank());
            return knightRepository.save(knight);
        }
        return null;
    }
    
    public boolean deleteKnight(String id) {
        if (knightRepository.existsById(id)) {
            knightRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public List<Knights> findKnightsByName(String name) {
        return knightRepository.findByNameContainingIgnoreCase(name);
    }
    
    public List<Knights> findKnightsByConstellation(String constellation) {
        return knightRepository.findByConstellation(constellation);
    }
    
    public List<Knights> findKnightsByRank(int rank) {
        return knightRepository.findByRank(rank);
    }
    
    public List<Knights> findKnightsByRankGreaterThanEqual(int rank) {
        return knightRepository.findByRankGreaterThanEqual(rank);
    }
}
