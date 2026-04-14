package com.edutech.progressive.entity;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private int matchId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "first_team_id")
    @JsonIgnoreProperties({
            "cricketers",
            "firstTeamMatches",
            "secondTeamMatches",
            "wonMatches"
    })
    private Team firstTeam;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "second_team_id")
    @JsonIgnoreProperties({
            "cricketers",
            "firstTeamMatches",
            "secondTeamMatches",
            "wonMatches"
    })
    private Team secondTeam;

    @Temporal(TemporalType.DATE)
    @Column(name = "match_date")
    private Date matchDate;

    private String venue;
    private String result;
    private String status;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "winner_team_id")
    @JsonIgnoreProperties({
            "cricketers",
            "firstTeamMatches",
            "secondTeamMatches",
            "wonMatches"
    })
    private Team winnerTeam;

    public Match() {
    }

    // Day-7 constructor using Team objects
    public Match(int matchId, Team firstTeam, Team secondTeam, Date matchDate, String venue, String result,
            String status, Team winnerTeam) {
        this.matchId = matchId;
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.matchDate = matchDate;
        this.venue = venue;
        this.result = result;
        this.status = status;
        this.winnerTeam = winnerTeam;
    }

    // Compatibility constructor using team IDs
    public Match(int matchId, int firstTeamId, int secondTeamId, Date matchDate, String venue, String result,
            String status, int winnerTeamId) {
        this.matchId = matchId;
        this.matchDate = matchDate;
        this.venue = venue;
        this.result = result;
        this.status = status;
        setFirstTeamId(firstTeamId);
        setSecondTeamId(secondTeamId);
        setWinnerTeamId(winnerTeamId);
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public Team getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(Team firstTeam) {
        this.firstTeam = firstTeam;
    }

    public Team getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(Team secondTeam) {
        this.secondTeam = secondTeam;
    }

    public Team getWinnerTeam() {
        return winnerTeam;
    }

    public void setWinnerTeam(Team winnerTeam) {
        this.winnerTeam = winnerTeam;
    }

    // Compatibility methods for old int-based code
    public int getFirstTeamId() {
        return (firstTeam != null) ? firstTeam.getTeamId() : 0;
    }

    public void setFirstTeamId(int firstTeamId) {
        if (this.firstTeam == null) {
            this.firstTeam = new Team();
        }
        this.firstTeam.setTeamId(firstTeamId);
    }

    public int getSecondTeamId() {
        return (secondTeam != null) ? secondTeam.getTeamId() : 0;
    }

    public void setSecondTeamId(int secondTeamId) {
        if (this.secondTeam == null) {
            this.secondTeam = new Team();
        }
        this.secondTeam.setTeamId(secondTeamId);
    }

    public int getWinnerTeamId() {
        return (winnerTeam != null) ? winnerTeam.getTeamId() : 0;
    }

    public void setWinnerTeamId(int winnerTeamId) {
        if (this.winnerTeam == null) {
            this.winnerTeam = new Team();
        }
        this.winnerTeam.setTeamId(winnerTeamId);
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}