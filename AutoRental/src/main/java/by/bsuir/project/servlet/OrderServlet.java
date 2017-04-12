package by.bsuir.project.servlet;

import by.bsuir.project.dao.OrderDAOImpl;
import by.bsuir.project.model.Order;
import by.bsuir.project.util.Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * Created by User on 27.03.2017.
 */
@WebServlet(urlPatterns = {"/OrderServlet"})
public class OrderServlet extends Servlet {
    private static OrderDAOImpl dao;
    private static final long serialVersionUID = 1L;
    private static final String LIST_ORDERS = "/listOrders.jsp";
    private static final String INSERT_OR_EDIT = "/edtOrder.jsp";
    private static final String ACTION_DELETE = "delete";
    private static final String ACTION_EDIT = "edit";
    private static final String ACTION_LIST_VIEW = "list";
    private static final String ACTION_INSERT = "insert";
    private static final String ACTION_POST = "post";

    public OrderServlet() {
        dao = new OrderDAOImpl();
    }

    protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String forward = "";
        switch (action) {
            case ACTION_DELETE:
                forward = delete(request, response);
                break;
            case ACTION_EDIT:
                forward = edit(request, response);
                break;
            case ACTION_LIST_VIEW:
                forward = view_list(request, response);
                break;
            case ACTION_INSERT:
                forward = insert(request, response);
                break;
            case ACTION_POST:
                forward = post(request, response);
                break;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected String delete(HttpServletRequest request, HttpServletResponse response) {
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        dao.deleteOrder(order_id);
        request.setAttribute("orders", dao.getAllOrders());
        return LIST_ORDERS;
    }

    @Override
    protected String edit(HttpServletRequest request, HttpServletResponse response) {
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        Order order = dao.getOrderById(order_id);
        request.setAttribute("order", order);
        return INSERT_OR_EDIT;
    }

    @Override
    protected String view_list(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("orders", dao.getAllOrders());
        return LIST_ORDERS;
    }

    @Override
    protected String insert(HttpServletRequest request, HttpServletResponse response) {
        return INSERT_OR_EDIT;
    }

    @Override
    protected String post(HttpServletRequest request, HttpServletResponse response) {
        Order order = new Order();
        order.setOrder_client(Integer.parseInt(request.getParameter("order_client")));
        order.setOrder_car(Integer.parseInt(request.getParameter("order_car")));
        order.setOrder_date_begin(Date.valueOf(request.getParameter("order_date_begin")));
        order.setOrder_date_expir(Date.valueOf(request.getParameter("order_date_expir")));
        String order_id = (request.getParameter("order_id"));
        if (order_id == null || order_id.isEmpty())
            dao.addOrder(order);
        else
        {
            order.setOrder_id(Integer.parseInt(order_id));
            dao.updateOrder(order);
        }
        request.setAttribute("orders", dao.getAllOrders());
        return LIST_ORDERS;
    }
}
