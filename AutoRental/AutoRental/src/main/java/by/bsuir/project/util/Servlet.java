package by.bsuir.project.util;

/**
 * Created by User on 27.03.2017.
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class Servlet extends HttpServlet {

    protected final void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request,response);
    }

    protected final void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request,response);
    }

    protected abstract String insert(HttpServletRequest request, HttpServletResponse response);

    protected abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    protected abstract String delete(HttpServletRequest request, HttpServletResponse response);

    protected abstract String edit(HttpServletRequest request, HttpServletResponse response);

    protected abstract String view_list(HttpServletRequest request, HttpServletResponse response);

    protected abstract String post(HttpServletRequest request, HttpServletResponse response);
}
