package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

/**
 * Servlet implementation class InsertConfirm
 */
@WebServlet("/InsertConfirm")
public class InsertConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/insertconfirm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの入力項目を取得
				String mailAddress = request.getParameter("mailAddress");
				String name = request.getParameter("name");
				String address = request.getParameter("address");
				String birthDate = request.getParameter("birthDate");
				String password = request.getParameter("password");

				UserDAO user =new UserDAO();


				// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行

				user.userInsert(mailAddress, password, name, birthDate,address);


				response.sendRedirect("InsertDone");
	}

}
