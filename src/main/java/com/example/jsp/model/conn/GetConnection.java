package com.example.jsp.model.conn;

import java.sql.*;

public class GetConnection {

    public static final int CODIGO_RETORNO_ERRO_EXCLUSAO = 0;
    public static final int CODIGO_RETORNO_SUCESSO = 1;
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String BANCO = "jsp";
    private static final String CONEXAO = "jdbc:mysql://localhost:3306/" + BANCO
                                          + "?useTimezone=true&serverTimezone=America/Sao_Paulo&zeroDateTimeBehavior=convertToNull";
    private static final String USUARIO = "cris";
    private static final String SENHA = "30752287";

    public static Connection abrirConexao() throws Exception {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(CONEXAO, USUARIO, SENHA);
        } catch (Exception e) {
            System.out.println("Erro Driver XXX " + e.getMessage());
        }
        return null;
    }

    public static PreparedStatement getPreparedStatement(Connection conn, String sql, int tipoRetorno) {
        try {
            return conn.prepareStatement(sql, tipoRetorno);
        } catch (Exception e) {
            System.out.println("Erro ao obter o PreparedStatement.");
            return null;
        }
    }

    public static PreparedStatement getPreparedStatement(Connection conn, String sql) {
        try {
            return conn.prepareStatement(sql);
        } catch (Exception e) {
            System.out.println("Erro ao obter o PreparedStatement.");
            return null;
        }
    }

    public static void fecharConexao(Connection conn, Statement psmt, ResultSet rs) throws SQLException {
        if (conn != null) {
            conn.close();
        }

        if (rs != null) {
            rs.close();
        }

        if (psmt != null) {
            psmt.close();
        }
    }

}
