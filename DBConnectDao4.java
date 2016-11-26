import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBConnectDao4 {
	public <T> List<T> conectOracle(String strin, String sql) throws Exception {
		/* ユーザ名 */
		String user = "system";
		/* パスワード */
		String pass = "kawadb";
		/* サーバ名 */
		String serverName = "localhost";
		String selTable = strin;
		Connection conn = null;
		/* SQL文 */
		String inSql = sql;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List selList = new ArrayList();
		try {
			/* ドライバクラスのロード */
			Class.forName("oracle.jdbc.driver.OracleDriver");
			/* Connectionの作成 */
			DataSelStore dataselstore = new DataSelStore();
			conn = DriverManager.getConnection("jdbc:oracle:thin:@" + serverName + ":1521:", user, pass);
			/* SQLの指定 */
			ps = conn.prepareStatement(inSql);
			/* SELECT実行 */
			rs = ps.executeQuery();
			selList = dataselstore.SetDbData(rs, selTable);
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
		return selList;
	}

	public void executeInsert(String sql) throws Exception {
		/* ユーザ名 */
		String user = "system";
		/* パスワード */
		String pass = "kawadb";
		/* サーバ名 */
		String serverName = "localhost";
		Connection conn = null;
		/* SQL文 */
		String inSql = sql;
		PreparedStatement ps = null;
		try {
			/* ドライバクラスのロード */
			Class.forName("oracle.jdbc.driver.OracleDriver");
			/* Connectionの作成 */
			conn = DriverManager.getConnection("jdbc:oracle:thin:@" + serverName + ":1521:", user, pass);
			/* SQLの指定 */
			ps = conn.prepareStatement(inSql);
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
