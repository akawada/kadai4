public class Selectbook {
	public static void main(String[] args) {
		DBConnectDao dbconnectdao = new DBConnectDao();
		try{
			dbconnectdao.conectOracle();
		}
		catch (Exception e){			
			/* エラーメッセージ */
			System.out.println("接続に失敗しました");
		}
	}
}
  
