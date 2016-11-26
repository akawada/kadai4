import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ExecuteSql {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input_value = null;
		while (true) {
			System.out.println("処理を選択してください");
			System.out.println("1.SELECT");
			System.out.println("2.INSERT");
			System.out.println("3.UPDATE");
			System.out.println("4.DELETE");
			input_value = scan.next();
			if (chknum1(input_value)) {
				break;
			} else {
				System.err.println("不正な値です。もう一度入力してください。");
			}
		}
		if (input_value.equals("1")) {
			SelectDb();
		}
		if (input_value.equals("2")) {
			InsertDb();
		}
		scan.close();
	}

	public static void InsertDb() {
		Scanner scan = new Scanner(System.in);
		Date date = new Date();
		DBConnectDao4 dbconnectdao = new DBConnectDao4();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
		String strDate = null;
		String strSelTable = null;
		String strBid = null;
		String strLid = null;
		String strLbid = null;
		String strGenre = null;
		String strLibName = null;
		String strTitle = null;
		String strPrice = null;
		String strAuthor = null;
		String strPublisher = null;
		String sql = null;
		// 追加するテーブルの選択
		while (true) {
			System.out.println("処理を選択してください");
			System.out.println("1.本データを追加");
			System.out.println("2.図書館デーを追加");
			System.out.println("3.紐付きデータを追加");
			strSelTable = scan.next();
			if (chknum1(strSelTable)) {
				strDate = sdf1.format(date);
				System.out.println(strDate);
				break;
			} else {
				System.err.println("不正な値です。もう一度入力してください。");
			}
		}
		// 本テーブルの場合
		if (strSelTable.equals("1")) {
			while (true) {
				System.out.println("IDを入力してください");
				System.out.println("例：BXXX");
				strBid = scan.next();
				if (chkbid(strBid)) {
					break;
				} else {
					System.err.println("不正な値です。もう一度入力してください。");
				}
			}
			while (true) {
				System.out.println("ジャンルを入力してください");
				strGenre = scan.next();
				if (chkbyte(strGenre)) {
					break;
				} else {
					System.err.println("不正な値です。もう一度入力してください。");
				}
			}
			while (true) {
				System.out.println("タイトルを入力してください");
				strTitle = scan.next();
				if (chkbyte(strTitle)) {
					break;
				} else {
					System.err.println("不正な値です。もう一度入力してください。");
				}
			}
			while (true) {
				System.out.println("値段を入力してください");
				strPrice = scan.next();
				if (chkprice(strPrice)) {
					break;
				} else {
					System.err.println("不正な値です。もう一度入力してください。");
				}
			}
			while (true) {
				System.out.println("作者を入力してください");
				strAuthor = scan.next();
				if (chkbyte(strAuthor)) {
					break;
				} else {
					System.err.println("不正な値です。もう一度入力してください。");
				}
			}
			while (true) {
				System.out.println("出版社を入力してください");
				strPublisher = scan.next();
				if (chkbyte(strPublisher)) {
					break;
				} else {
					System.err.println("不正な値です。もう一度入力してください。");
				}
			}
			scan.close();
			// SQLの作成
			sql = "INSERT INTO book ";
			sql += "( id, genre, title, price, author, publisher, entry_date, update_date )";
			sql += " VALUES( ";
			sql += "'";
			sql += strBid;
			sql += "', ";
			sql += "'";
			sql += strGenre;
			sql += "', ";
			sql += "'";
			sql += strTitle;
			sql += "', ";
			sql += strPrice;
			sql += ", ";
			sql += "'";
			sql += strAuthor;
			sql += "', ";
			sql += "'";
			sql += strPublisher;
			sql += "', ";
			sql += "'";
			sql += strDate;
			sql += "', ";
			sql += "'";
			sql += strDate;
			sql += "' ) ";
		}
		// 図書館テーブルの場合
		else if (strSelTable.equals("2")) {
			while (true) {
				System.out.println("IDを入力してください");
				System.out.println("例：LXXX");
				strLid = scan.next();
				if (chklid(strLid)) {
					break;
				} else {
					System.err.println("不正な値です。もう一度入力してください。");
				}
			}
			while (true) {
				System.out.println("図書館名を入力してください");
				strLibName = scan.next();
				if (chkbyte(strLibName)) {
					break;
				} else {
					System.err.println("不正な値です。もう一度入力してください。");
				}
			}
			scan.close();
			// SQLの作成
			sql = "INSERT INTO library ";
			sql += "( id, libname, entry_date, update_date )";
			sql += " VALUES( ";
			sql += "'";
			sql += strLid;
			sql += "', ";
			sql += "'";
			sql += strLibName;
			sql += "', ";
			sql += "'";
			sql += strDate;
			sql += "', ";
			sql += "'";
			sql += strDate;
			sql += "' ) ";
		}
		// 紐付きテーブルの場合
		else {
			while (true) {
				System.out.println("IDを入力してください");
				System.out.println("例：LBXX");
				strLbid = scan.next();
				if (chklbid(strLbid)) {
					break;
				} else {
					System.err.println("不正な値です。もう一度入力してください。");
				}
			}
			while (true) {
				System.out.println("図書館IDを入力してください");
				System.out.println("例：LXXX");
				strLid = scan.next();
				if (chklid(strLid)) {
					break;
				} else {
					System.err.println("不正な値です。もう一度入力してください。");
				}
			}
			while (true) {
				System.out.println("本IDを入力してください");
				System.out.println("例：BXXX");
				strBid = scan.next();
				if (chkbid(strBid)) {
					break;
				} else {
					System.err.println("不正な値です。もう一度入力してください。");
				}
			}
			scan.close();
			// SQLの作成
			sql = "INSERT INTO lblink ";
			sql += "( id, libid, bid, entry_date, update_date )";
			sql += " VALUES( ";
			sql += "'";
			sql += strLbid;
			sql += "', ";
			sql += "'";
			sql += strLid;
			sql += "', ";
			sql += "'";
			sql += strBid;
			sql += "', ";
			sql += "'";
			sql += strDate;
			sql += "', ";
			sql += "'";
			sql += strDate;
			sql += "' ) ";
		}
		System.out.println(sql);
		try {
			dbconnectdao.executeInsert(sql);
			System.out.println("処理が完了しました。");
		} catch (Exception e) {
			/* エラーメッセージ */
			System.err.println("処理に失敗しました");
		}
	}

	public static void SelectDb() {
		Scanner scan = new Scanner(System.in);
		DBConnectDao4 dbconnectdao = new DBConnectDao4();
		List selList = new ArrayList();
		String inputvalue = null;
		String inputSelBookValue = null;
		String inputSelLibraryValue = null;
		String sql = null;
		String whereFlg = "0";
		String sqlWhere = null;
		String inputDate = null;
		String inputSelTable = null;
		String inputBid = null;
		String inputLid = null;
		String inputLbid = null;
		String inputGenre = null;
		String inputLibName = null;
		String inputTitle = null;
		String inputPrice = null;
		String inputAuthor = null;
		String inputPublisher = null;
		String selDb = null;

		while (true) {
			System.out.println("検索条件を選択してください");
			System.out.println("1.本データを選択");
			System.out.println("2.図書館データを選択");
			System.out.println("3.図書館毎の本の数を選択");
			inputvalue = scan.next();
			if (chknum2(inputvalue)) {
				break;
			} else {
				System.err.println("不正な数値です。もう一度入力してください。");
			}
		}
		// 本テーブルの場合
		if (inputvalue.equals("1")) {
			selDb = "3";
			while (true) {
				System.out.println("検索条件を選択してください");
				System.out.println("1.ID");
				System.out.println("2.ジャンル");
				System.out.println("3.タイトル");
				System.out.println("4.値段");
				System.out.println("5.作者");
				System.out.println("6.出版社");
				System.out.println("0.検索を開始します");
				if (inputBid != null) {
					System.out.println("ID:" + inputBid);
					whereFlg = "1";
				}
				if (inputGenre != null) {
					System.out.println("ジャンル:" + inputGenre);
					whereFlg = "1";
				}
				if (inputTitle != null) {
					System.out.println("タイトル:" + inputTitle);
					whereFlg = "1";
				}
				if (inputPrice != null) {
					System.out.println("値段:" + inputPrice);
					whereFlg = "1";
				}
				if (inputAuthor != null) {
					System.out.println("作者:" + inputAuthor);
					whereFlg = "1";
				}
				if (inputPublisher != null) {
					System.out.println("出版社:" + inputPublisher);
					whereFlg = "1";
				}
				inputSelBookValue = scan.next();
				if (inputSelBookValue.equals("1")) {
					System.out.println("IDを入力してください");
					System.out.println("例：BXXX");
					inputBid = scan.next();
					continue;
				} else if (inputSelBookValue.equals("2")) {
					System.out.println("ジャンルを入力してください");
					inputGenre = scan.next();
					continue;
				} else if (inputSelBookValue.equals("3")) {
					System.out.println("タイトルを入力してください");
					inputTitle = scan.next();
					continue;
				} else if (inputSelBookValue.equals("4")) {
					System.out.println("値段を入力してください");
					inputPrice = scan.next();
					continue;
				} else if (inputSelBookValue.equals("5")) {
					System.out.println("作者を入力してください");
					inputAuthor = scan.next();
					continue;
				} else if (inputSelBookValue.equals("6")) {
					System.out.println("出版社を入力してください");
					inputPublisher = scan.next();
					continue;
				} else if (inputSelBookValue.equals("0")) {
					break;
				} else {
					System.err.println("不正な数値です。もう一度入力してください。");
				}
			}
			if (whereFlg.equals("1")) {
				sqlWhere = " WHERE";
				if (inputBid != null) {
					sqlWhere += " book.id = ";
					sqlWhere += "'";
					sqlWhere += inputBid;
					sqlWhere += "'";
					whereFlg = "2";
				}
				if (inputGenre != null) {
					if (whereFlg.equals("2")) {
						sqlWhere += " AND";
					}
					sqlWhere += " book.genre = ";
					sqlWhere += "'";
					sqlWhere += inputGenre;
					sqlWhere += "'";
					whereFlg = "2";
				}
				if (inputTitle != null) {
					if (whereFlg.equals("2")) {
						sqlWhere += " AND";
					}
					sqlWhere += " book.title = ";
					sqlWhere += "'";
					sqlWhere += inputTitle;
					sqlWhere += "'";
					whereFlg = "2";
				}
				if (inputPrice != null) {
					if (whereFlg.equals("2")) {
						sqlWhere += " AND";
					}
					sqlWhere += " book.price = " + inputPrice;
					whereFlg = "2";
				}
				if (inputAuthor != null) {
					if (whereFlg.equals("2")) {
						sqlWhere += " AND";
					}
					sqlWhere += " book.author = ";
					sqlWhere += "'";
					sqlWhere += inputAuthor;
					sqlWhere += "'";
					whereFlg = "2";
				}
				if (inputPublisher != null) {
					if (whereFlg.equals("2")) {
						sqlWhere += " AND";
					}
					sqlWhere += " book.publisher = ";
					sqlWhere += "'";
					sqlWhere += inputPublisher;
					sqlWhere += "'";
					whereFlg = "2";
				}
			}
			//System.out.println(sqlWhere);
			sql = "SELECT *";
			sql += " FROM lblink";
			sql += " INNER JOIN book ON lblink.bid = book.id";
			sql += " INNER JOIN library ON lblink.libid = library.id";
			if (whereFlg.equals("2")){
				sql += sqlWhere;
			}
			//System.out.println(sql);
		}

		// 図書館テーブルの場合
		else if (inputvalue.equals("2")) {
			selDb = "2";
			while (true) {
				System.out.println("検索条件を選択してください");
				System.out.println("1.ID");
				System.out.println("2.図書館名");
				System.out.println("0.検索を開始します");
				if (inputLbid != null) {
					System.out.println("ID:" + inputLbid);
					whereFlg = "1";
				}
				if (inputLibName != null) {
					System.out.println("図書館名:" + inputLibName);
					whereFlg = "1";
				}
				inputSelLibraryValue = scan.next();
				if (inputSelLibraryValue.equals("1")) {
					System.out.println("IDを入力してください");
					System.out.println("例：LXXX");
					inputLbid = scan.next();
					continue;
				} else if (inputSelLibraryValue.equals("2")) {
					System.out.println("図書館名を入力してください");
					inputLibName = scan.next();
					continue;
				} else if (inputSelLibraryValue.equals("0")) {
					break;
				} else {
					System.err.println("不正な数値です。もう一度入力してください。");
				}
			}
			if (whereFlg.equals("1")) {
				sqlWhere = " WHERE";
				if (inputLbid != null) {
					sqlWhere += " library.id = ";
					sqlWhere += "'";
					sqlWhere += inputLbid;
					sqlWhere += "'";
					whereFlg = "2";
				}
				if (inputLibName != null) {
					if (whereFlg.equals("2")) {
						sqlWhere += " AND";
					}
					sqlWhere += " library.libname = ";
					sqlWhere += "'";
					sqlWhere += inputLibName;
					sqlWhere += "'";
				}
			}
			System.out.println(sqlWhere);
			sql = "SELECT *";
			sql += " FROM library";
			if (whereFlg.equals("2")){
				sql += sqlWhere;
			}
			System.out.println(sql);
			scan.close();
		}
        else{
			selDb = "4";
        	sql = "SELECT library.libname ,count(*) ";
        	sql += "FROM lblink, library ";
        	sql += "WHERE lblink.libid = library.id ";
        	sql += "group by library.libname";
        }
		try {
	    	selList = dbconnectdao.conectOracle(selDb, sql);
            if (selDb.equals("1")){
	            Book book2;
	            for (int i = 0; i < selList.size(); i++) {
	            	book2 = (Book) selList.get(i);
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
            else if (selDb.equals("2")){
	            Library librayr2;
	            for (int i = 0; i < selList.size(); i++) {
	            	librayr2 = (Library) selList.get(i);
	                System.out.print(librayr2.getId() + "/");
	                System.out.print(librayr2.getLibname() + "/");
	                System.out.print(librayr2.getEntry_date() + "/");
	                System.out.print(librayr2.getUpdate_date() + "\n");
	            }
            }
            else if (selDb.equals("3")){
	            BookLibName booklibname2;
	            for (int i = 0; i < selList.size(); i++) {
	            	booklibname2 = (BookLibName) selList.get(i);
	                System.out.print(booklibname2.getLibname() + "/");
	                System.out.print(booklibname2.getTitle() + "/");
	                System.out.print(booklibname2.getAuthor()  + "\n");
	            }
            }
            else{
	            Lblink Lblink2;
	            for (int i = 0; i < selList.size(); i++) {
	            	Lblink2 = (Lblink) selList.get(i);
	                System.out.print(Lblink2.getLibname() + "/");
	                System.out.print(Lblink2.getCount() + "冊\n");
	            }
            }

			System.out.println("処理が完了しました。");
		} catch (Exception e) {
			/* エラーメッセージ */
			System.err.println("処理に失敗しました");
		}
	}

	// 入力値1チェック
	static boolean chknum1(String numchk) {
		try {
			Integer.parseInt(numchk);
			if (1 <= Integer.parseInt(numchk) && Integer.parseInt(numchk) <= 4) {
				return true;
			} else {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
	}

	// 入力値2チェック
	static boolean chknum2(String numchk) {
		try {
			Integer.parseInt(numchk);
			if (1 <= Integer.parseInt(numchk) && Integer.parseInt(numchk) < 4) {
				return true;
			} else {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
	}

	// 金額チェック
	static boolean chkprice(String numchk) {
		try {
			Integer.parseInt(numchk);
			if (0 <= Integer.parseInt(numchk) && Integer.parseInt(numchk) < 100000) {
				return true;
			} else {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
	}

	// 本IDチェック
	static boolean chkbid(String bid) {
		if (bid.length() == 4) {
			if (bid.substring(0, 1).equals("B")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	// 図書館IDチェック
	static boolean chklid(String lid) {
		if (lid.length() == 4) {
			if (lid.substring(0, 1).equals("L")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	// 紐付きIDチェック
	static boolean chklbid(String lbid) {
		if (lbid.length() == 4) {
			if (lbid.substring(0, 2).equals("LB")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	// バイト数チェック
	static boolean chkbyte(String lbid) {
		if (lbid.getBytes().length < 100) {
			return true;
		} else {
			return false;
		}
	}

}
