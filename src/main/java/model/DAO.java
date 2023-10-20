package model;

import java.sql.Connection;
import java.sql.DriverManager;

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
}
