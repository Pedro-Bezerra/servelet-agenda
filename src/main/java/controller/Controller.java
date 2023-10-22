package controller;

import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;


@WebServlet(urlPatterns = {"/ControllerServlet", "/main", "/adicionar", "/select", "/update"})
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
      listarTodosContatos(request, response);
    } else if (action.equals("/adicionar")) {
      inserirContato(request, response);
    } else if (action.equals("/select")) {
      listarContato(request, response);
    } else if (action.equals("/update")) {
      editarContato(request, response);
    } else {
      response.sendRedirect("index.html");
    }
  }


  protected void listarTodosContatos(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ArrayList<JavaBeans> contatos = dao.listarTodosContatos();

    request.setAttribute("contatos", contatos);
    RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
    rd.forward(request, response);

  }

  protected void inserirContato(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    contatoBeans.setNome(request.getParameter("nome"));
    contatoBeans.setFone(request.getParameter("telefone"));
    contatoBeans.setEmail(request.getParameter("email"));

    dao.inserirContato(contatoBeans);
    response.sendRedirect("main");
  }

  protected void listarContato(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String idcon = request.getParameter("idcon");
    // System.out.println(idcon);
    contatoBeans.setIdcon(idcon);
    dao.selecionarContato(contatoBeans);

    request.setAttribute("idcon", idcon);
    request.setAttribute("nome", contatoBeans.getNome());
    request.setAttribute("telefone", contatoBeans.getFone());
    request.setAttribute("email", contatoBeans.getEmail());

    RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
    rd.forward(request, response);

  }

  protected void editarContato(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    contatoBeans.setIdcon(request.getParameter("idcon"));
    contatoBeans.setNome(request.getParameter("nome"));
    contatoBeans.setFone(request.getParameter("telefone"));
    contatoBeans.setEmail(request.getParameter("email"));
    dao.editarContato(contatoBeans);
    response.sendRedirect("main");
  }
}
