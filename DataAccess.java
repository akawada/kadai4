import java.sql.Connection;
import java.sql.DriverManager;

public class DataAccess {
	
	public static void main(String[] args) {
		try{
			conectOracle();
			/* �������b�Z�[�W */
			System.out.println("�ڑ��ɐ������܂���");
		}
		catch (Exception e){			
			/* �G���[���b�Z�[�W */
			System.out.println("�ڑ��Ɏ��s���܂���");
		}
	}

	public static void conectOracle() throws Exception{
		/* ���[�U�� */
		String user = "system";
		/* �p�X���[�h */
		String pass = "kawadb";
		/* �T�[�o�� */
		String servername = "localhost";
		Connection conn = null;
 
	  	try{
			/* �h���C�o�N���X�̃��[�h */
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			/* Connection�̍쐬 */
			conn = DriverManager.getConnection 
			("jdbc:oracle:thin:@" + servername + ":1521:" ,user,pass);
		}
	  	catch ( Exception e){
			throw e;	
		}
		finally{			
			/* �N���[�Y���� */
			if(conn != null){
			  conn.close();
			  conn = null;
			  System.out.println("�ؒf���܂���");
			}
	    }
	}
}
  
