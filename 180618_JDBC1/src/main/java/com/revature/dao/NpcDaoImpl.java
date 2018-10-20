package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.revature.beans.Npc;
import com.revature.util.Connections;

public class NpcDaoImpl implements NpcDao{

	public void insertNpc(Npc npc) {
		// TODO Auto-generated method stub
		
	}

	public Npc selectNpcById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM npc WHERE npc_id = ?";

		try (Connection conn = Connections.getConnection()){
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new Npc(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getInt(4),
						rs.getInt(5));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return null;
	}

	/*
	 * Try-With-Resources will close any streams you create within the
	 * parenthesis' of the try block once the try-catch-finally has
	 * finished.
	 */
	public List<Npc> selectAllNpc() {
		
		Statement stmt = null; // Simple SQL query to be executed
		Statement stmtClass = null;
		ResultSet rs = null; //Object that holds query results
		ResultSet rsClass = null;
		List<Npc> npcs = new ArrayList<>();
		
		try(Connection conn = Connections.getConnection()){
			String sql = "SELECT * FROM npc";
			String sqlClass = "SELECT * FROM job_class";
			
			stmt = conn.createStatement();
			stmtClass = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rsClass = stmtClass.executeQuery(sqlClass);
			
			Map<Integer,String> classes = new HashMap<>();
			while(rsClass.next()){
				classes.put(rsClass.getInt(1), rsClass.getString(2));
			}			
			

			while(rs.next()){
				Npc npc = new Npc(
						rs.getInt(1),
						rs.getString("npc_name"),
						rs.getInt(3),
						rs.getInt(4),
						rs.getInt(5)
						);
				for(Integer i: classes.keySet()){
					if(i.equals(npc.getJobClass())){
						npc.setJobClassString(classes.get(i));
						break;
					}
				}
				npcs.add(npc);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(stmt);
			close(rs);
			close(stmtClass);
			close(rsClass);
		}
		
		return npcs;
	}

	public Integer deleteNpcById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean updateNpc(Npc npc) {
		PreparedStatement stmt = null;
		

		try (Connection conn = Connections.getConnection()){
			String sql = "UPDATE npc set npc_name = ?,npc_lvl = ?,"
					+ "currency = ?, job_id = ? WHERE npc_id = ?";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1,npc.getName());
			stmt.setInt(2, npc.getLvl());
			stmt.setInt(3, npc.getCurrency());
			stmt.setInt(4, npc.getJobClass());
			stmt.setInt(5, npc.getId());
			
			stmt.executeUpdate();	//rows effected
			return true;

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(stmt);
		}
		return false;
	}

	@Override
	public Boolean insertNpcViaSp(Npc npc) {
		CallableStatement stmt = null;

		try (Connection conn = Connections.getConnection()){
			stmt = conn.prepareCall("{call insertIntoNpc(?,?,?,?)}");
			
			stmt.setString(1,npc.getName());
			stmt.setInt(2, npc.getLvl());
			stmt.setInt(3, npc.getCurrency());
			stmt.setInt(4, npc.getJobClass());
			
			stmt.execute(); //rows effected
			return true;

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(stmt);
		}
		return false;
	}
	

}