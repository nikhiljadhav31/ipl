package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.entity.Team;
import com.edutech.progressive.service.TeamService;

public class TeamServiceImplArraylist implements TeamService  {

    List<Team> teams = new ArrayList<>();

    @Override
    public List<Team> getAllTeams() {
        return teams;
    }

    @Override
    public int addTeam(Team team) {
        teams.add(team);
        return teams.size();
    }

    @Override
    public List<Team> getAllTeamsSortedByName() {
        ArrayList<Team> sortedTeams = new ArrayList<>(teams);
        Collections.sort(sortedTeams,Comparator.comparing(Team::getTeamName));
        return sortedTeams;
    }

    @Override
    public void emptyArrayList(){
        teams.clear();
        TeamService.super.emptyArrayList();
    }

}