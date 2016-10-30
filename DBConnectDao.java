import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBConnectDao {
	public <T> List<T> conectOracle() throws Exception{
		/* ユーザ名 */
		String user = "system";
		/* パスワード */
		String pass = "kawadb";
		/* サーバ名 */
		String servername = "localhost";
		Connection conn = null;
		/* SQL文 */
		String sql = "SELECT * FROM book";
		PreparedStatement ps = null;
        ResultSet rs = null;
        List bookList = new ArrayList();
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
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getString(1));
                book.setGenre(rs.getString(2));
                book.setTitle(rs.getString(3));
                book.setPrice(rs.getInt(4));
                book.setAuthor(rs.getString(5));
                book.setPublisher(rs.getString(6));
                book.setEntry_date(rs.getString(7));
                book.setUpdate_date(rs.getString(8));
                bookList.add(book);
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
		return bookList;
	}
}


