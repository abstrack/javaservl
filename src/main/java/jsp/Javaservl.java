package jsp; /**
 * Created by Admin on 9/23/16.
 */
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;
public class Javaservl extends HttpServlet {
    private Integer status;
    @Override
    public void init() throws ServletException {

    }

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("1", 1);
        request.setAttribute("2", "aaaaaaaaa");
        request.setAttribute("status", status);
   request.getRequestDispatcher("/home.jsp").forward(request, response);
}
}
