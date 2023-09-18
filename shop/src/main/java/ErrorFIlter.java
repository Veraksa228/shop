import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebFilter (filterName = "CheckBoxFromWelcome",
urlPatterns = {"/shop"})
public class ErrorFIlter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String TermOfuse = req.getParameter("TermOfUse");
        if("on".equals(TermOfuse)){
            chain.doFilter(request,response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Error");
            requestDispatcher.forward(request,response);
        }
    }
}
