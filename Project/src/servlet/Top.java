package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.FoodDataBeans;
import beans.TriviaDataBeans;
import dao.FoodDAO;
import dao.TriviaDAO;

/**
 * Servlet implementation class Top
 */
@WebServlet("/Top")
public class Top extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Top() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Random rand = new Random();
		int triviaNum = rand.nextInt(10) + 1;
		int foodNum = rand.nextInt(1) + 1;

		FoodDAO foodDao = new FoodDAO();
		List<FoodDataBeans> food = foodDao.bestMuch(foodNum);

		TriviaDAO dao = new TriviaDAO();
		TriviaDataBeans trivia = dao.trivia(triviaNum);

		// リクエストスコープにユーザ一覧情報をセット
		request.setAttribute("food", food);
		request.setAttribute("trivia", trivia);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
