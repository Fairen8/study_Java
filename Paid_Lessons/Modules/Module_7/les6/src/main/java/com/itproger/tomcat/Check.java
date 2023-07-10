package com.itproger.tomcat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/check")
public class Check extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/check.jsp";

        String itemName = req.getParameter("item_name");
        int price = Integer.parseInt(req.getParameter("price"));
        String info = req.getParameter("info");

        Item item = new Item(itemName, price, info);
        ItemService.add(item);

        req.setAttribute("itemName", itemName);
        req.setAttribute("price", price);
        req.setAttribute("info", info);

        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
