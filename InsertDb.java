import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertDB {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Date date = new Date();
		DBConnectDao2 dbconnectdao = new DBConnectDao2();
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

	// 入力値1チェック
	static boolean chknum1(String numchk) {
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
