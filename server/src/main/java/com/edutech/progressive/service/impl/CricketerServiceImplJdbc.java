package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.dao.MatchDAO;
import com.edutech.progressive.entity.Match;
import com.edutech.progressive.service.MatchService;

public class CricketerServiceImplJdbc implements MatchService  {

    private MatchDAO matchDAO;

    public CricketerServiceImplJdbc(MatchDAO matchDAO) {
        this.matchDAO = matchDAO;
    }

    @Override
    public List<Match> getAllMatches() {
        return new ArrayList<>();
    }
    @Override
    public Match getMatchById(int matchId) {
        return null;
    }

    @Override
    public Integer addMatch(Match match) {
        return -1;
    }

    @Override
    public void updateMatch(Match match) {
    }

    @Override
    public void deleteMatch(int matchId) {
       
    }

}