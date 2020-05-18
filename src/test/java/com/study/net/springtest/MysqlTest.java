package com.study.net.springtest;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @description:
 * @author: zjt
 * @date: 2020-05-10 16:02
 */
public class MysqlTest {

    private Connection conn = null;
    private Statement statement = null;

    @Before
    public void before() throws Exception {
        // 驱动程序名
        String driver = "com.mysql.cj.jdbc.Driver";
        // URL指向要访问的数据库名scutcs
        String url = "jdbc:mysql://101.132.183.157:3306/studymysql?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&nullNamePatternMatchesAll=true";
        // MySQL配置时的用户名
        String user = "root";
        // MySQL配置时的密码
        String password = "user_pass";
        // 加载驱动程序
        Class.forName(driver);
        // 连续数据库
        conn = DriverManager.getConnection(url, user, password);
        if (!conn.isClosed())
            System.out.println("Succeeded connecting to the Database!");

        // statement用来执行SQL语句
        statement = conn.createStatement();
    }

    @Test
    public void test() throws Exception {

        String sql = "insert into studymysql.log_test value (default,'%s','%s','%s');";

        for (int i = 0; i < 20; i++) {
            String thisSql = String.format(sql, i, i, "2020-05-10 15:07:03");
            statement.execute(thisSql);
            System.out.println("thisSql = " + thisSql);
        }
    }

    @Test
    public void test3(){
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

}