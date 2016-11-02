import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Selectdb {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DBConnectDao2 dbconnectdao = new DBConnectDao2();
        List SelList = new ArrayList();
		String Strin = null;
		String Sql = null;
		while (true) {
			System.out.println("処理を選択してください");
			System.out.println("1.本データを選択");
			System.out.println("2.図書館データを選択");
			System.out.println("3.図書館毎の本の数を選択");
			Strin = scan.next();
			if (chknum(Strin)){
				try{
		            if (Strin.equals("1")){
		            	Sql = "SELECT * FROM book";
		            }
		            else if (Strin.equals("2")){
		            	Sql = "SELECT * FROM library";
		            }
		            else{
		            	Sql = "SELECT library.libname ,count(*) ";
		            	Sql += "FROM lblink, library ";
		            	Sql += "WHERE lblink.libid = library.id ";
		            	Sql += "group by library.libname";
		            }
		            	
		        	SelList = dbconnectdao.conectOracle(Strin, Sql);
		            // 取得した結果を全件出力する
		            if (Strin.equals("1")){
			            Book book2;
			            for (int i = 0; i < SelList.size(); i++) {
			            	book2 = (Book) SelList.get(i);
			                System.out.print(book2.getId() + "/");
			                System.out.print(book2.getGenre() + "/");
			                System.out.print(book2.getTitle() + "/");
			                System.out.print(book2.getPrice() + "/");
			                System.out.print(book2.getAuthor() + "/");
			                System.out.print(book2.getPublisher() + "/");
			                System.out.print(book2.getEntry_date() + "/");
			                System.out.print(book2.getUpdate_date() + "\n");
			            }
		            }
		            else if (Strin.equals("2")){
			            Library librayr2;
			            for (int i = 0; i < SelList.size(); i++) {
			            	librayr2 = (Library) SelList.get(i);
			                System.out.print(librayr2.getId() + "/");
			                System.out.print(librayr2.getLibname() + "/");
			                System.out.print(librayr2.getEntry_date() + "/");
			                System.out.print(librayr2.getUpdate_date() + "\n");
			            }
		            }
		            else{
			            Lblink Lblink2;
			            for (int i = 0; i < SelList.size(); i++) {
			            	Lblink2 = (Lblink) SelList.get(i);
			                System.out.print(Lblink2.getLibname() + "/");
			                System.out.print(Lblink2.getCount() + "冊\n");
			            }
		            	
		            }
				}
				catch (Exception e){			
					/* エラーメッセージ */
					System.out.println("処理に失敗しました");
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
			if (1 <= Integer.parseInt(numchk) && Integer.parseInt(numchk) <4 ){
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
  
