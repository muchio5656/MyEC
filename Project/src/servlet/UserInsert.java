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
 * Servlet implementation class UserInsert
 */
@WebServlet("/UserInsert")
public class UserInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userinsert.jsp");
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
				String StringBirthDate = request.getParameter("birthDate");
				String password = request.getParameter("password");
				String password2 = request.getParameter("password2");



				UserDAO user =new UserDAO();

				//メールアドレスの重複がある場合trueが帰ってくるメソッド
				boolean check = user.idCheck(mailAddress);

				//値が間違ってる場合エラーメッセージをセットしてinsertページへフォワード
				if (mailAddress.equals("") || password.equals("") || name.equals("") || StringBirthDate.equals("")
						|| !(password.equals(password2)) || check) {
					request.setAttribute("errMsg", "入力された値は正しくありません");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userinsert.jsp");
					dispatcher.forward(request, response);
					return;
				}

				//先にString型のbirthDateをセット
				request.setAttribute("StringBirthDate", StringBirthDate);


				UserDataBeans userConfirm = new UserDataBeans(mailAddress,name,address,StringBirthDate,password);
				// リクエストスコープにユーザ一覧情報をセット
				request.setAttribute("user", userConfirm);



				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/insertconfirm.jsp");
				dispatcher.forward(request, response);




	}

}
