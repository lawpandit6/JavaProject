package in.law.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

	private static DataSource ds = null;

	public static Connection getConnection() throws SQLException, IOException {

		if (ds == null) {
			File f = new File(
					"C:\\NOTES\\AshokIt\\IDE\\BookOptServlet\\src\\in\\law\\util\\db.properties");
			FileInputStream fis = new FileInputStream(f);
			Properties p = new Properties();
			p.load(fis);

			String db_url = p.getProperty("db_url");
			String db_uname = p.getProperty("db_uname");
			String db_pwd = p.getProperty("db_pwd");
			String db_driver = p.getProperty("db_driver");

			HikariConfig config = new HikariConfig();
			config.setJdbcUrl(db_url);
			config.setUsername(db_uname);
			config.setPassword(db_pwd);
			config.setDriverClassName(db_driver);

			ds = new HikariDataSource(config);
		}
		return ds.getConnection();
	}
}
