package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Match;
import com.edutech.progressive.repository.MatchRepository;
import com.edutech.progressive.service.MatchService;

@Service
public class MatchServiceImplJpa implements MatchService {

    private final MatchRepository matchRepository;

    @Autowired
    public MatchServiceImplJpa(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public List<Match> getAllMatches() throws SQLException {
        return matchRepository.findAll();
    }

    @Override
    public Match getMatchById(int matchId) throws SQLException {
        return matchRepository.findById(matchId).orElse(null);
    }

    @Override
    public Integer addMatch(Match match) throws SQLException {
        Match savedMatch = matchRepository.save(match);
        return savedMatch.getMatchId();
    }

    @Override
    public void updateMatch(Match match) throws SQLException {
        matchRepository.save(match);
    }

    @Override
    public void deleteMatch(int matchId) throws SQLException {
        matchRepository.deleteById(matchId);
    }

    @Override
    public List<Match> getAllMatchesByStatus(String status) throws SQLException {
        return matchRepository.findAll()
                .stream()
                .filter(match -> match.getStatus() != null && match.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }
}