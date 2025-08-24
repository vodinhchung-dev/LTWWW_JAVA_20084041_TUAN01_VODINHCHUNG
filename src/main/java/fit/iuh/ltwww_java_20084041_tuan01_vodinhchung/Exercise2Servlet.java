package fit.iuh.ltwww_java_20084041_tuan01_vodinhchung;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/exercise2")
public class Exercise2Servlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentTime = now.format(formatter);

        String name = request.getParameter("name");
        if (name == null || name.trim().isEmpty()) {
            name = "Guest";
        }

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Exercise 2 - HTML Response</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        out.println("<h1>Exercise 2: Jakarta Servlet - Thao tác với doGet()</h1>");
        out.println("<div class=\"info\">");
        out.println("<p><strong>Param ne: , </strong><span class=\"name\">" + name + "</span>!</p>");
        out.println("<p><strong>Current Time: </strong><span class=\"time\">" + currentTime + "</span></p>");
        out.println("<p><strong>Request Method: </strong>" + request.getMethod() + "</p>");
        out.println("<p><strong>end point: </strong>" + request.getRequestURI() + "</p>");
        out.println("<p><strong>Server Name: </strong>" + request.getServerName() + "</p>");
        out.println("<p><strong>Server Port: </strong>" + request.getServerPort() + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
