package com.test.run;

import java.sql.Connection;
import java.sql.DriverManager;

public class InsertMysql {
	Connection conn = null;

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载数据库驱动
			System.out.println("数据库驱动加载成功");
			String url = "jdbc:mysql:10.100.111.5:3306";
			// 如果不加useSSL=false就会有警告，由于jdbc和mysql版本不同，有一个连接安全问题

			String user = "jgcrmUser";
			String passWord = "jgcrm#PWD123";
			// System.out.println("1");
			// Connection对象引的是java.sql.Connection包
			conn = (Connection) DriverManager.getConnection(url,user,passWord); // 创建连接
			System.out.println("已成功的与数据库MySQL建立连接！！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
