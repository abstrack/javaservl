package jsp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Admin on 9/25/16.
 */
public class LoginServlet extends HttpServlet {
    private UserDataSource userDataSource;


    public LoginServlet() {
        userDataSource =  new UserDataSource();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username != null && password != null) {
            User user = userDataSource.getByUsernameAndPassword(username, password);
            if (user != null) {

                System.out.println("user created");
                session.setAttribute("PRINCIPAL", user);
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
                requestDispatcher.forward(request, response);
                return;
            }
            response.sendRedirect("login.jsp?loginorpassword=invalid");
        }
    }
}
