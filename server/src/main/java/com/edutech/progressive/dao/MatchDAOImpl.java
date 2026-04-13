package com.edutech.progressive.dao;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Match;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MatchDAOImpl implements MatchDAO {

    @Override
    public int addMatch(Match match) throws SQLException {
        String sql = "INSERT INTO matches (first_team_id, second_team_id, match_date, venue, result, status, winner_team_id) "
                +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, match.getFirstTeamId());
            statement.setInt(2, match.getSecondTeamId());
            statement.setDate(3, new java.sql.Date(match.getMatchDate().getTime()));
            statement.setString(4, match.getVenue());
            statement.setString(5, match.getResult());
            statement.setString(6, match.getStatus());
            statement.setInt(7, match.getWinnerTeamId());

            statement.executeUpdate();

            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    int generatedID = resultSet.getInt(1);
                    match.setMatchId(generatedID);
                    return generatedID;
                }
            }
        }

        return -1;
    }

    @Override
    public Match getMatchById(int matchId) throws SQLException {
        String sql = "SELECT * FROM matches WHERE match_id = ?";

        try (Connection connection = DatabaseConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, matchId);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return new Match(
                            matchId,
                            rs.getInt("first_team_id"),
                            rs.getInt("second_team_id"),
                            rs.getDate("match_date"),
                            rs.getString("venue"),
                            rs.getString("result"),
                            rs.getString("status"),
                            rs.getInt("winner_team_id"));
                }
            }
        }

        return null;
    }

    @Override
    public void updateMatch(Match match) throws SQLException {
        String sql = "UPDATE matches SET first_team_id = ?, second_team_id = ?, match_date = ?, venue = ?, result = ?, status = ?, winner_team_id = ? "
                +
                "WHERE match_id = ?";

        try (Connection connection = DatabaseConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, match.getFirstTeamId());
            statement.setInt(2, match.getSecondTeamId());
            statement.setDate(3, new java.sql.Date(match.getMatchDate().getTime()));
            statement.setString(4, match.getVenue());
            statement.setString(5, match.getResult());
            statement.setString(6, match.getStatus());
            statement.setInt(7, match.getWinnerTeamId());
            statement.setInt(8, match.getMatchId());

            statement.executeUpdate();
        }
    }

    @Override
    public void deleteMatch(int matchId) throws SQLException {
        String sql = "DELETE FROM matches WHERE match_id = ?";

        try (Connection connection = DatabaseConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, matchId);
            statement.executeUpdate();
        }
    }

    @Override
    public List<Match> getAllMatches() throws SQLException {
        String sql = "SELECT * FROM matches";
        List<Match> matches = new ArrayList<>();

        try (Connection connection = DatabaseConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                matches.add(new Match(
                        rs.getInt("match_id"),
                        rs.getInt("first_team_id"),
                        rs.getInt("second_team_id"),
                        rs.getDate("match_date"),
                        rs.getString("venue"),
                        rs.getString("result"),
                        rs.getString("status"),
                        rs.getInt("winner_team_id")));
            }
        }

        return matches;
    }
}