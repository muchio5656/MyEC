package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;

/**
 * Servlet implementation class UserUpdate
 */
@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();


		//文字化け防止処理
				request.setCharacterEncoding("UTF-8");
		// リクエストパラメータの入力項目を取得
		String id = request.getParameter("id");
		String mailAddress = request.getParameter("mailAddress");
		String name = request.getParameter("name");
		String address = request.getParameter("address");

		UserDAO user = new UserDAO();

		boolean check = user.uptadeIdCheck(mailAddress,id);


		//値が間違ってる場合エラーメッセージをセットしてupdateページへフォワード
				if (name.equals("") || mailAddress.equals("") || address.equals("")||check) {
					request.setAttribute("errMsg", "更新失敗");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userdata.jsp");
					dispatcher.forward(request, response);
					return;
				}


		user.userUpdate(id,mailAddress,name,address);

		response.sendRedirect("Top");

	}

}
