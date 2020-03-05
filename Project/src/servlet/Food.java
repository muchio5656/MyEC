package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.FoodDataBeans;
import dao.FoodDAO;

/**
 * Servlet implementation class Food
 */
@WebServlet("/Food")
public class Food extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String foodId = request.getParameter("foodId");
		int foodNum = Integer.parseInt(foodId);
		FoodDAO foodDao = new FoodDAO();
		//foodIdを元にベストマッチ商品リストを取得
		List<FoodDataBeans> food = foodDao.bestMuch(foodNum);

		// リクエストスコープにユーザ一覧情報をセット
		request.setAttribute("food", food);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/food.jsp");
		dispatcher.forward(request, response);
	}
}
