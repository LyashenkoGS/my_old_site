// Import required java libraries
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class HelloWorld extends HttpServlet {

    private String message;

    public void init() throws ServletException
    {
        // Do required initialization
        message = "Hello World";
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
        
        Map<String, String> mockMap = new HashMap<String,String>();
        mockMap.put("Kill Kennedy","ScarFace");
        mockMap.put("Fuck the girl from the next door","Doctor Hause");

        for (Map.Entry<String, String> entry : mockMap.entrySet()) {
            String key = entry.getKey().toString();;
            String value = entry.getValue();
            System.out.println("key, " + key + " value " + value );
            out.println(key + ":" + value+"</br>");
        }
    }

    public void destroy()
    {
        // do nothing.
    }
}