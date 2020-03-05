package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDataBeans;
import dao.UserDAO;

/**
 * Servlet implementation class MasterLogin
 */
@WebServlet("/MasterLogin")
public class MasterLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/masterlogin.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//文字化け防止処理
		request.setCharacterEncoding("UTF-8");

		//リクエストパラメータの入力項目を取得
		String mailAddress = request.getParameter("mailAddress");
		String password = request.getParameter("password");

		UserDAO user =new UserDAO();
		//パスワードを暗号化
		password = user.angoka(password);

		UserDataBeans master = user.masterKey(mailAddress, password);

		if (master == null) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "管理者以外の方はこちらからログインしてください");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
			return;
		}
		HttpSession session = request.getSession();
		session.setAttribute("master", master);

		//マスターリストページへリダイレクト
		response.sendRedirect("MasterList");

	}
}
