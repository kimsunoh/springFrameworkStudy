package com.kitri.haksa.service.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.kitri.haksa.data.db.HaksaDto;

public class HaksaDao {
   
   private DataSource dataSource;
   
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
   }

   public void register(HaksaDto haksaDto) {
      Connection conn = null;
      Statement stmt = null;
      try {
         conn = dataSource.getConnection();
         String sql = "";
         sql += "insert into school (name, age, key, value) \n";
         sql += "values ('" + haksaDto.getName() + "', " + haksaDto.getAge() + ", " + haksaDto.getKey() + ", '" + haksaDto.getValue() + "')";
         stmt = conn.createStatement();
         stmt.executeUpdate(sql);
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DBClose.close(conn, stmt);
      }
   }
   
   public HaksaDto findName(String name) {
      HaksaDto haksaDto = null;
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;
      try {
         conn = dataSource.getConnection();
         String sql = "";
         sql += "select s.name, s.age, s.value, j.key_name  \n";
         sql += "from school s, job j \n";
         sql += "where s.key = j.key \n";
         sql += "and s.name = '" + name + "'";
         stmt = conn.createStatement();
         rs = stmt.executeQuery(sql);
         if(rs.next()) {
            haksaDto = new HaksaDto();
            haksaDto.setName(rs.getString("name"));
            haksaDto.setAge(rs.getInt("age"));
            haksaDto.setKeyName(rs.getString("key_name"));
            haksaDto.setValue(rs.getString("value"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DBClose.close(conn, stmt, rs);
      }
      return haksaDto;
   }
   
   public int delete(String name) {
      int cnt = 0;
      Connection conn = null;
      Statement stmt = null;
      try {
         conn = dataSource.getConnection();
         String sql = "";
         sql += "delete school \n";
         sql += "where name = '" + name + "'";
         stmt = conn.createStatement();
         cnt = stmt.executeUpdate(sql);
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DBClose.close(conn, stmt);
      }
      return cnt;
   }
   
   public List<HaksaDto> selectAllList() {
      List<HaksaDto> list = new ArrayList<>();
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;
      try {
         conn = dataSource.getConnection();
         String sql = "";
         sql += "select s.name, s.age, s.value, j.key_name  \n";
         sql += "from school s, job j \n";
         sql += "where s.key = j.key \n";
         stmt = conn.createStatement();
         rs = stmt.executeQuery(sql);
         while(rs.next()) {
            HaksaDto haksaDto = new HaksaDto();
            haksaDto.setName(rs.getString("name"));
            haksaDto.setAge(rs.getInt("age"));
            haksaDto.setKeyName(rs.getString("key_name"));
            haksaDto.setValue(rs.getString("value"));
            
            list.add(haksaDto);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DBClose.close(conn, stmt, rs);
      }
      return list;
   }
}











