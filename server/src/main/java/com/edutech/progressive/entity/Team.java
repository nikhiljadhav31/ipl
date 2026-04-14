package com.edutech.progressive.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "team")
public class Team implements Comparable<Team> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private int teamId;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "location")
    private String location;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "establishment_year")
    private int establishmentYear;

    @JsonIgnore
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cricketer> cricketers = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "firstTeam")
    private List<Match> firstTeamMatches = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "secondTeam")
    private List<Match> secondTeamMatches = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "winnerTeam")
    private List<Match> wonMatches = new ArrayList<>();

    public Team() {
    }

    public Team(int teamId, String teamName, String location, String ownerName, int establishmentYear) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.location = location;
        this.ownerName = ownerName;
        this.establishmentYear = establishmentYear;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getEstablishmentYear() {
        return establishmentYear;
    }

    public void setEstablishmentYear(int establishmentYear) {
        this.establishmentYear = establishmentYear;
    }

    public List<Cricketer> getCricketers() {
        return cricketers;
    }

    public void setCricketers(List<Cricketer> cricketers) {
        this.cricketers = cricketers;
    }

    public List<Match> getFirstTeamMatches() {
        return firstTeamMatches;
    }

    public void setFirstTeamMatches(List<Match> firstTeamMatches) {
        this.firstTeamMatches = firstTeamMatches;
    }

    public List<Match> getSecondTeamMatches() {
        return secondTeamMatches;
    }

    public void setSecondTeamMatches(List<Match> secondTeamMatches) {
        this.secondTeamMatches = secondTeamMatches;
    }

    public List<Match> getWonMatches() {
        return wonMatches;
    }

    public void setWonMatches(List<Match> wonMatches) {
        this.wonMatches = wonMatches;
    }

    @Override
    public int compareTo(Team o) {
        return this.getTeamName().compareTo(o.getTeamName());
    }
}