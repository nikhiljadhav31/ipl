package com.edutech.progressive.dao;
import com.edutech.progressive.entity.Match;
import com.edutech.progressive.config.DatabaseConnectionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class MatchDAOImpl implements MatchDAO {
   @Override
   public int addMatch(Match m) throws SQLException {
       Connection con = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
       int id = 0;
       try {
           con = DatabaseConnectionManager.getConnection();
           String sql = "INSERT INTO matches (first_team_id, second_team_id, match_date, venue, result, status, winner_team_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
           ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.setInt(1, m.getFirstTeamId());
           ps.setInt(2, m.getSecondTeamId());
           ps.setDate(3, new java.sql.Date(m.getMatchDate().getTime()));
           ps.setString(4, m.getVenue());
           ps.setString(5, m.getResult());
           ps.setString(6, m.getStatus());
           ps.setInt(7, m.getWinnerTeamId());
           ps.executeUpdate();
           rs = ps.getGeneratedKeys();
           if (rs.next()) {
               id = rs.getInt(1);
           }
       } finally {
           if (rs != null) rs.close();
           if (ps != null) ps.close();
           if (con != null) con.close();
       }
       return id;
   }
   @Override
   public Match getMatchById(int id) throws SQLException {
       Connection con = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
       Match m = null;
       try {
           con = DatabaseConnectionManager.getConnection();
           String sql = "SELECT * FROM matches WHERE match_id=?";
           ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           rs = ps.executeQuery();
           if (rs.next()) {
               m = new Match();
               m.setMatchId(rs.getInt("match_id"));
               m.setFirstTeamId(rs.getInt("first_team_id"));
               m.setSecondTeamId(rs.getInt("second_team_id"));
               m.setMatchDate(rs.getDate("match_date"));
               m.setVenue(rs.getString("venue"));
               m.setResult(rs.getString("result"));
               m.setStatus(rs.getString("status"));
               m.setWinnerTeamId(rs.getInt("winner_team_id"));
           }
       } finally {
           if (rs != null) rs.close();
           if (ps != null) ps.close();
           if (con != null) con.close();
       }
       return m;
   }
   @Override

public void updateMatch(Match m) throws SQLException {

    Connection con = null;

    PreparedStatement ps = null;
    try {
        con = DatabaseConnectionManager.getConnection();
        String sql = "UPDATE matches SET first_team_id=?, second_team_id=?, match_date=?, venue=?, result=?, status=?, winner_team_id=? WHERE match_id=?";
        ps = con.prepareStatement(sql);
        ps.setInt(1, m.getFirstTeamId());
        ps.setInt(2, m.getSecondTeamId());
        ps.setDate(3, new java.sql.Date(m.getMatchDate().getTime()));
        ps.setString(4, m.getVenue());
        ps.setString(5, m.getResult());
        ps.setString(6, m.getStatus());
        ps.setInt(7, m.getWinnerTeamId());
        ps.setInt(8, m.getMatchId());
        ps.executeUpdate();  
    } finally {
        if (ps != null) ps.close();
        if (con != null) con.close();
    }

}
 
   @Override
   public void deleteMatch(int id) throws SQLException {
       Connection con = null;
       PreparedStatement ps = null;
       try {
           con = DatabaseConnectionManager.getConnection();
           String sql = "DELETE FROM matches WHERE match_id=?";
           ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           ps.executeUpdate();
       } finally {
           if (ps != null) ps.close();
           if (con != null) con.close();
       }
   }
   @Override
   public List<Match> getAllMatches() throws SQLException {
       Connection con = null;
       Statement st = null;
       ResultSet rs = null;
       List<Match> list = new ArrayList<>();
       try {
           con = DatabaseConnectionManager.getConnection();
           String sql = "SELECT * FROM matches";
           st = con.createStatement();
           rs = st.executeQuery(sql);
           while (rs.next()) {
               Match m = new Match();
               m.setMatchId(rs.getInt("match_id"));
               m.setFirstTeamId(rs.getInt("first_team_id"));
               m.setSecondTeamId(rs.getInt("second_team_id"));
               m.setMatchDate(rs.getDate("match_date"));
               m.setVenue(rs.getString("venue"));
               m.setResult(rs.getString("result"));
               m.setStatus(rs.getString("status"));
               m.setWinnerTeamId(rs.getInt("winner_team_id"));
               list.add(m);
           }
       } finally {
           if (rs != null) rs.close();
           if (st != null) st.close();
           if (con != null) con.close();
       }
       return list;
   }
}