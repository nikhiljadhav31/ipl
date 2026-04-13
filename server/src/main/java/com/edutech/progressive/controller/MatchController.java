package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Match;
import org.springframework.http.ResponseEntity;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MatchController {

    public ResponseEntity<List<Match>> getAllMatches() {
        return null;
    }

    public ResponseEntity<Match> getMatchById(int matchId) {
        return null;
    }

    public ResponseEntity<Integer> addMatch(Match match) {
        return null;
    }

    public ResponseEntity<Void> updateMatch(int matchId, Match match) {
        return null;
    }

    public ResponseEntity<Void> deleteMatch(int matchId) {
        return null;
    }

    public ResponseEntity<List<Match>> getAllMatchesByStatus(String status) {
        return null;
    }
}