import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertDb {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Date date = new Date();
		DBConnectDao3 dbconnectdao = new DBConnectDao3();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
		String StrDate = null;
		String Strin = null;
		String Strin2 = null;
		String Strin3 = null;
		String Strin4 = null;
		String Strin5 = null;
		String Strin6 = null;
		String Strin7 = null;
		String Sql = null;
		// 追加するテーブルの選択
		while (true) {
			System.out.println("処理を選択してください");
			System.out.println("1.本データを追加");
			System.out.println("2.図書館デーを追加");
			System.out.println("3.紐付きデータを追加");
			Strin = scan.next();
			if (chknum1(Strin)) {
				StrDate = sdf1.format(date);
				System.out.println(StrDate);
				break;
			} else {
				System.err.println("不正な値です。もう一度入力してください。");
			}
		}
		// 本テーブルの場合
		if (Strin.equals("1")) {
			while (true) {
				System.out.println("IDを入力してください");
				System.out.println("例：BXXX");
				Strin2 = scan.next();
				if (chkbid(Strin2)) {
					break;
				} else {
					System.err.println("不正な値です。もう一度入力してください。");
				}
			}
			while (true) {
				System.out.println("ジャンルを入力してください");
				Strin3 = scan.next();
				if (chkbyte(Strin3)) {
					break;
				} else {
					System.err.println("不正な値です。もう一度入力してください。");
				}
			}
			while (true) {
				System.out.println("タイトルを入力してください");
				Strin4 = scan.next();
				if (chkbyte(Strin4)) {
					break;
				} else {
					System.err.println("不正な値です。もう一度入力してください。");
				}
			}
			while (true) {
				System.out.println("値段を入力してください");
				Strin5 = scan.next();
				if (chkprice(Strin5)) {
					break;
				} else {
					System.err.println("不正な値です。もう一度入力してください。");
				}
			}
			while (true) {
				System.out.println("作者を入力してください");
				Strin6 = scan.next();
				if (chkbyte(Strin6)) {
					break;
				} else {
					System.err.println("不正な値です。もう一度入力してください。");
				}
			}
			while (true) {
				System.out.println("出版社を入力してください");
				Strin7 = scan.next();
				if (chkbyte(Strin7)) {
					break;
				} else {
					System.err.println("不正な値です。もう一度入力してください。");
				}
			}
			scan.close();
			// SQLの作成
			Sql = "INSERT INTO book ";
			Sql += "( id, genre, title, price, author, publisher, entry_date, update_date )";
			Sql += " VALUES( ";
			Sql += "'";
			Sql += Strin2;
			Sql += "', ";
			Sql += "'";
			Sql += Strin3;
			Sql += "', ";
			Sql += "'";
			Sql += Strin4;
			Sql += "', ";
			Sql += Strin5;
			Sql += ", ";
			Sql += "'";
			Sql += Strin6;
			Sql += "', ";
			Sql += "'";
			Sql += Strin7;
			Sql += "', ";
			Sql += "'";
			Sql += StrDate;
			Sql += "', ";
			Sql += "'";
			Sql += StrDate;
			Sql += "' ) ";
		}
		// 図書館テーブルの場合
		else if (Strin.equals("2")) {
			while (true) {
				System.out.println("IDを入力してください");
				System.out.println("例：LXXX");
				Strin2 = scan.next();
				if (chklid(Strin2)) {
					break;
				} else {
					System.err.println("不正な値です。もう一度入力してください。");
				}
			}
			while (true) {
				System.out.println("図書館名を入力してください");
				Strin3 = scan.next();
				if (chkbyte(Strin3)) {
					break;
				} else {
					System.err.println("不正な値です。もう一度入力してください。");
				}
			}
			scan.close();
			// SQLの作成
			Sql = "INSERT INTO library ";
			Sql += "( id, libname, entry_date, update_date )";
			Sql += " VALUES( ";
			Sql += "'";
			Sql += Strin2;
			Sql += "', ";
			Sql += "'";
			Sql += Strin3;
			Sql += "', ";
			Sql += "'";
			Sql += StrDate;
			Sql += "', ";
			Sql += "'";
			Sql += StrDate;
			Sql += "' ) ";
		}
		// 紐付きテーブルの場合
		else {
			while (true) {
				System.out.println("IDを入力してください");
				System.out.println("例：LBXX");
				Strin2 = scan.next();
				if (chklbid(Strin2)) {
					break;
				} else {
					System.err.println("不正な値です。もう一度入力してください。");
				}
			}
			while (true) {
				System.out.println("図書館IDを入力してください");
				System.out.println("例：LXXX");
				Strin3 = scan.next();
				if (chklid(Strin3)) {
					break;
				} else {
					System.err.println("不正な値です。もう一度入力してください。");
				}
			}
			while (true) {
				System.out.println("本IDを入力してください");
				System.out.println("例：BXXX");
				Strin4 = scan.next();
				if (chkbid(Strin4)) {
					break;
				} else {
					System.err.println("不正な値です。もう一度入力してください。");
				}
			}
			scan.close();
			// SQLの作成
			Sql = "INSERT INTO lblink ";
			Sql += "( id, libid, bid, entry_date, update_date )";
			Sql += " VALUES( ";
			Sql += "'";
			Sql += Strin2;
			Sql += "', ";
			Sql += "'";
			Sql += Strin3;
			Sql += "', ";
			Sql += "'";
			Sql += Strin4;
			Sql += "', ";
			Sql += "'";
			Sql += StrDate;
			Sql += "', ";
			Sql += "'";
			Sql += StrDate;
			Sql += "' ) ";
		}
		System.out.println(Sql);
		try {
			dbconnectdao.conectOracle(Sql);
			System.out.println("処理が完了しました。");
		} catch (Exception e) {
			/* エラーメッセージ */
			System.out.println("処理に失敗しました");
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
