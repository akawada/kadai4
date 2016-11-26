import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBConnectDao4 {
	public <T> List<T> conectOracle(String strin, String sql) throws Exception {
		/* ���[�U�� */
		String user = "system";
		/* �p�X���[�h */
		String pass = "kawadb";
		/* �T�[�o�� */
		String serverName = "localhost";
		String selTable = strin;
		Connection conn = null;
		/* SQL�� */
		String inSql = sql;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List selList = new ArrayList();
		try {
			/* �h���C�o�N���X�̃��[�h */
			Class.forName("oracle.jdbc.driver.OracleDriver");
			/* Connection�̍쐬 */
			DataSelStore dataselstore = new DataSelStore();
			conn = DriverManager.getConnection("jdbc:oracle:thin:@" + serverName + ":1521:", user, pass);
			/* SQL�̎w�� */
			ps = conn.prepareStatement(inSql);
			/* SELECT���s */
			rs = ps.executeQuery();
			selList = dataselstore.SetDbData(rs, selTable);
		} catch (Exception e) {
			throw e;
		} finally {
			/* �N���[�Y���� */
			if (conn != null) {
				conn.close();
				conn = null;
				// System.out.println("�ؒf���܂���");
			}
		}
		return selList;
	}

	public void executeInsert(String sql) throws Exception {
		/* ���[�U�� */
		String user = "system";
		/* �p�X���[�h */
		String pass = "kawadb";
		/* �T�[�o�� */
		String serverName = "localhost";
		Connection conn = null;
		/* SQL�� */
		String inSql = sql;
		PreparedStatement ps = null;
		try {
			/* �h���C�o�N���X�̃��[�h */
			Class.forName("oracle.jdbc.driver.OracleDriver");
			/* Connection�̍쐬 */
			conn = DriverManager.getConnection("jdbc:oracle:thin:@" + serverName + ":1521:", user, pass);
			/* SQL�̎w�� */
			ps = conn.prepareStatement(inSql);
			/* INSERT���s */
			ps.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			throw e;
		} finally {
			/* �N���[�Y���� */
			if (conn != null) {
				conn.close();
				conn = null;
				// System.out.println("�ؒf���܂���");
			}
		}
	}
}
