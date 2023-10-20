package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {
  /* Módulo de conexão */
  // parâmetros de conexão
  private String driver = "org.postgresql.Driver";
  private String url =
      "jdbc:postgresql://localhost:5432/dbagenda?useTimezone=true&serverTimeZone=UTC";
  private String user = "postgres";
  private String password = "uriel";

  // métodos de conexão
  private Connection conectar() {
    Connection con = null;
    try {
      Class.forName(driver);
      con = DriverManager.getConnection(url, user, password);
      return con;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }

  // teste de conexão

  public void testeConexao() {
    try {
      Connection con = conectar();
      System.out.println(con);
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void inserirContato(JavaBeans contatoBeans) {
    String query = "insert into contatos(nome, fone, email) values (?, ?, ?)";
    try {
      Connection con = conectar();

      PreparedStatement pst = con.prepareStatement(query);
      pst.setString(1, contatoBeans.getNome());
      pst.setString(2, contatoBeans.getFone());
      pst.setString(3, contatoBeans.getEmail());
      pst.executeUpdate();

      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
