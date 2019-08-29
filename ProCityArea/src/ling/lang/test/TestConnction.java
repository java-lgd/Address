package ling.lang.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnction {
	
	 
    public static String dburl = "jdbc:mysql://localhost/address";   
    public static String user = "root";   
    public static String password = "123456";   
  
    /**  
     * JDBC��ʽ����  
     *   
     * @throws Exception  
     */  
    public static void test1() throws Exception {   
        String testsql = "select * from province";   
  
        Class.forName("com.mysql.jdbc.Driver"); 
        // 2��������ݿ�����   
        Connection conn = DriverManager.getConnection(dburl, user, password);   
        // 3������ִ��SQL�Ķ���   
        Statement stmt = conn.createStatement();   
        // 4��ִ��SQL������ȡ���ؽ��   
        ResultSet rs = stmt.executeQuery(testsql);   
        // 5�����?�ؽ��˴���ӡ��ѯ���   
        while (rs.next()) {   
            System.out.print(rs.getInt(1)+" "+rs.getString("province") + "\t");   
            // System.out.print(rs.getString("name") + "\t");   
            System.out.println();   
        }   
        // 6���ر���ݿ�����   
        conn.close();   
    }   
   
  
    public static void main(String[] args) throws Exception {   
         test1();   
     
    	    	
    }   
}

