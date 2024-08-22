package in.law.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	private static DataSource ds = null;

	public static Connection getConnetion() throws SQLException {
		try {

			if (ds == null) {
				File f = new File("");
				FileInputStream fis = new FileInputStream(f);

				Properties p = new Properties();
				p.load(fis);

				HikariConfig config = new HikariConfig();
				config.setJdbcUrl(p.getProperty("db_url"));
				config.setUsername(p.getProperty("db_uname"));
				config.setPassword(p.getProperty("db_pwd"));
				config.setDriverClassName(p.getProperty("db_driver"));

				ds = new HikariDataSource(config);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds.getConnection();

	}
}
