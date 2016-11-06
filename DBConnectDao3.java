import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnectDao3 {
	public void conectOracle(String Sql) throws Exception {
		/* ユーザ名 */
		String user = "system";
		/* パスワード */
		String pass = "kawadb";
		/* サーバ名 */
		String servername = "localhost";
		Connection conn = null;
		/* SQL文 */
		String InSql = Sql;
		PreparedStatement ps = null;
		try {
			/* ドライバクラスのロード */
			Class.forName("oracle.jdbc.driver.OracleDriver");
			/* Connectionの作成 */
			conn = DriverManager.getConnection("jdbc:oracle:thin:@" + servername + ":1521:", user, pass);
			/* SQLの指定 */
			ps = conn.prepareStatement(InSql);
			/* INSERT実行 */
			ps.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			throw e;
		} finally {
			/* クローズ処理 */
			if (conn != null) {
				conn.close();
				conn = null;
				// System.out.println("切断しました");
			}
		}
	}
}
