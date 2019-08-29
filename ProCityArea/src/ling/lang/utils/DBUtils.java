package ling.lang.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 

public class DBUtils {
	
	private static final String CONN_STR="jdbc:mysql://localhost/address";
	private static final String USERNAME="root";
	private static final String PWD="123456";
	
	private static  DBUtils me=new DBUtils();
	
    private DBUtils(){}
    
    public static DBUtils getInstance(){
    	return me;
    }
    /**
     * ��ȡ��ݿ�����
     * @return 
     */
	
	public Connection getConn(){
		 
		Connection conn=null;
	      
		try{
	      //��������һ��Ҳ��дΪ��Class.forName("com.mysql.jdbc.Driver");
	    
			Class.forName("com.mysql.jdbc.Driver");
		
	      //������MySQL������
	       conn = DriverManager.getConnection(CONN_STR,USERNAME,PWD);
	//       System.out.println("OK??");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     return conn;
	     
	   
	}
	
	/**
	 * �ͷ���ݿ���Դ
	 * @param conn
	 * @param pstmt
	 * @param rset
	 */
	public void ReleaseRes(Connection conn,PreparedStatement pstmt,ResultSet rset)
	{
		try{
		  if(rset!=null) rset.close();
		  if(pstmt!=null) pstmt.close();
		  if(conn!=null)  conn.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
 	public void load(){
		
 		String sql="select * from student";
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement stmt=null;
		
 		
		  
		try {
			stmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//��������������ִ��sql����
		            
		//  ִ��SQL���
	    
	    ResultSet rs=null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	       //������
	      try {
			while (rs.next())
			  {
			    String name = rs.getString("name");
			    String ID = rs.getString("Id");
			    System.out.println(name+"\t"+ID);
			  }
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 
			DBUtils.getInstance().ReleaseRes(conn, stmt, null);
		}
		
		       
 	}

}