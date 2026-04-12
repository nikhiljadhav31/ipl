package com.edutech.progressive.service.impl;
import java.util.*;
import com.edutech.progressive.dao.TeamDAO;
import com.edutech.progressive.entity.Team;
import com.edutech.progressive.service.TeamService;
public class TeamServiceImplJdbc implements TeamService {
   private TeamDAO teamDAO;
   public TeamServiceImplJdbc(TeamDAO teamDAO) {
       this.teamDAO = teamDAO;
   }
   @Override
   public List<Team> getAllTeams() {
       try {
           return teamDAO.getAllTeams();
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }
   @Override
   public int addTeam(Team team) {
       try {
           return teamDAO.addTeam(team);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }
   @Override
   public List<Team> getAllTeamsSortedByName() {
       try {
           List<Team> list = teamDAO.getAllTeams();
           Collections.sort(list, Comparator.comparing(Team::getTeamName));
           return list;
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }
   @Override
   public Team getTeamById(int teamId) {
       try {
           return teamDAO.getTeamById(teamId);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }
   @Override
   public void updateTeam(Team team) {
       try {
           teamDAO.updateTeam(team);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }
   @Override
   public void deleteTeam(int teamId) {
       try {
           teamDAO.deleteTeam(teamId);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }
}