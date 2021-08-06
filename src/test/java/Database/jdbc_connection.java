package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class jdbc_connection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection con = null;

		try {
			String DBurl = "jdbc:oracle:thin:talasila/talasila@hillman:1521/pegdev121";
			con = DriverManager.getConnection(DBurl);
			System.out.println("Connection Established");
			Statement query = con.createStatement();
			ResultSet result = query.executeQuery("SELECT * FROM SD_USER_INFO where USERNAME like 'CHAI%'");

			while (result.next()) {
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();

				driver.get("https://www.facebook.com/");
				driver.findElement(By.name("email")).sendKeys(result.getString("USERNAME"));
				driver.findElement(By.name("pass")).sendKeys(result.getString("PASSWORD"));
				driver.close();

				// System.out.println(result.getString("USERNAME"));
				// System.out.println(result.getString("PASSWORD"));

			}
			result.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

}
