package com.edutech.progressive.dao;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.entity.Match;

public class MatchDAOImpl implements MatchDAO{

    List<Match> matches = new ArrayList<>();

    @Override
    public int addMatch(Match match) {
       matches.add(match);
       return -1;
    }

    @Override
    public Match getMatchById(int matchId) {
       Match m = matches.get(matchId);
       if (m!=null) {
        return m;
       }
       return null;
    }

    @Override
    public void updateMatch(Match match) {
        int mid = match.getMatchId();
        for (Match match2 : matches) {
            if (match2.getMatchId()==mid) {
                match2.setMatchDate(match.getMatchDate());
                match2.setFirstTeamId(match.getFirstTeamId());
                match2.setMatchId(match.getMatchId());
                match2.setResult(match.getResult());
                match2.setSecondTeamId(match.getSecondTeamId());
                match2.setStatus(match.getStatus());
                match2.setVenue(match.getVenue());
                match2.setWinnerTeamId(match.getWinnerTeamId());
            }
        }
    }

    @Override
    public void deleteMatch(int matchId) {
        Match m = matches.get(matchId);
        if (m!=null) {
            matches.remove(matchId);
        }
    }

    @Override
    public List<Match> getAllMatches() {
        return matches;
    }

}
