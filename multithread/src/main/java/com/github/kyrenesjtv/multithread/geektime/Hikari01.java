package com.github.kyrenesjtv.multithread.geektime;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hikari 数据源
 *
 * @author huojianxiong
 * 2021/11/11 16:12
 */
public class Hikari01 {

    public static void main(String[] args) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setMinimumIdle(1);
        hikariConfig.setMaximumPoolSize(2);
        hikariConfig.setConnectionTestQuery("select 1");
        hikariConfig.setDataSourceClassName("org.h2.jdbcx.JdbcDataSource");
        hikariConfig.addDataSourceProperty("url", "jdbc:h2:mem:test");
        //创建数据源
        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            //获取数据库连接
            conn = hikariDataSource.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from abc");
            //获取结果
            while (rs.next()){
                int id = rs.getInt(1);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭连接，从后往前关闭
            close(rs);
            close(stmt);
            close(conn);
        }
    }

    static void close(AutoCloseable rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
