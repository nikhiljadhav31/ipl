package com.edutech.progressive.dao;
import com.edutech.progressive.entity.Team;
import com.edutech.progressive.config.DatabaseConnectionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class TeamDAOImpl implements TeamDAO {
   
   @Override
public int addTeam(Team t) throws SQLException {
   Connection con = null;
   PreparedStatement ps = null;
   int rows = 0;
   try {
       con = DatabaseConnectionManager.getConnection();
       String sql = "INSERT INTO team (team_name, location, owner_name, establishment_year) VALUES (?, ?, ?, ?)";
       ps = con.prepareStatement(sql);
       ps.setString(1, t.getTeamName());
       ps.setString(2, t.getLocation());
       ps.setString(3, t.getOwnerName());
       ps.setInt(4, t.getEstablishmentYear());
       rows = ps.executeUpdate();   
   } finally {
       if (ps != null) ps.close();
       if (con != null) con.close();
   }
   return rows;  
}
   @Override
   public Team getTeamById(int id) throws SQLException {
       Connection con = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
       Team t = null;
       try {
           con = DatabaseConnectionManager.getConnection();
           String sql = "SELECT * FROM team WHERE team_id=?";
           ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           rs = ps.executeQuery();
           if (rs.next()) {
               t = new Team();
               t.setTeamId(rs.getInt("team_id"));
               t.setTeamName(rs.getString("team_name"));
               t.setLocation(rs.getString("location"));
               t.setOwnerName(rs.getString("owner_name"));
               t.setEstablishmentYear(rs.getInt("establishment_year"));
           }
       } finally {
           if (rs != null) rs.close();
           if (ps != null) ps.close();
           if (con != null) con.close();
       }
       return t;
   }
   @Override
   public void updateTeam(Team t) throws SQLException {
       Connection con = null;
       PreparedStatement ps = null;
       try {
           con = DatabaseConnectionManager.getConnection();
           String sql = "UPDATE team SET team_name=?, location=?, owner_name=?, establishment_year=? WHERE team_id=?";
           ps = con.prepareStatement(sql);
           ps.setString(1, t.getTeamName());
           ps.setString(2, t.getLocation());
           ps.setString(3, t.getOwnerName());
           ps.setInt(4, t.getEstablishmentYear());
           ps.setInt(5, t.getTeamId());
           ps.executeUpdate();
       } finally {
           if (ps != null) ps.close();
           if (con != null) con.close();
       }
   }
   @Override
   public void deleteTeam(int id) throws SQLException {
       Connection con = null;
       PreparedStatement ps = null;
       try {
           con = DatabaseConnectionManager.getConnection();
           String sql = "DELETE FROM team WHERE team_id=?";
           ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           ps.executeUpdate();
       } finally {
           if (ps != null) ps.close();
           if (con != null) con.close();
       }
   }
   @Override
   public List<Team> getAllTeams() throws SQLException {
       Connection con = null;
       Statement st = null;
       ResultSet rs = null;
       List<Team> list = new ArrayList<>();
       try {
           con = DatabaseConnectionManager.getConnection();
           String sql = "SELECT * FROM team";
           st = con.createStatement();
           rs = st.executeQuery(sql);
           while (rs.next()) {
               Team t = new Team();
               t.setTeamId(rs.getInt("team_id"));
               t.setTeamName(rs.getString("team_name"));
               t.setLocation(rs.getString("location"));
               t.setOwnerName(rs.getString("owner_name"));
               t.setEstablishmentYear(rs.getInt("establishment_year"));
               list.add(t);
           }
       } finally {
           if (rs != null) rs.close();
           if (st != null) st.close();
           if (con != null) con.close();
       }
       return list;
   }
}