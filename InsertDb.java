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
		// �ǉ�����e�[�u���̑I��
		while (true) {
			System.out.println("������I�����Ă�������");
			System.out.println("1.�{�f�[�^��ǉ�");
			System.out.println("2.�}���كf�[��ǉ�");
			System.out.println("3.�R�t���f�[�^��ǉ�");
			strSelTable = scan.next();
			if (chknum1(strSelTable)) {
				strDate = sdf1.format(date);
				System.out.println(strDate);
				break;
			} else {
				System.err.println("�s���Ȓl�ł��B������x���͂��Ă��������B");
			}
		}
		// �{�e�[�u���̏ꍇ
		if (strSelTable.equals("1")) {
			while (true) {
				System.out.println("ID����͂��Ă�������");
				System.out.println("��FBXXX");
				strBid = scan.next();
				if (chkbid(strBid)) {
					break;
				} else {
					System.err.println("�s���Ȓl�ł��B������x���͂��Ă��������B");
				}
			}
			while (true) {
				System.out.println("�W����������͂��Ă�������");
				strGenre = scan.next();
				if (chkbyte(strGenre)) {
					break;
				} else {
					System.err.println("�s���Ȓl�ł��B������x���͂��Ă��������B");
				}
			}
			while (true) {
				System.out.println("�^�C�g������͂��Ă�������");
				strTitle = scan.next();
				if (chkbyte(strTitle)) {
					break;
				} else {
					System.err.println("�s���Ȓl�ł��B������x���͂��Ă��������B");
				}
			}
			while (true) {
				System.out.println("�l�i����͂��Ă�������");
				strPrice = scan.next();
				if (chkprice(strPrice)) {
					break;
				} else {
					System.err.println("�s���Ȓl�ł��B������x���͂��Ă��������B");
				}
			}
			while (true) {
				System.out.println("��҂���͂��Ă�������");
				strAuthor = scan.next();
				if (chkbyte(strAuthor)) {
					break;
				} else {
					System.err.println("�s���Ȓl�ł��B������x���͂��Ă��������B");
				}
			}
			while (true) {
				System.out.println("�o�ŎЂ���͂��Ă�������");
				strPublisher = scan.next();
				if (chkbyte(strPublisher)) {
					break;
				} else {
					System.err.println("�s���Ȓl�ł��B������x���͂��Ă��������B");
				}
			}
			scan.close();
			// SQL�̍쐬
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
		// �}���كe�[�u���̏ꍇ
		else if (strSelTable.equals("2")) {
			while (true) {
				System.out.println("ID����͂��Ă�������");
				System.out.println("��FLXXX");
				strLid = scan.next();
				if (chklid(strLid)) {
					break;
				} else {
					System.err.println("�s���Ȓl�ł��B������x���͂��Ă��������B");
				}
			}
			while (true) {
				System.out.println("�}���ٖ�����͂��Ă�������");
				strLibName = scan.next();
				if (chkbyte(strLibName)) {
					break;
				} else {
					System.err.println("�s���Ȓl�ł��B������x���͂��Ă��������B");
				}
			}
			scan.close();
			// SQL�̍쐬
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
		// �R�t���e�[�u���̏ꍇ
		else {
			while (true) {
				System.out.println("ID����͂��Ă�������");
				System.out.println("��FLBXX");
				strLbid = scan.next();
				if (chklbid(strLbid)) {
					break;
				} else {
					System.err.println("�s���Ȓl�ł��B������x���͂��Ă��������B");
				}
			}
			while (true) {
				System.out.println("�}����ID����͂��Ă�������");
				System.out.println("��FLXXX");
				strLid = scan.next();
				if (chklid(strLid)) {
					break;
				} else {
					System.err.println("�s���Ȓl�ł��B������x���͂��Ă��������B");
				}
			}
			while (true) {
				System.out.println("�{ID����͂��Ă�������");
				System.out.println("��FBXXX");
				strBid = scan.next();
				if (chkbid(strBid)) {
					break;
				} else {
					System.err.println("�s���Ȓl�ł��B������x���͂��Ă��������B");
				}
			}
			scan.close();
			// SQL�̍쐬
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
			System.out.println("�������������܂����B");
		} catch (Exception e) {
			/* �G���[���b�Z�[�W */
			System.err.println("�����Ɏ��s���܂���");
		}
	}

	// ���͒l1�`�F�b�N
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

	// �{ID�`�F�b�N
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

	// �}����ID�`�F�b�N
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

	// �R�t��ID�`�F�b�N
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

	// �o�C�g���`�F�b�N
	static boolean chkbyte(String lbid) {
		if (lbid.getBytes().length < 100) {
			return true;
		} else {
			return false;
		}
	}

}
