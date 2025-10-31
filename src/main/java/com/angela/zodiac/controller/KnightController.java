package com.angela.zodiac.controller;

import com.angela.zodiac.entity.Knights;
import com.angela.zodiac.service.KnightService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/knights")
@CrossOrigin(origins = "*")
public class KnightController {
    
    @Autowired
    private KnightService knightService;
    
    @GetMapping
    public ResponseEntity<List<Knights>> getAllKnights() {
        List<Knights> knights = knightService.getAllKnights();
        return new ResponseEntity<>(knights, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Knights> getKnightById(@PathVariable String id) {
        Optional<Knights> knight = knightService.getKnightById(id);
        return knight.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping
    public ResponseEntity<Knights> createKnight(@Valid @RequestBody Knights knight) {
        Knights createdKnight = knightService.createKnight(knight);
        return new ResponseEntity<>(createdKnight, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Knights> updateKnight(@PathVariable String id, 
                                              @Valid @RequestBody Knights knightDetails) {
        Knights updatedKnight = knightService.updateKnight(id, knightDetails);
        if (updatedKnight != null) {
            return new ResponseEntity<>(updatedKnight, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKnight(@PathVariable String id) {
        if (knightService.deleteKnight(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/search/name")
    public ResponseEntity<List<Knights>> searchKnightsByName(@RequestParam String name) {
        List<Knights> knights = knightService.findKnightsByName(name);
        return new ResponseEntity<>(knights, HttpStatus.OK);
    }
    
    @GetMapping("/search/constellation")
    public ResponseEntity<List<Knights>> searchKnightsByConstellation(@RequestParam String constellation) {
        List<Knights> knights = knightService.findKnightsByConstellation(constellation);
        return new ResponseEntity<>(knights, HttpStatus.OK);
    }
    
    @GetMapping("/search/rank")
    public ResponseEntity<List<Knights>> searchKnightsByRank(@RequestParam int rank) {
        List<Knights> knights = knightService.findKnightsByRank(rank);
        return new ResponseEntity<>(knights, HttpStatus.OK);
    }
    
    @GetMapping("/search/rank-greater-equal")
    public ResponseEntity<List<Knights>> searchKnightsByRankGreaterThanEqual(@RequestParam int rank) {
        List<Knights> knights = knightService.findKnightsByRankGreaterThanEqual(rank);
        return new ResponseEntity<>(knights, HttpStatus.OK);
    }
}
