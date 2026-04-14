package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Team;
import com.edutech.progressive.repository.CricketerRepository;
import com.edutech.progressive.repository.TeamRepository;
import com.edutech.progressive.service.TeamService;

@Service
public class TeamServiceImplJpa implements TeamService {

    private final TeamRepository teamRepository;

    @Autowired(required = false)
    private CricketerRepository cricketerRepository;

    @Autowired
    public TeamServiceImplJpa(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> getAllTeams() throws SQLException {
        return teamRepository.findAll();
    }

    @Override
    public int addTeam(Team team) throws SQLException {
        Team savedTeam = teamRepository.save(team);
        return savedTeam.getTeamId();
    }

    @Override
    public List<Team> getAllTeamsSortedByName() throws SQLException {
        return teamRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Team::getTeamName))
                .collect(Collectors.toList());
    }

    @Override
    public Team getTeamById(int teamId) throws SQLException {
        return teamRepository.findByTeamId(teamId);
    }

    @Override
    public void updateTeam(Team team, int teamId) throws SQLException {
        team.setTeamId(teamId);
        teamRepository.save(team);
    }

    @Override
    public void deleteTeam(int teamId) throws SQLException {
        if (cricketerRepository != null) {
            cricketerRepository.deleteByTeamId(teamId);
        }
        teamRepository.deleteById(teamId);
    }
}