package com.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

// Test 코드는 무조건 public으로 선언
public class ConnectTests {

    @Test
    public void testConnection() throws Exception {
        // 현재 돌아가고 있는 Class의 이름
        Class.forName("org.mariadb.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/webdb",
                "webuser",
                "12345678"
        );
        
        // 데이터베이스와 정상적으로 연결이 되면 null이 아니므로 연결했음의 의미
        Assertions.assertNotNull(connection);

        connection.close();
    }

    @Test
    public void testHikariCP() throws Exception {
        // HikariConfig 타입의 객체를 생성해야 함
        // -> Connection pool을 설정하는데 필요한 정보를 가지고 있는 객체
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
        config.setUsername("webuser");
        config.setPassword("12345678");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        // HikariDataSource 객체를 생성하면 getConnection()을 제공받아 이용할 수 있다.
        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();

        System.out.println(connection);

        connection.close();
    }
}
