import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/welcome"})
public class Welcome extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>sadsad</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1> sfdsdfsdf</h1>\n" +
                "<form action=\"/shop\" method=\"post\" class=\"register-form\">\n" +
                "    <input type=\"text\" name=\"username\" placeholder=\"name\"/>\n" +
                "    <input type=\"password\" name = \"password\" placeholder=\"password\"/>\n" +
                "    <input type=\"text\" placeholder=\"email address\"/>\n" +
                "    <button>create</button>\n" +
                "    <div>\n" +
                "        <input type=\"checkbox\" id=\"TermOfUse\" name=\"TermOfUse\"/>\n" +
                "        <label for=\"TermOfUse\">I agree with the terms of service\n</label>\n" +
                "    </div>\n" +
                "\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }
}
