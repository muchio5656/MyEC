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
import beans.ItemDataBeans;
import beans.TriviaDataBeans;
import dao.FoodDAO;
import dao.ItemDAO;
import dao.TriviaDAO;

/**
 * Servlet implementation class Top
 */
@WebServlet("/Top")
public class Top extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//TOPページで使用する乱数の生成
		Random rand = new Random();
		int triviaNum = rand.nextInt(10) + 1;
		int foodNum = rand.nextInt(5) + 1;

		//商品ランキング表示用
		ItemDAO itemDao = new ItemDAO();
		List<ItemDataBeans> itemRanking = itemDao.ranking();
		//本日のおつまみ表示用
		FoodDAO foodDao = new FoodDAO();
		List<FoodDataBeans> food = foodDao.bestMuch(foodNum);

		//ウンチクコーナー
		TriviaDAO dao = new TriviaDAO();
		TriviaDataBeans trivia = dao.trivia(triviaNum);

		// リクエストスコープにユーザ一覧情報2をセット
		request.setAttribute("itemRanking", itemRanking);
		request.setAttribute("food", food);
		request.setAttribute("trivia", trivia);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
		dispatcher.forward(request, response);
	}


}
