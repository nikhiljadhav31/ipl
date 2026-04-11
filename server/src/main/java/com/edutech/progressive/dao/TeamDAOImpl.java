package com.edutech.progressive.dao;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.entity.Team;

public class TeamDAOImpl implements TeamDAO{

    List<Team> teams = new ArrayList<>();

    @Override
    public int addTeam(Team team) {
        teams.add(team);
        return -1;

    }

    @Override
    public Team getTeamById(int teamId) {
       Team t = teams.get(teamId);
       if (t==null) {
        return null;
       }
       return t;
       
    }

    @Override
    public void updateTeam(Team team) {
        int teamid = team.getTeamId();
        for (Team team2 : teams) {
            if (team2.getTeamId()==teamid) {
                team2.setEstablishmentYear(team.getEstablishmentYear());
                team2.setLocation(team.getLocation());
                team2.setOwnerName(team.getOwnerName());
                team2.setTeamId(team.getTeamId());
                team2.setTeamName(team.getTeamName());
            }
        }
    }

    @Override
    public void deleteTeam(int teamId) {
        Team t = teams.get(teamId);
        if (t!=null) {
            teams.remove(teamId);
        }
    }

    @Override
    public List<Team> getAllTeams() {
       return teams;
    } 



}
