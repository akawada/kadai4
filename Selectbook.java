public class Selectbook {
	public static void main(String[] args) {
		DBConnectDao dbconnectdao = new DBConnectDao();
		try{
			dbconnectdao.conectOracle();
		}
		catch (Exception e){			
			/* �G���[���b�Z�[�W */
			System.out.println("�ڑ��Ɏ��s���܂���");
		}
	}
}
  
