import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnectDao3 {
	public void conectOracle(String Sql) throws Exception {
		/* ���[�U�� */
		String user = "system";
		/* �p�X���[�h */
		String pass = "kawadb";
		/* �T�[�o�� */
		String servername = "localhost";
		Connection conn = null;
		/* SQL�� */
		String InSql = Sql;
		PreparedStatement ps = null;
		try {
			/* �h���C�o�N���X�̃��[�h */
			Class.forName("oracle.jdbc.driver.OracleDriver");
			/* Connection�̍쐬 */
			conn = DriverManager.getConnection("jdbc:oracle:thin:@" + servername + ":1521:", user, pass);
			/* SQL�̎w�� */
			ps = conn.prepareStatement(InSql);
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
