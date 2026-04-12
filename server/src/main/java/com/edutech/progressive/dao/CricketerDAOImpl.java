package com.edutech.progressive.dao;
import com.edutech.progressive.entity.Cricketer;
import com.edutech.progressive.config.DatabaseConnectionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CricketerDAOImpl implements CricketerDAO {
   @Override
   public int addCricketer(Cricketer c) throws SQLException {
       Connection con = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
       int id = 0;
       try {
           con = DatabaseConnectionManager.getConnection();
           String sql = "INSERT INTO cricketer (team_id, cricketer_name, age, nationality, experience, role, total_runs, total_wickets) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
           ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.setInt(1, c.getTeamId());
           ps.setString(2, c.getCricketerName());
           ps.setInt(3, c.getAge());
           ps.setString(4, c.getNationality());
           ps.setInt(5, c.getExperience());
           ps.setString(6, c.getRole());
           ps.setInt(7, c.getTotalRuns());
           ps.setInt(8, c.getTotalWickets());
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
   public Cricketer getCricketerById(int id) throws SQLException {
       Connection con = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
       Cricketer c = null;
       try {
           con = DatabaseConnectionManager.getConnection();
           String sql = "SELECT * FROM cricketer WHERE cricketer_id=?";
           ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           rs = ps.executeQuery();
           if (rs.next()) {
               c = new Cricketer();
               c.setCricketerId(rs.getInt("cricketer_id"));
               c.setTeamId(rs.getInt("team_id"));
               c.setCricketerName(rs.getString("cricketer_name"));
               c.setAge(rs.getInt("age"));
               c.setNationality(rs.getString("nationality"));
               c.setExperience(rs.getInt("experience"));
               c.setRole(rs.getString("role"));
               c.setTotalRuns(rs.getInt("total_runs"));
               c.setTotalWickets(rs.getInt("total_wickets"));
           }
       } finally {
           if (rs != null) rs.close();
           if (ps != null) ps.close();
           if (con != null) con.close();
       }
       return c;
   }
   @Override
   public void updateCricketer(Cricketer c) throws SQLException {
       Connection con = null;
       PreparedStatement ps = null;
       try {
           con = DatabaseConnectionManager.getConnection();
           String sql = "UPDATE cricketer SET team_id=?, cricketer_name=?, age=?, nationality=?, experience=?, role=?, total_runs=?, total_wickets=? WHERE cricketer_id=?";
           ps = con.prepareStatement(sql);
           ps.setInt(1, c.getTeamId());
           ps.setString(2, c.getCricketerName());
           ps.setInt(3, c.getAge());
           ps.setString(4, c.getNationality());
           ps.setInt(5, c.getExperience());
           ps.setString(6, c.getRole());
           ps.setInt(7, c.getTotalRuns());
           ps.setInt(8, c.getTotalWickets());
           ps.setInt(9, c.getCricketerId());
           ps.executeUpdate();
       } finally {
           if (ps != null) ps.close();
           if (con != null) con.close();
       }
   }
   @Override
   public void deleteCricketer(int id) throws SQLException {
       Connection con = null;
       PreparedStatement ps = null;
       try {
           con = DatabaseConnectionManager.getConnection();
           String sql = "DELETE FROM cricketer WHERE cricketer_id=?";
           ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           ps.executeUpdate();
       } finally {
           if (ps != null) ps.close();
           if (con != null) con.close();
       }
   }
   @Override
   public List<Cricketer> getAllCricketers() throws SQLException {
       Connection con = null;
       Statement st = null;
       ResultSet rs = null;
       List<Cricketer> list = new ArrayList<>();
       try {
           con = DatabaseConnectionManager.getConnection();
           String sql = "SELECT * FROM cricketer";
           st = con.createStatement();
           rs = st.executeQuery(sql);
           while (rs.next()) {
               Cricketer c = new Cricketer();
               c.setCricketerId(rs.getInt("cricketer_id"));
               c.setTeamId(rs.getInt("team_id"));
               c.setCricketerName(rs.getString("cricketer_name"));
               c.setAge(rs.getInt("age"));
               c.setNationality(rs.getString("nationality"));
               c.setExperience(rs.getInt("experience"));
               c.setRole(rs.getString("role"));
               c.setTotalRuns(rs.getInt("total_runs"));
               c.setTotalWickets(rs.getInt("total_wickets"));
               list.add(c);
           }
       } finally {
           if (rs != null) rs.close();
           if (st != null) st.close();
           if (con != null) con.close();
       }
       return list;
   }
}