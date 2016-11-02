import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBConnectDao2 {
	public <T> List<T> conectOracle(String Strin, String Sql) throws Exception{
		/* ユーザ名 */
		String user = "system";
		/* パスワード */
		String pass = "kawadb";
		/* サーバ名 */
		String servername = "localhost";
		String SelTable = Strin;
		Connection conn = null;
		/* SQL文 */
		String InSql = Sql;
		PreparedStatement ps = null;
        ResultSet rs = null;
        List SelList = new ArrayList();
	  	try{
			/* ドライバクラスのロード */
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			/* Connectionの作成 */
			DataSelStore dataselstore = new DataSelStore();
			conn = DriverManager.getConnection
			("jdbc:oracle:thin:@" + servername + ":1521:" ,user,pass);
			/* SQLの指定 */
            ps = conn.prepareStatement(InSql);
			/* SELECT実行 */
            rs = ps.executeQuery();
            SelList= dataselstore.SetDbData(rs, SelTable);
	  	}
	  	catch ( Exception e){
			throw e;	
		}
		finally{			
			/* クローズ処理 */
			if(conn != null){
			  conn.close();
			  conn = null;
			  //System.out.println("切断しました");
			  }
		}
		return SelList;
	}
}
