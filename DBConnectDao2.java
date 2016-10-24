import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnectDao2 {
	public void conectOracle(String strin) throws Exception{
		/* ユーザ名 */
		String user = "system";
		/* パスワード */
		String pass = "kawadb";
		/* サーバ名 */
		String servername = "localhost";
		Connection conn = null;
		/* SQL文 */
		String sql =null;
		if(strin.equals("1") ){
			sql = "SELECT * FROM book";
		}
		else if(strin.equals("2")){
			sql = "SELECT * FROM library";
		}
		else{
			sql = "SELECT library.libname ,count(*) ";
			sql += "FROM lblink, library ";
			sql += "WHERE lblink.libid = library.id ";
			sql += "group by library.libname";
		}
		PreparedStatement ps = null;
        ResultSet rs = null;
	  	try{
			/* ドライバクラスのロード */
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			/* Connectionの作成 */
			conn = DriverManager.getConnection 
			("jdbc:oracle:thin:@" + servername + ":1521:" ,user,pass);
			/* SQLの指定 */
            ps = conn.prepareStatement(sql);
			/* SELECT実行 */
            rs = ps.executeQuery();
            //取得した結果を全件出力する
            while(rs.next()){
        		if(strin.equals("1") ){
                    System.out.print(rs.getString("id"));
                    System.out.print("/" + rs.getString("title"));
                    System.out.print("/" + rs.getInt("price"));
                    System.out.print("/" + rs.getString("author"));
                    System.out.print("/" + rs.getString("publisher"));
                    System.out.print("/" + rs.getDate("entry_date"));
                    System.out.print("/" + rs.getDate("update_date"));
        		}
        		else if(strin.equals("2")){
                    System.out.print(rs.getString("id"));
                    System.out.print("/" + rs.getString("libname"));
                    System.out.print("/" + rs.getDate("entry_date"));
                    System.out.print("/" + rs.getDate("update_date"));
        		}
        		else{
                    System.out.print(rs.getString("libname"));
                    System.out.print(":" + rs.getString("count(*)"));
        		}
                System.out.println();
            }
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
	}
}

