package com.koreait.board.dao;

import java.sql.*; 
import java.util.ArrayList;
import java.util.List;

import com.koreait.board.model.BoardEntity;
public class BoardDAO {
	public static void insBoard(BoardEntity vo) {
		
		String sql = "INSERT INTO t_board (title,ctnt) VALUES (?, ?)";
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1,vo.getTitle());
			ps.setString(2,vo.getCtnt());
			ps.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtils.close(con,ps);
		}
		
	}
	
	public static List<BoardEntity> selBoardList() {
		String sql = "SELECT i_board, title, r_dt FROM t_board";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<BoardEntity> list = new ArrayList<BoardEntity>();
			while(rs.next()) {
				int i_board = rs.getInt("i_board");
				String title = rs.getString("title");
				String r_dt = rs.getString("r_dt");
				
				BoardEntity vo = new BoardEntity();
				vo.setI_board(i_board);
				vo.setTitle(title);
				vo.setR_dt(r_dt);
				list.add(vo);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtils.close(con,ps,rs);
		}
		return null;
	}
	
	public static BoardEntity selBoard(BoardEntity param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT title, ctnt, r_dt FROM t_board WHERE i_board = ?";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setInt(1, param.getI_board());
			rs = ps.executeQuery();
			if(rs.next()) {
				BoardEntity vo = new BoardEntity();
				String ctnt = rs.getString("ctnt");
				String title = rs.getString("title");
				String r_dt = rs.getString("r_dt");
				vo.setCtnt(ctnt);
				vo.setTitle(title);
				vo.setR_dt(r_dt);
				vo.setI_board(param.getI_board());
				return vo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return null;
	}
	public static int delBoard(BoardEntity vo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM t_board WHERE i_board = ?";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1,vo.getI_board());
			ps.executeUpdate();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtils.close(con,ps);
		}
		return 0;
	}
	public static void updBoard(BoardEntity vo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "UPDATE t_board SET title =?, ctnt =? WHERE i_board =?";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1,vo.getTitle());
			ps.setString(2,vo.getCtnt());
			ps.setInt(3,vo.getI_board());
			ps.executeUpdate();			 
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DbUtils.close(con,ps);
			}		
	}
}
