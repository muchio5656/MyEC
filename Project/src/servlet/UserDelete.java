package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserDataBeans;
import dao.UserDAO;

/**
 * Servlet implementation class UserDelete
 */
@WebServlet("/UserDelete")
public class UserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// URLからGETパラメータとしてIDを受け取る
				String id = request.getParameter("id");
				// 確認用：idをコンソールに出力
				System.out.println(id);

				// idを引数にして、idに紐づくユーザ情報を出力する
				UserDAO userDao = new UserDAO();
				UserDataBeans user = userDao.userDetail(id);

				request.setAttribute("user", user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userdelete.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// URLからGETパラメータとしてIDを受け取る
		String id = request.getParameter("id");
		// 確認用：idをコンソールに出力
		System.out.println(id);

		UserDAO userDao = new UserDAO();
		userDao.userDelete(id);

		//ユーザ情報を削除しユーザ一覧へリダイレクト
		response.sendRedirect("UserList");

	}

}
