package com.edutech.progressive.service.impl;
import java.util.*;
import com.edutech.progressive.dao.MatchDAO;
import com.edutech.progressive.entity.Match;
import com.edutech.progressive.service.MatchService;
public class MatchServiceImplJdbc implements MatchService {
   private MatchDAO dao;
   public MatchServiceImplJdbc(MatchDAO dao) {
       this.dao = dao;
   }
   @Override
   public List<Match> getAllMatches() {
       try {
           return dao.getAllMatches();
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }
   @Override
   public Match getMatchById(int id) {
       try {
           return dao.getMatchById(id);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }
   @Override
   public Integer addMatch(Match m) {
       try {
           return dao.addMatch(m);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }
   @Override
   public void updateMatch(Match m) {
       try {
           dao.updateMatch(m);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }
   @Override
   public void deleteMatch(int id) {
       try {
           dao.deleteMatch(id);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }
}