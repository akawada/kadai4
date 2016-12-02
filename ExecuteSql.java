import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		if (input_value.equals("3")) {
			UpdateDb();
		}
		if (input_value.equals("4")) {
			DeleteDb();
		}
		scan.close();
	}

	public static void InsertDb() {
		Scanner scan = new Scanner(System.in);
		Date date = new Date();
		DBConnectDao5 dbconnectdao = new DBConnectDao5();
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
			System.out.println("対象を選択してください");
			System.out.println("1.本データを選択");
			System.out.println("2.図書館デーを選択");
			System.out.println("3.紐付きデータを選択");
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
		// System.out.println(sql);
		try {
			dbconnectdao.executeSql(sql);
			System.out.println("処理が完了しました。");
		} catch (Exception e) {
			/* エラーメッセージ */
			System.err.println("処理に失敗しました");
		}
	}

	public static void SelectDb() {
		Scanner scan = new Scanner(System.in);
		DBConnectDao5 dbconnectdao = new DBConnectDao5();
		List selList = new ArrayList();
		String inputvalue = null;
		String inputSelBookValue = null;
		String inputSelLibraryValue = null;
		String sql = null;
		String whereFlg = "0";
		String sqlWhere = null;
		String inputBid = null;
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
			// System.out.println(sqlWhere);
			sql = "SELECT *";
			sql += " FROM lblink";
			sql += " INNER JOIN book ON lblink.bid = book.id";
			sql += " INNER JOIN library ON lblink.libid = library.id";
			if (whereFlg.equals("2")) {
				sql += sqlWhere;
			}
			// System.out.println(sql);
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
					whereFlg = "2";
				}
			}
			// System.out.println(sqlWhere);
			sql = "SELECT *";
			sql += " FROM library";
			if (whereFlg.equals("2")) {
				sql += sqlWhere;
			}
			System.out.println(sql);
			scan.close();
		} else {
			selDb = "4";
			sql = "SELECT library.libname ,count(*) ";
			sql += "FROM lblink, library ";
			sql += "WHERE lblink.libid = library.id ";
			sql += "group by library.libname";
		}
		try {
			selList = dbconnectdao.SelectSql(selDb, sql);
			if (selDb.equals("1")) {
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
			} else if (selDb.equals("2")) {
				Library librayr2;
				for (int i = 0; i < selList.size(); i++) {
					librayr2 = (Library) selList.get(i);
					System.out.print(librayr2.getId() + "/");
					System.out.print(librayr2.getLibname() + "/");
					System.out.print(librayr2.getEntry_date() + "/");
					System.out.print(librayr2.getUpdate_date() + "\n");
				}
			} else if (selDb.equals("3")) {
				BookLibName booklibname2;
				for (int i = 0; i < selList.size(); i++) {
					booklibname2 = (BookLibName) selList.get(i);
					System.out.print(booklibname2.getLibname() + "/");
					System.out.print(booklibname2.getTitle() + "/");
					System.out.print(booklibname2.getAuthor() + "\n");
				}
			} else {
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

	public static void UpdateDb() {
		Scanner scan = new Scanner(System.in);
		DBConnectDao5 dbconnectdao = new DBConnectDao5();
		String inputvalue = null;
		String inputUpdBookValue = null;
		String inputWhereBookValue = null;
		String inputUpdLibraryValue = null;
		String inputWhereLibraryValue = null;
		String inputUpdLblinkValue = null;
		String inputWhereLblinkValue = null;
		String sql = null;
		String whereFlg = "0";
		String updFlg = "0";
		String sqlWhere = null;
		String sqlUpd = null;
		String inputUpdBid = null;
		String inputUpdLid = null;
		String inputUpdLbid = null;
		String inputUpdGenre = null;
		String inputUpdLibName = null;
		String inputUpdTitle = null;
		String inputUpdPrice = null;
		String inputUpdAuthor = null;
		String inputUpdPublisher = null;
		String inputWhereBid = null;
		String inputWhereLid = null;
		String inputWhereLbid = null;
		String inputWhereGenre = null;
		String inputWhereLibName = null;
		String inputWhereTitle = null;
		String inputWherePrice = null;
		String inputWhereAuthor = null;
		String inputWherePublisher = null;
		Date date = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
		String strDate = sdf1.format(date);

		while (true) {
			System.out.println("対象を選択してください");
			System.out.println("1.本データを選択");
			System.out.println("2.図書館データを選択");
			System.out.println("3.紐付きデータを選択");
			inputvalue = scan.next();
			if (chknum2(inputvalue)) {
				break;
			} else {
				System.err.println("不正な数値です。もう一度入力してください。");
			}
		}
		// 本テーブルの場合
		if (inputvalue.equals("1")) {
			while (true) {
				System.out.println("更新する項目を選択してください");
				System.out.println("1.ID");
				System.out.println("2.ジャンル");
				System.out.println("3.タイトル");
				System.out.println("4.値段");
				System.out.println("5.作者");
				System.out.println("6.出版社");
				System.out.println("0.更新条件を設定します");
				if (inputUpdBid != null) {
					System.out.println("ID:" + inputUpdBid);
					updFlg = "1";
				}
				if (inputUpdGenre != null) {
					System.out.println("ジャンル:" + inputUpdGenre);
					updFlg = "1";
				}
				if (inputUpdTitle != null) {
					System.out.println("タイトル:" + inputUpdTitle);
					updFlg = "1";
				}
				if (inputUpdPrice != null) {
					System.out.println("値段:" + inputUpdPrice);
					updFlg = "1";
				}
				if (inputUpdAuthor != null) {
					System.out.println("作者:" + inputUpdAuthor);
					updFlg = "1";
				}
				if (inputUpdPublisher != null) {
					System.out.println("出版社:" + inputUpdPublisher);
					updFlg = "1";
				}
				inputUpdBookValue = scan.next();
				if (inputUpdBookValue.equals("1")) {
					System.out.println("IDを入力してください");
					System.out.println("例：BXXX");
					inputUpdBid = scan.next();
					if (!chkbid(inputUpdBid)) {
						inputUpdBid = null;
						System.err.println("不正な値です。もう一度入力してください。");
					}
					continue;
				} else if (inputUpdBookValue.equals("2")) {
					System.out.println("ジャンルを入力してください");
					inputUpdGenre = scan.next();
					continue;
				} else if (inputUpdBookValue.equals("3")) {
					System.out.println("タイトルを入力してください");
					inputUpdTitle = scan.next();
					continue;
				} else if (inputUpdBookValue.equals("4")) {
					System.out.println("値段を入力してください");
					inputUpdPrice = scan.next();
					continue;
				} else if (inputUpdBookValue.equals("5")) {
					System.out.println("作者を入力してください");
					inputUpdAuthor = scan.next();
					continue;
				} else if (inputUpdBookValue.equals("6")) {
					System.out.println("出版社を入力してください");
					inputUpdPublisher = scan.next();
					continue;
				} else if (inputUpdBookValue.equals("0")) {
					if (updFlg.equals("1")) {
						break;
					} else {
						System.err.println("更新する項目がありません");
					}
				} else {
					System.err.println("不正な数値です。もう一度入力してください");
				}
			}
			if (updFlg.equals("1")) {
				while (true) {
					System.out.println("更新条件を選択してください");
					System.out.println("1.ID");
					System.out.println("2.ジャンル");
					System.out.println("3.タイトル");
					System.out.println("4.値段");
					System.out.println("5.作者");
					System.out.println("6.出版社");
					System.out.println("0.更新処理を開始します");
					if (inputWhereBid != null) {
						System.out.println("ID:" + inputWhereBid);
						whereFlg = "1";
					}
					if (inputWhereGenre != null) {
						System.out.println("ジャンル:" + inputWhereGenre);
						whereFlg = "1";
					}
					if (inputWhereTitle != null) {
						System.out.println("タイトル:" + inputWhereTitle);
						whereFlg = "1";
					}
					if (inputWherePrice != null) {
						System.out.println("値段:" + inputWherePrice);
						whereFlg = "1";
					}
					if (inputWhereAuthor != null) {
						System.out.println("作者:" + inputWhereAuthor);
						whereFlg = "1";
					}
					if (inputWherePublisher != null) {
						System.out.println("出版社:" + inputWherePublisher);
						whereFlg = "1";
					}
					inputWhereBookValue = scan.next();
					if (inputWhereBookValue.equals("1")) {
						System.out.println("IDを入力してください");
						System.out.println("例：BXXX");
						inputWhereBid = scan.next();
						continue;
					} else if (inputWhereBookValue.equals("2")) {
						System.out.println("ジャンルを入力してください");
						inputWhereGenre = scan.next();
						continue;
					} else if (inputWhereBookValue.equals("3")) {
						System.out.println("タイトルを入力してください");
						inputWhereTitle = scan.next();
						continue;
					} else if (inputWhereBookValue.equals("4")) {
						System.out.println("値段を入力してください");
						inputWherePrice = scan.next();
						continue;
					} else if (inputWhereBookValue.equals("5")) {
						System.out.println("作者を入力してください");
						inputWhereAuthor = scan.next();
						continue;
					} else if (inputWhereBookValue.equals("6")) {
						System.out.println("出版社を入力してください");
						inputWherePublisher = scan.next();
						continue;
					} else if (inputWhereBookValue.equals("0")) {
						break;
					} else {
						System.err.println("不正な数値です。もう一度入力してください");
					}
				}
				// Set句の作成
				sqlUpd = " SET";
				if (inputUpdBid != null) {
					sqlUpd += " book.id = ";
					sqlUpd += "'";
					sqlUpd += inputUpdBid;
					sqlUpd += "'";
					updFlg = "2";
				}
				if (inputUpdGenre != null) {
					if (updFlg.equals("2")) {
						sqlUpd += ",";
					}
					sqlUpd += " book.genre = ";
					sqlUpd += "'";
					sqlUpd += inputUpdGenre;
					sqlUpd += "'";
					updFlg = "2";
				}
				if (inputUpdTitle != null) {
					if (updFlg.equals("2")) {
						sqlUpd += " AND";
					}
					sqlUpd += " book.title = ";
					sqlUpd += "'";
					sqlUpd += inputUpdTitle;
					sqlUpd += "'";
					updFlg = "2";
				}
				if (inputUpdPrice != null) {
					if (updFlg.equals("2")) {
						sqlUpd += " AND";
					}
					sqlUpd += " book.price = " + inputUpdPrice;
					updFlg = "2";
				}
				if (inputUpdAuthor != null) {
					if (updFlg.equals("2")) {
						sqlUpd += " AND";
					}
					sqlUpd += " book.author = ";
					sqlUpd += "'";
					sqlUpd += inputUpdAuthor;
					sqlUpd += "'";
					updFlg = "2";
				}
				if (inputUpdPublisher != null) {
					if (updFlg.equals("2")) {
						sqlUpd += " AND";
					}
					sqlUpd += " book.publisher = ";
					sqlUpd += "'";
					sqlUpd += inputUpdPublisher;
					sqlUpd += "'";
					updFlg = "2";
				}
				sqlUpd += ",";
				sqlUpd += " book.update_date = ";
				sqlUpd += "'";
				sqlUpd += strDate;
				sqlUpd += "'";

				// Where句の作成
				if (whereFlg.equals("1")) {
					sqlWhere = " WHERE";
					if (inputWhereBid != null) {
						sqlWhere += " book.id = ";
						sqlWhere += "'";
						sqlWhere += inputWhereBid;
						sqlWhere += "'";
						whereFlg = "2";
					}
					if (inputWhereGenre != null) {
						if (whereFlg.equals("2")) {
							sqlWhere += " AND";
						}
						sqlWhere += " book.genre = ";
						sqlWhere += "'";
						sqlWhere += inputWhereGenre;
						sqlWhere += "'";
						whereFlg = "2";
					}
					if (inputWhereTitle != null) {
						if (whereFlg.equals("2")) {
							sqlWhere += " AND";
						}
						sqlWhere += " book.title = ";
						sqlWhere += "'";
						sqlWhere += inputWhereTitle;
						sqlWhere += "'";
						whereFlg = "2";
					}
					if (inputWherePrice != null) {
						if (whereFlg.equals("2")) {
							sqlWhere += " AND";
						}
						sqlWhere += " book.price = " + inputWherePrice;
						whereFlg = "2";
					}
					if (inputWhereAuthor != null) {
						if (whereFlg.equals("2")) {
							sqlWhere += " AND";
						}
						sqlWhere += " book.author = ";
						sqlWhere += "'";
						sqlWhere += inputWhereAuthor;
						sqlWhere += "'";
						whereFlg = "2";
					}
					if (inputWherePublisher != null) {
						if (whereFlg.equals("2")) {
							sqlWhere += " AND";
						}
						sqlWhere += " book.publisher = ";
						sqlWhere += "'";
						sqlWhere += inputWherePublisher;
						sqlWhere += "'";
						whereFlg = "2";
					}
				}
				sql = "UPDATE book";
				sql += sqlUpd;
				if (sqlWhere != null) {
					sql += sqlWhere;
				}
			}
		}

		// 図書館テーブルの場合
		else if (inputvalue.equals("2")) {
			while (true) {
				System.out.println("更新する項目を選択してください");
				System.out.println("1.ID");
				System.out.println("2.図書館名");
				System.out.println("0.更新条件を設定します");
				if (inputUpdLid != null) {
					System.out.println("ID:" + inputUpdLid);
					updFlg = "1";
				}
				if (inputUpdLibName != null) {
					System.out.println("図書館名:" + inputUpdLibName);
					updFlg = "1";
				}
				inputUpdLibraryValue = scan.next();
				if (inputUpdLibraryValue.equals("1")) {
					System.out.println("IDを入力してください");
					System.out.println("例：LXXX");
					inputUpdLid = scan.next();
					if (!chklid(inputUpdLid)) {
						inputUpdLid = null;
						System.err.println("不正な値です。もう一度入力してください。");
					}
					continue;
				} else if (inputUpdLibraryValue.equals("2")) {
					System.out.println("図書館名を入力してください");
					inputUpdLibName = scan.next();
					continue;
				} else if (inputUpdLibraryValue.equals("0")) {
					if (updFlg.equals("1")) {
						break;
					} else {
						System.err.println("更新する項目がありません");
					}
				} else {
					System.err.println("不正な数値です。もう一度入力してください。");
				}
			}
			if (updFlg.equals("1")) {
				while (true) {
					System.out.println("更新条件を選択してください");
					System.out.println("1.ID");
					System.out.println("2.図書館名");
					System.out.println("0.更新条件を設定します");
					if (inputWhereLid != null) {
						System.out.println("ID:" + inputWhereLid);
						whereFlg = "1";
					}
					if (inputWhereLibName != null) {
						System.out.println("図書館名:" + inputWhereLibName);
						whereFlg = "1";
					}
					inputWhereLibraryValue = scan.next();
					if (inputWhereLibraryValue.equals("1")) {
						System.out.println("IDを入力してください");
						System.out.println("例：LXXX");
						inputWhereLid = scan.next();
						continue;
					} else if (inputWhereLibraryValue.equals("2")) {
						System.out.println("図書館名を入力してください");
						inputWhereLibName = scan.next();
						continue;
					} else if (inputWhereLibraryValue.equals("0")) {
						break;
					} else {
						System.err.println("不正な数値です。もう一度入力してください。");
					}
				}
			}
			// Set句の作成
			sqlUpd = " SET";
			if (inputUpdLid != null) {
				sqlUpd += " lblink.id = ";
				sqlUpd += "'";
				sqlUpd += inputUpdLid;
				sqlUpd += "'";
				updFlg = "2";
			}
			if (inputUpdLibName != null) {
				if (updFlg.equals("2")) {
					sqlUpd += ",";
				}
				sqlUpd += " library.libname = ";
				sqlUpd += "'";
				sqlUpd += inputUpdLibName;
				sqlUpd += "'";
				updFlg = "2";
			}
			sqlUpd += ",";
			sqlUpd += " library.update_date = ";
			sqlUpd += "'";
			sqlUpd += strDate;
			sqlUpd += "'";

			// Where句の作成
			if (whereFlg.equals("1")) {
				sqlWhere = " WHERE";
				if (inputWhereLid != null) {
					sqlWhere += " library.id = ";
					sqlWhere += "'";
					sqlWhere += inputWhereLid;
					sqlWhere += "'";
					whereFlg = "2";
				}
				if (inputWhereLibName != null) {
					if (whereFlg.equals("2")) {
						sqlWhere += " AND";
					}
					sqlWhere += " library.libname = ";
					sqlWhere += "'";
					sqlWhere += inputWhereLibName;
					sqlWhere += "'";
					whereFlg = "2";
				}
				sql = "UPDATE library";
				sql += sqlUpd;
				if (sqlWhere != null) {
					sql += sqlWhere;
				}
			}
		}
		// 紐付きテーブルの場合
		else {
			while (true) {
				System.out.println("更新する項目を選択してください");
				System.out.println("1.ID");
				System.out.println("2.図書館ID");
				System.out.println("3.本ID");
				System.out.println("0.更新条件を設定します");
				if (inputUpdLbid != null) {
					System.out.println("ID:" + inputUpdLbid);
					updFlg = "1";
				}
				if (inputUpdLid != null) {
					System.out.println("ID:" + inputUpdLid);
					updFlg = "1";
				}
				if (inputUpdBid != null) {
					System.out.println("ID:" + inputUpdBid);
					updFlg = "1";
				}
				inputUpdLblinkValue = scan.next();
				if (inputUpdLblinkValue.equals("1")) {
					System.out.println("IDを入力してください");
					System.out.println("例：LBXX");
					inputUpdLbid = scan.next();
					if (!chklbid(inputUpdLbid)) {
						inputUpdLbid = null;
						System.err.println("不正な値です。もう一度入力してください。");
					}
					continue;
				} else if (inputUpdLblinkValue.equals("2")) {
					System.out.println("図書館IDを入力してください");
					System.out.println("例：LXXX");
					inputUpdLid = scan.next();
					if (!chklid(inputUpdLid)) {
						inputUpdLid = null;
						System.err.println("不正な値です。もう一度入力してください。");
					}
					continue;
				} else if (inputUpdLblinkValue.equals("3")) {
					System.out.println("本IDを入力してください");
					System.out.println("例：BXXX");
					inputUpdBid = scan.next();
					if (!chkbid(inputUpdBid)) {
						inputUpdBid = null;
						System.err.println("不正な値です。もう一度入力してください。");
					}
					continue;
				} else if (inputUpdLblinkValue.equals("0")) {
					break;
				} else {
					System.err.println("不正な数値です。もう一度入力してください。");
				}
			}
			if (updFlg.equals("1")) {
				while (true) {
					System.out.println("更新条件を選択してください");
					System.out.println("1.ID");
					System.out.println("2.図書館ID");
					System.out.println("3.本ID");
					System.out.println("0.更新処理を開始します");
					if (inputWhereLbid != null) {
						System.out.println("ID:" + inputWhereLbid);
						whereFlg = "1";
					}
					if (inputWhereLid != null) {
						System.out.println("ID:" + inputWhereLid);
						whereFlg = "1";
					}
					if (inputWhereBid != null) {
						System.out.println("ID:" + inputWhereBid);
						whereFlg = "1";
					}
					inputWhereLblinkValue = scan.next();
					if (inputWhereLblinkValue.equals("1")) {
						System.out.println("IDを入力してください");
						System.out.println("例：LBXX");
						inputWhereLbid = scan.next();
						continue;
					} else if (inputWhereLblinkValue.equals("2")) {
						System.out.println("図書館IDを入力してください");
						System.out.println("例：LXXX");
						inputWhereLid = scan.next();
						continue;
					} else if (inputWhereLblinkValue.equals("3")) {
						System.out.println("本IDを入力してください");
						System.out.println("例：BXXX");
						inputWhereBid = scan.next();
						continue;
					} else if (inputWhereLblinkValue.equals("0")) {
						break;
					} else {
						System.err.println("不正な数値です。もう一度入力してください。");
					}
				}
			}
			// Set句の作成
			sqlUpd = " SET";
			if (inputUpdLbid != null) {
				sqlUpd += " lblink.id = ";
				sqlUpd += "'";
				sqlUpd += inputUpdLbid;
				sqlUpd += "'";
				updFlg = "2";
			}
			if (inputUpdLid != null) {
				if (updFlg.equals("2")) {
					sqlUpd += ",";
				}
				sqlUpd += " lblink.libid = ";
				sqlUpd += "'";
				sqlUpd += inputUpdLid;
				sqlUpd += "'";
				updFlg = "2";
			}
			if (inputUpdBid != null) {
				if (updFlg.equals("2")) {
					sqlUpd += ",";
				}
				sqlUpd += " lblink.bid = ";
				sqlUpd += "'";
				sqlUpd += inputUpdBid;
				sqlUpd += "'";
				updFlg = "2";
			}

			sqlUpd += ",";
			sqlUpd += " lblink.update_date = ";
			sqlUpd += "'";
			sqlUpd += strDate;
			sqlUpd += "'";
			// System.out.println(sqlUpd);

			// Where句の作成
			if (whereFlg.equals("1")) {
				sqlWhere = " WHERE";
				if (inputWhereLbid != null) {
					sqlWhere += " lblink.id = ";
					sqlWhere += "'";
					sqlWhere += inputWhereLbid;
					sqlWhere += "'";
					whereFlg = "2";
				}
				if (inputWhereLid != null) {
					if (whereFlg.equals("2")) {
						sqlWhere += " AND";
					}
					sqlWhere += " lblink.libid = ";
					sqlWhere += "'";
					sqlWhere += inputWhereLid;
					sqlWhere += "'";
					whereFlg = "2";
				}
				if (inputWhereBid != null) {
					if (whereFlg.equals("2")) {
						sqlWhere += " AND";
					}
					sqlWhere += " lblink.bid = ";
					sqlWhere += "'";
					sqlWhere += inputWhereBid;
					sqlWhere += "'";
					whereFlg = "2";
				}
			}

			sql = "UPDATE lblink";
			sql += sqlUpd;
			if (sqlWhere != null) {
				sql += sqlWhere;
			}
		}

		// System.out.println(sql);
		scan.close();
		try {
			dbconnectdao.executeSql(sql);
			System.out.println("処理が完了しました。");
		} catch (Exception e) {
			/* エラーメッセージ */
			System.err.println("処理に失敗しました");
		}
	}

	public static void DeleteDb() {
		Scanner scan = new Scanner(System.in);
		DBConnectDao5 dbconnectdao = new DBConnectDao5();
		String inputvalue = null;
		String inputDelBookValue = null;
		String inputDelLibraryValue = null;
		String inputDelLblinkValue = null;
		String sql = null;
		String whereFlg = "0";
		String sqlWhere = null;
		String inputDelBid = null;
		String inputDelLbid = null;
		String inputDelLid = null;
		String inputDelGenre = null;
		String inputDelLibName = null;
		String inputDelTitle = null;
		String inputDelPrice = null;
		String inputDelAuthor = null;
		String inputDelPublisher = null;

		while (true) {
			System.out.println("対象を選択してください");
			System.out.println("1.本データを選択");
			System.out.println("2.図書館データを選択");
			System.out.println("3.紐付きデータを選択");
			inputvalue = scan.next();
			if (chknum2(inputvalue)) {
				break;
			} else {
				System.err.println("不正な数値です。もう一度入力してください。");
			}
		}
		// 本テーブルの場合
		if (inputvalue.equals("1")) {
			while (true) {
				System.out.println("削除条件を選択してください");
				System.out.println("1.ID");
				System.out.println("2.ジャンル");
				System.out.println("3.タイトル");
				System.out.println("4.値段");
				System.out.println("5.作者");
				System.out.println("6.出版社");
				System.out.println("0.削除を開始します");
				if (inputDelBid != null) {
					System.out.println("ID:" + inputDelBid);
					whereFlg = "1";
				}
				if (inputDelGenre != null) {
					System.out.println("ジャンル:" + inputDelGenre);
					whereFlg = "1";
				}
				if (inputDelTitle != null) {
					System.out.println("タイトル:" + inputDelTitle);
					whereFlg = "1";
				}
				if (inputDelPrice != null) {
					System.out.println("値段:" + inputDelPrice);
					whereFlg = "1";
				}
				if (inputDelAuthor != null) {
					System.out.println("作者:" + inputDelAuthor);
					whereFlg = "1";
				}
				if (inputDelPublisher != null) {
					System.out.println("出版社:" + inputDelPublisher);
					whereFlg = "1";
				}
				inputDelBookValue = scan.next();
				if (inputDelBookValue.equals("1")) {
					System.out.println("IDを入力してください");
					System.out.println("例：BXXX");
					inputDelBid = scan.next();
					continue;
				} else if (inputDelBookValue.equals("2")) {
					System.out.println("ジャンルを入力してください");
					inputDelGenre = scan.next();
					continue;
				} else if (inputDelBookValue.equals("3")) {
					System.out.println("タイトルを入力してください");
					inputDelTitle = scan.next();
					continue;
				} else if (inputDelBookValue.equals("4")) {
					System.out.println("値段を入力してください");
					inputDelPrice = scan.next();
					continue;
				} else if (inputDelBookValue.equals("5")) {
					System.out.println("作者を入力してください");
					inputDelAuthor = scan.next();
					continue;
				} else if (inputDelBookValue.equals("6")) {
					System.out.println("出版社を入力してください");
					inputDelPublisher = scan.next();
					continue;
				} else if (inputDelBookValue.equals("0")) {
					break;
				} else {
					System.err.println("不正な数値です。もう一度入力してください。");
				}
			}
			if (whereFlg.equals("1")) {
				sqlWhere = " WHERE";
				if (inputDelBid != null) {
					sqlWhere += " book.id = ";
					sqlWhere += "'";
					sqlWhere += inputDelBid;
					sqlWhere += "'";
					whereFlg = "2";
				}
				if (inputDelGenre != null) {
					if (whereFlg.equals("2")) {
						sqlWhere += " AND";
					}
					sqlWhere += " book.genre = ";
					sqlWhere += "'";
					sqlWhere += inputDelGenre;
					sqlWhere += "'";
					whereFlg = "2";
				}
				if (inputDelTitle != null) {
					if (whereFlg.equals("2")) {
						sqlWhere += " AND";
					}
					sqlWhere += " book.title = ";
					sqlWhere += "'";
					sqlWhere += inputDelTitle;
					sqlWhere += "'";
					whereFlg = "2";
				}
				if (inputDelPrice != null) {
					if (whereFlg.equals("2")) {
						sqlWhere += " AND";
					}
					sqlWhere += " book.price = " + inputDelPrice;
					whereFlg = "2";
				}
				if (inputDelAuthor != null) {
					if (whereFlg.equals("2")) {
						sqlWhere += " AND";
					}
					sqlWhere += " book.author = ";
					sqlWhere += "'";
					sqlWhere += inputDelAuthor;
					sqlWhere += "'";
					whereFlg = "2";
				}
				if (inputDelPublisher != null) {
					if (whereFlg.equals("2")) {
						sqlWhere += " AND";
					}
					sqlWhere += " book.publisher = ";
					sqlWhere += "'";
					sqlWhere += inputDelPublisher;
					sqlWhere += "'";
					whereFlg = "2";
				}
			}
			// System.out.println(sqlWhere);
			sql = "DELETE ";
			sql += "FROM book ";
			if (whereFlg.equals("2")) {
				sql += sqlWhere;
			}
			// System.out.println(sql);
		}

		// 図書館テーブルの場合
		else if (inputvalue.equals("2")) {
			while (true) {
				System.out.println("削除条件を選択してください");
				System.out.println("1.ID");
				System.out.println("2.図書館名");
				System.out.println("0.削除を開始します");
				if (inputDelLbid != null) {
					System.out.println("ID:" + inputDelLbid);
					whereFlg = "1";
				}
				if (inputDelLibName != null) {
					System.out.println("図書館名:" + inputDelLibName);
					whereFlg = "1";
				}
				inputDelLibraryValue = scan.next();
				if (inputDelLibraryValue.equals("1")) {
					System.out.println("IDを入力してください");
					System.out.println("例：LXXX");
					inputDelLbid = scan.next();
					continue;
				} else if (inputDelLibraryValue.equals("2")) {
					System.out.println("図書館名を入力してください");
					inputDelLibName = scan.next();
					continue;
				} else if (inputDelLibraryValue.equals("0")) {
					break;
				} else {
					System.err.println("不正な数値です。もう一度入力してください。");
				}
			}
			if (whereFlg.equals("1")) {
				sqlWhere = " WHERE";
				if (inputDelLbid != null) {
					sqlWhere += " library.id = ";
					sqlWhere += "'";
					sqlWhere += inputDelLbid;
					sqlWhere += "'";
					whereFlg = "2";
				}
				if (inputDelLibName != null) {
					if (whereFlg.equals("2")) {
						sqlWhere += " AND";
					}
					sqlWhere += " library.libname = ";
					sqlWhere += "'";
					sqlWhere += inputDelLibName;
					sqlWhere += "'";
				}
			}
			// System.out.println(sqlWhere);
			sql = "DELETE ";
			sql += "FROM library ";
			if (whereFlg.equals("2")) {
				sql += sqlWhere;
			}
			// System.out.println(sql);
			scan.close();
			// 紐付きテーブルの場合
		} else {
			while (true) {
				System.out.println("削除条件を選択してください");
				System.out.println("1.ID");
				System.out.println("2.図書館ID");
				System.out.println("3.本ID");
				System.out.println("0.削除を開始します");
				if (inputDelLbid != null) {
					System.out.println("ID:" + inputDelLbid);
					whereFlg = "1";
				}
				if (inputDelLid != null) {
					System.out.println("ID:" + inputDelLid);
					whereFlg = "1";
				}
				if (inputDelBid != null) {
					System.out.println("ID:" + inputDelBid);
					whereFlg = "1";
				}
				inputDelLblinkValue = scan.next();
				if (inputDelLblinkValue.equals("1")) {
					System.out.println("IDを入力してください");
					System.out.println("例：LBXX");
					inputDelLbid = scan.next();
					continue;
				} else if (inputDelLblinkValue.equals("2")) {
					System.out.println("図書館IDを入力してください");
					System.out.println("例：LXXX");
					inputDelLid = scan.next();
					continue;
				} else if (inputDelLblinkValue.equals("3")) {
					System.out.println("本IDを入力してください");
					System.out.println("例：BXXX");
					inputDelBid = scan.next();
					continue;
				} else if (inputDelLblinkValue.equals("0")) {
					break;
				} else {
					System.err.println("不正な数値です。もう一度入力してください。");
				}
			}

			if (whereFlg.equals("1")) {
				sqlWhere = "WHERE ";
				if (inputDelLbid != null) {
					sqlWhere += " lblink.id = ";
					sqlWhere += "'";
					sqlWhere += inputDelLbid;
					sqlWhere += "'";
					whereFlg = "2";
				}
				if (inputDelLid != null) {
					if (whereFlg.equals("2")) {
						sqlWhere += " AND";
					}
					sqlWhere += " lblink.libid = ";
					sqlWhere += "'";
					sqlWhere += inputDelLid;
					sqlWhere += "'";
				}
				if (inputDelBid != null) {
					if (whereFlg.equals("2")) {
						sqlWhere += " AND";
					}
					sqlWhere += " lblink.bid = ";
					sqlWhere += "'";
					sqlWhere += inputDelBid;
					sqlWhere += "'";
				}
			}
			sql = "DELETE ";
			sql += "FROM lblink ";
			if (whereFlg.equals("2")) {
				sql += sqlWhere;
			}
		}

		//System.out.println(sql);
		try {
			dbconnectdao.executeSql(sql);
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
