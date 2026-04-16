package com.edutech.progressive.service.impl;

import com.edutech.progressive.entity.Cricketer;
import com.edutech.progressive.entity.Team;
import com.edutech.progressive.exception.TeamAlreadyExistsException;
import com.edutech.progressive.exception.TeamDoesNotExistException;
import com.edutech.progressive.repository.CricketerRepository;
import com.edutech.progressive.repository.MatchRepository;
import com.edutech.progressive.repository.TeamRepository;
import com.edutech.progressive.service.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Service
@Primary
public class TeamServiceImplJpa implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private CricketerRepository cricketerRepository;

    public TeamServiceImplJpa() {
    }

    public TeamServiceImplJpa(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams() throws SQLException {
        return teamRepository.findAll();
    }

    public int addTeam(Team team) throws SQLException {
        if(teamRepository.existsById(team.getTeamId())){
            throw new TeamAlreadyExistsException("Team already exists by id:"+team.getTeamId());
        }
        return teamRepository.save(team).getTeamId();
    }

    public List<Team> getAllTeamsSortedByName() throws SQLException {
        List<Team> teams = teamRepository.findAll();
        Collections.sort(teams);
        return teams;
    }

    public Team getTeamById(int teamId) throws SQLException {
        if(!teamRepository.existsById(teamId)) throw new TeamDoesNotExistException("Team with id:"+teamId+" not found.");
        return teamRepository.findByTeamId(teamId);
    }

    public void updateTeam(Team team, int teamId) throws SQLException {
        Team existingTeam = teamRepository.findById(teamId).orElse(null);
        if (existingTeam != null) {
            existingTeam.setTeamId(team.getTeamId());
            existingTeam.setTeamName(team.getTeamName());
            existingTeam.setLocation(team.getLocation());
            existingTeam.setEstablishmentYear(team.getEstablishmentYear());
            existingTeam.setOwnerName(team.getOwnerName());
            teamRepository.save(existingTeam);
        }
    }

    public void deleteTeam(int teamId) throws SQLException {
        matchRepository.deleteByTeamId(teamId);

        List<Cricketer> cricketers = cricketerRepository.findByTeam_TeamId(teamId);
        cricketerRepository.deleteAll(cricketers);

        teamRepository.deleteById(teamId);
    }
}