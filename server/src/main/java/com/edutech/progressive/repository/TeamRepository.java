package com.edutech.progressive.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.progressive.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Integer>{

    Optional<Team> findByTeamName(String teamName);
}