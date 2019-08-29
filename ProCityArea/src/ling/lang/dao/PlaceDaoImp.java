package ling.lang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ling.lang.domain.Place;
import ling.lang.utils.DBUtils;

public class PlaceDaoImp implements PlaceDao{
	private static final String LOAD_PROVINCE="select * from province ";
	private static final String LOAD_CITY="select * from city where father=? ";
	private static final String LOAD_AREA="select * from area where father=?";
	
	@Override
	public List<Place> getProvince() {
		Connection conn=DBUtils.getInstance().getConn(); 
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		List<Place> provinceList=null;
		
		try{ 
		  pstmt=conn.prepareStatement(LOAD_PROVINCE); 
		  rset=pstmt.executeQuery();
		  
		  provinceList=new ArrayList<Place>();
		  boolean startFlag=true;
		  while(rset.next()){
			  if(startFlag){
				  provinceList=new ArrayList<Place>();
				  startFlag=false;
	           }
			  Place place=new Place();
			  place.setCode(rset.getString("provinceID"));
			  place.setName(rset.getString("province"));
			   
			  provinceList.add(place);
			  
		  }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt,rset);
		}
		
		return provinceList;
	}

	@Override
	public List<Place> getCity(String proCode) {
		Connection conn=DBUtils.getInstance().getConn(); 
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		List<Place> cityList=null;
		
		try{ 
		  pstmt=conn.prepareStatement(LOAD_CITY); 
		  pstmt.setString(1, proCode);
		  rset=pstmt.executeQuery();
		  
		  cityList=new ArrayList<Place>();
		  
		  boolean startFlag=true;
		  while(rset.next()){
			  if(startFlag){
				  cityList=new ArrayList<Place>();
				  startFlag=false;
	           }
			  
			  Place place=new Place();
			  place.setCode(rset.getString("cityID"));
			  place.setName(rset.getString("city"));
			   
			  cityList.add(place);
			  
		  }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt,rset);
		}
		
		return cityList;
	}

	@Override
	public List<Place> getArea(String cityCode) {
		Connection conn=DBUtils.getInstance().getConn(); 
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		List<Place> areaList=null;
		
		try{ 
		  pstmt=conn.prepareStatement(LOAD_AREA); 
		  pstmt.setString(1, cityCode);
		  rset=pstmt.executeQuery();
		  
		  areaList=new ArrayList<Place>();
		  
		  boolean startFlag=true;
		  while(rset.next()){
			  if(startFlag){
				  areaList=new ArrayList<Place>();
				  startFlag=false;
	           }	  
			  Place place=new Place();
			  place.setCode(rset.getString("areaID"));
			  place.setName(rset.getString("area"));
			   
			  areaList.add(place);
			  
		  }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt,rset);
		}
		
		return areaList;
	}

	 

 

 

}
