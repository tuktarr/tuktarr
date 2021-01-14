package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board.dao.BoardDAO;
import com.koreait.board.model.BoardEntity;

@WebServlet("/update")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strI_board = request.getParameter("i_board");
		int i_board = Integer.parseInt(strI_board);
		
		BoardEntity param = new BoardEntity();
		param.setI_board(i_board);
		BoardEntity param2 = BoardDAO.selBoard(param);
		request.setAttribute("update",param2);
		
		String jsp = "/WEB-INF/jsp/update.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardEntity para = new BoardEntity();
		
		int i_board = Integer.parseInt(request.getParameter("i_board"));
		para.setCtnt(request.getParameter("ctnt"));
		para.setTitle(request.getParameter("title"));
		para.setI_board(i_board);
		BoardDAO.updBoard(para);
		
		response.sendRedirect("/detail?i_board=" + i_board);
	}

}
