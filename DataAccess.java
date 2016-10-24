import java.sql.Connection;
import java.sql.DriverManager;

public class DataAccess {
	
	public static void main(String[] args) {
		try{
			conectOracle();
			/* 成功メッセージ */
			System.out.println("接続に成功しました");
		}
		catch (Exception e){			
			/* エラーメッセージ */
			System.out.println("接続に失敗しました");
		}
	}

	public static void conectOracle() throws Exception{
		/* ユーザ名 */
		String user = "system";
		/* パスワード */
		String pass = "kawadb";
		/* サーバ名 */
		String servername = "localhost";
		Connection conn = null;
 
	  	try{
			/* ドライバクラスのロード */
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			/* Connectionの作成 */
			conn = DriverManager.getConnection 
			("jdbc:oracle:thin:@" + servername + ":1521:" ,user,pass);
		}
	  	catch ( Exception e){
			throw e;	
		}
		finally{			
			/* クローズ処理 */
			if(conn != null){
			  conn.close();
			  conn = null;
			  System.out.println("切断しました");
			}
	    }
	}
}
  
