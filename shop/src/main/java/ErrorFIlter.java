import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebFilter (urlPatterns = {"/shop"})
public class ErrorFIlter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;


        if(req.getSession().getAttribute("on") == null){
            if(req.getParameter("TermOfUse") != null ){
                req.getSession().setAttribute("on",req.getParameter("TermOfUse"));
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Error");
                requestDispatcher.forward(request,response);
            }

        }
        chain.doFilter(request,response);
    }

    public ErrorFIlter() {
        super();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
