import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/shop"})
public class Shop extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name = req.getParameter("username");

        HttpSession session = req.getSession(true);
        req.getSession().setAttribute("username",name);




        resp.getWriter().write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>shop</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1> Hello ( "+name+" ) </h1>\n" +
                "<p>\n" +
                "    make you order\n" +
                "</p>\n" +
                "<form action=\"/price\" method=\"post\">\n" +
                "    <select name=\"cars[]\" multiple>\n" +
                "        <optionv  value=\"10000|volvo\">Volvo</optionv>\n" +
                "        <option value=\"20000|saab\">Saab</option>\n" +
                "        <option value=\"2000|mercedes\">Mercedes</option>\n" +
                "        <option value=\"3000|taz\">taz2107</option>\n" +
                "\n" +
                "    </select>\n" +
                "    <br>\n" +
                "    <input type=\"submit\" value=\"buy\">\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");









    }


}
