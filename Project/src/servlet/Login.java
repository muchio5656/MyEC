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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//文字化け防止処理
		request.setCharacterEncoding("UTF-8");

		//リクエストパラメータの入力項目を取得
		String mailAddress = request.getParameter("mailAddress");
		String password = request.getParameter("password");

		UserDAO userDao = new UserDAO();
		//パスワードを暗号化
		password = userDao.angoka(password);

		// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
		UserDataBeans user = userDao.findByLoginInfo(mailAddress, password);

		if (user == null) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "入力した内容は正しくありません");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
			return;
		}
		//データベースに該当データが見つかった場合(ログイン成功時)
		// セッションにユーザの情報をセット

		HttpSession session = request.getSession();
		session.setAttribute("userInfo", user);
		//Topページへリダイレクト
		response.sendRedirect("Top");
	}
}
