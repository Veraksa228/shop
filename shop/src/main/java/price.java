import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@WebServlet("/price")
public class price extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String name = session.getAttribute("username").toString();

        String cars[] = req.getParameterValues("cars[]");
        resp.getWriter().write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>price</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1> hi "+ name +" ur buy</h1>\n" +
                "<ol>");
        try {
            resp.getWriter().write(writeLi(nameCar(cars),returnCarPrice(cars)));
            resp.getWriter().write("<p> Total:"+ TotalPrice(returnCarPrice(cars)) +"</p>");
            resp.getWriter().write("</ol>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>");
        } catch (Exception ex){
            ex.printStackTrace();
        }


    }

private int TotalPrice(int[] priceCar){
        int result = 0;
    for (int i = 0; i < priceCar.length; i++) {
        result += priceCar[i];
    }
        return result;
    }
    private int[] returnCarPrice(String[] cars) {
        int prices[] = new int[cars.length];
        Pattern pattern = Pattern.compile("\\d+");
        for (int i = 0; i < cars.length; i++) {
            Matcher matcher = pattern.matcher(cars[i]);
            while (matcher.find()) {
                prices[i] = Integer.parseInt(matcher.group());
            }
        }
        return prices;
    }

    private String[] nameCar(String[] cars) {
        Pattern p = Pattern.compile("\\d+");
        String[] car = new String[cars.length];
        for (int i = 0; i < cars.length; i++) {
            car[i] = cars[i].replaceAll("\\P{L}+", "");
        }
        return car;

    }

    private String writeLi(String[] cars, int[] price) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < cars.length; i++) {
            res.append("<li>" + "car ")
                    .append(cars[i])
                    .append(" price: ")
                    .append(price[i])
                    .append("</li>");
        }
        return res.toString();
    }
}
