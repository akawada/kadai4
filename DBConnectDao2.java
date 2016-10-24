import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnectDao2 {
	public void conectOracle(String strin) throws Exception{
		/* ���[�U�� */
		String user = "system";
		/* �p�X���[�h */
		String pass = "kawadb";
		/* �T�[�o�� */
		String servername = "localhost";
		Connection conn = null;
		/* SQL�� */
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
			/* �h���C�o�N���X�̃��[�h */
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			/* Connection�̍쐬 */
			conn = DriverManager.getConnection 
			("jdbc:oracle:thin:@" + servername + ":1521:" ,user,pass);
			/* SQL�̎w�� */
            ps = conn.prepareStatement(sql);
			/* SELECT���s */
            rs = ps.executeQuery();
            //�擾�������ʂ�S���o�͂���
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
			/* �N���[�Y���� */
			if(conn != null){
			  conn.close();
			  conn = null;
			  //System.out.println("�ؒf���܂���");
			}
	    }
	}
}

