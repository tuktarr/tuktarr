package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board.dao.BoardDAO;
import com.koreait.board.model.BoardEntity;

@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iBoard = request.getParameter("i_board");
		System.out.println("i_board : " + iBoard);
		int i_board = Integer.parseInt(iBoard); 
		
		BoardEntity vo = new BoardEntity();
		vo.setI_board(i_board);
		
		BoardEntity vo2 = BoardDAO.selBoard(vo);
		
		request.setAttribute("detail",vo2);
		
		String jsp = "/WEB-INF/jsp/detail.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}
}

