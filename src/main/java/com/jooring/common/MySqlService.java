package com.jooring.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlService {
      
   private static MySqlService mysqlService = null;
   
   private final String url = "jdbc:mysql://localhost:3306/jooring";
   
   private final  String userId = "root";
   private final String password = "root";
   Statement statement;
   Connection connection;
   
   //객체 전달 기능
   //객체 생성 없이 호출 가능한 메소드 
    public static MySqlService getInstance() {
       if(mysqlService == null) {
       mysqlService = new MySqlService();
    }
   return mysqlService;
    }
   
   //접속기능
    
   public void connect() {
   
      
      try {
         DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      
         this.connection = DriverManager.getConnection(url, userId, password);
         
         this.statement = connection.createStatement();
   } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
   }
   
   }
   
   public int update(String query)  {
      try {
         
      int count = this.statement.executeUpdate(query);
      return count;
      } catch(SQLException e) {
         e.printStackTrace();
         return 0;
      }
      
      
      
   }
   
   // select  쿼리 수행 기능
   public ResultSet select(String query)  {
      ResultSet resultSet;
      try {
         resultSet = this.statement.executeQuery(query);
         return resultSet;
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         return null;
      }
      
   }
   
}