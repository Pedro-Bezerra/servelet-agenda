package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;


@WebServlet(urlPatterns = {"/ControllerServlet", "/main", "/adicionar"})
public class Controller extends HttpServlet {
  private static final long serialVersionUID = 1L;
  DAO dao = new DAO();
  JavaBeans contatoBeans = new JavaBeans();


  public Controller() {
    super();
  }


  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.getWriter().append("Served at: ").append(request.getContextPath());
    String action = request.getServletPath();
    if (action.equals("/main")) {
      mostrarContatos(request, response);
    } else if (action.equals("/adicionar")) {
      inserirContato(request, response);
    } else {
      response.sendRedirect("index.html");
    }
  }


  protected void mostrarContatos(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.sendRedirect("agenda.jsp");
  }

  protected void inserirContato(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    contatoBeans.setNome(request.getParameter("nome"));
    contatoBeans.setFone(request.getParameter("telefone"));
    contatoBeans.setEmail(request.getParameter("email"));

    dao.inserirContato(contatoBeans);
    response.sendRedirect("main");
  }


}
