package com.edutech.progressive.service.impl;

import com.edutech.progressive.entity.Team;
import com.edutech.progressive.exception.TeamAlreadyExistsException;
import com.edutech.progressive.exception.TeamDoesNotExistException;
import com.edutech.progressive.repository.CricketerRepository;
import com.edutech.progressive.repository.MatchRepository;
import com.edutech.progressive.repository.TeamRepository;
import com.edutech.progressive.repository.TicketBookingRepository;
import com.edutech.progressive.repository.VoteRepository;
import com.edutech.progressive.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImplJpa{

    private final TeamRepository teamRepository;
    private final CricketerRepository cricketerRepository;
    private final MatchRepository matchRepository;
    private final VoteRepository voteRepository;
    private final TicketBookingRepository ticketBookingRepository;

    @Autowired
    public TeamServiceImplJpa(
            TeamRepository teamRepository,
            CricketerRepository cricketerRepository,
            MatchRepository matchRepository,
            VoteRepository voteRepository,
            TicketBookingRepository ticketBookingRepository
    ) {
        this.teamRepository = teamRepository;
        this.cricketerRepository = cricketerRepository;
        this.matchRepository = matchRepository;
        this.voteRepository = voteRepository;
        this.ticketBookingRepository = ticketBookingRepository;
    }

    // @Override
    // public List<Team> getAllTeams() {
    //     return teamRepository.findAll();
    // }

    // @Override
    // public int addTeam(Team team) {

    //     Optional<Team> existingTeam =
    //             teamRepository.findByTeamName(team.getTeamName());

    //     if (existingTeam.isPresent()) {
    //         throw new TeamAlreadyExistsException(
    //                 "Team with the same name already exists");
    //     }

    //     return teamRepository.save(team).getTeamId();
    // }

    // @Override
    // public List<Team> getAllTeamsSortedByName() {
    //     return teamRepository.findAllByOrderByTeamNameAsc();
    // }

    // @Override
    // public Team getTeamById(int teamId) {
    //     return teamRepository.findById(teamId)
    //             .orElseThrow(() ->
    //                     new TeamDoesNotExistException("Team does not exist"));
    // }

    // @Override
    // public void updateTeam(Team team) {

    //     Team existingTeam = teamRepository.findById(team.getTeamId())
    //             .orElseThrow(() ->
    //                     new TeamDoesNotExistException("Team not found"));

    //     Optional<Team> teamWithSameName =
    //             teamRepository.findByTeamName(team.getTeamName());

    //     if (teamWithSameName.isPresent()
    //             && teamWithSameName.get().getTeamId() != team.getTeamId()) {
    //         throw new TeamAlreadyExistsException(
    //                 "Team with the same name already exists");
    //     }

    //     teamRepository.save(team);
    // }

    // @Override
    // public void deleteTeam(int teamId) {

    //     if (!teamRepository.existsById(teamId)) {
    //         throw new TeamDoesNotExistException("Team does not exist");
    //     }

    //     voteRepository.deleteByTeamId(teamId);
    //     ticketBookingRepository.deleteByTeamId(teamId);
    //     matchRepository.deleteByTeamId(teamId);
    //     cricketerRepository.deleteByTeamId(teamId);

    //     teamRepository.deleteById(teamId);
    // }
}