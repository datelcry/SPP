package by.bsuir.project.controller;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.command.factory.ActionFactory;
import by.bsuir.project.exception.ActionException;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.util.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/controller")
public class AppServlet extends HttpServlet {


    protected final void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected final void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;

        ActionFactory actionFactory = new ActionFactory();
        ActionCommand command = actionFactory.defineCommand(request);

        try {
            page = command.execute(request);
            if (page != null) {
                request.getRequestDispatcher(page).forward(request, response);
            } else {
                page = Configuration.getProperty("path.page.index");
                request.getSession().setAttribute("nullPage","message.nullpage");
                response.sendRedirect(request.getContextPath() + page);
            }
        } catch (CommandException|ActionException e) {
            e.printStackTrace();
        }

    }

}
