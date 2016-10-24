import java.util.Scanner;

public class Selectdb {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DBConnectDao2 dbconnectdao = new DBConnectDao2();
		String strin = null;
		while (true) {
			System.out.println("処理を選択してください");
			System.out.println("1.本データを選択");
			System.out.println("2.図書館データを選択");
			System.out.println("3.図書館毎の本の数を選択");
			strin = scan.next();
			if (chknum(strin)){
				try{
					dbconnectdao.conectOracle(strin);
				}
				catch (Exception e){			
					/* エラーメッセージ */
					System.out.println("接続に失敗しました");
				}
				break;
			}
			else{
				System.err.println("不正な数値です。もう一度入力してください。");
			}
		}
		scan.close();
	}
	// 数値チェック
	static boolean chknum(String numchk) {
		try {
			Integer.parseInt(numchk);
			if (0 <= Integer.parseInt(numchk) && Integer.parseInt(numchk) <4 ){
				return true;
			}
			else{
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
  
