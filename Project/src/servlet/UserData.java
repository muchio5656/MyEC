package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BuyDataBeans;
import beans.UserDataBeans;
import dao.BuyDAO;
import dao.UserDAO;

/**
 * Servlet implementation class UserData
 */
@WebServlet("/UserData")
public class UserData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//ユーザデータ更新用
		String id = request.getParameter("id");

		// idを引数にして、idに紐づくユーザ情報を出力する
		UserDAO userDao = new UserDAO();
		UserDataBeans user = userDao.userDetail(id);

		request.setAttribute("user", user);

		//購入履歴用
		BuyDAO buyDao = new BuyDAO();
		List<BuyDataBeans> userHistory = buyDao.buyHistory(id);

		//リクエストスコープにユーザ一覧情報をセット
		request.setAttribute("userHistory", userHistory);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userdata.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//文字化け防止処理
		request.setCharacterEncoding("UTF-8");
		// リクエストパラメータの入力項目を取得
		String id = request.getParameter("id");
		String mailAddress = request.getParameter("mailAddress");
		String name = request.getParameter("name");
		String address = request.getParameter("address");

		request.setAttribute("id", id);
		request.setAttribute("mailAddress", mailAddress);
		request.setAttribute("name", name);
		request.setAttribute("address", address);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userupdate.jsp");
		dispatcher.forward(request, response);
	}
}
