import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBConnectDao2 {
	public <T> List<T> conectOracle(String Strin, String Sql) throws Exception{
		/* ���[�U�� */
		String user = "system";
		/* �p�X���[�h */
		String pass = "kawadb";
		/* �T�[�o�� */
		String servername = "localhost";
		String SelTable = Strin;
		Connection conn = null;
		/* SQL�� */
		String InSql = Sql;
		PreparedStatement ps = null;
        ResultSet rs = null;
        List SelList = new ArrayList();
	  	try{
			/* �h���C�o�N���X�̃��[�h */
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			/* Connection�̍쐬 */
			DataSelStore dataselstore = new DataSelStore();
			conn = DriverManager.getConnection
			("jdbc:oracle:thin:@" + servername + ":1521:" ,user,pass);
			/* SQL�̎w�� */
            ps = conn.prepareStatement(InSql);
			/* SELECT���s */
            rs = ps.executeQuery();
            SelList= dataselstore.SetDbData(rs, SelTable);
	  	}
	  	catch ( Exception e){
			throw e;	
		}
		finally{			
			/* �N���[�Y���� */
			if(conn != null){
			  conn.close();
			  conn = null;
			  //System.out.println("�ؒf���܂���");
			  }
		}
		return SelList;
	}
}
