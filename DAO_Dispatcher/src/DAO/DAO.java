/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Oscar Montes
 */
public class DAO {
    
    public Connection conexion;
    public Statement statement;
  
    
    public DAO() throws SQLException, NamingException {
        InitialContext ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("jdbc/cargodispatcher");
        Connection con = ds.getConnection();
        this.conexion=con;
        this.statement=con.createStatement();

    }
    public void cerrarConexion() throws SQLException{
        conexion.close();
        statement.close();
    }
    public Connection getConexion() throws NamingException, SQLException{
        InitialContext ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("jdbc/cargodispatcher");
        Connection con = ds.getConnection();
        this.conexion=con;
        return conexion;
        
    }

    public Statement getStatement() throws NamingException, SQLException{
        InitialContext ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("jdbc/cargodispatcher");
        Connection con = ds.getConnection();
        this.conexion=con;
        this.statement=con.createStatement();
        return statement;
    }
    
}
