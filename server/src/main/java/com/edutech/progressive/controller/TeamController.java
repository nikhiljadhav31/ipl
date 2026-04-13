package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Team;
import com.edutech.progressive.service.impl.TeamServiceImplArraylist;
import com.edutech.progressive.service.impl.TeamServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamServiceImplArraylist teamServiceImplArraylist;

    @Autowired
    private TeamServiceImplJpa teamServiceImplJpa;

    public ResponseEntity<List<Team>> getAllTeams() {
        return null;
    }

    @GetMapping("")
    public ResponseEntity<Team> getTeamById(int teamId) {
        return null;
    }

    public ResponseEntity<Integer> addTeam(Team team) {
        return null;
    }

    public ResponseEntity<Void> updateTeam(int teamId, Team team) {
        return null;
    }

    public ResponseEntity<Void> deleteTeam(int teamId) {
        return null;
    }

    @GetMapping("fromArrayList")
    public ResponseEntity<List<Team>> getAllTeamsFromArrayList() {
        List<Team> teams = teamServiceImplArraylist.getAllTeams();
        return new ResponseEntity<List<Team>>(teams, HttpStatus.OK);

    }

    @PostMapping("toArrayList")
    public ResponseEntity<Integer> addTeamToArrayList(Team team) {
        Integer i = teamServiceImplArraylist.addTeam(team);
        return new ResponseEntity<>(i, HttpStatus.CREATED);
    }

    @GetMapping("fromArrayList/sorted")
    public ResponseEntity<List<Team>> getAllTeamsSortedByNameFromArrayList() {
        List<Team> ls = teamServiceImplArraylist.getAllTeamsSortedByName();
        return new ResponseEntity<List<Team>>(ls, HttpStatus.OK);
    }
}