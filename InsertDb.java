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
		// �ǉ�����e�[�u���̑I��
		while (true) {
			System.out.println("������I�����Ă�������");
			System.out.println("1.�{�f�[�^��ǉ�");
			System.out.println("2.�}���كf�[��ǉ�");
			System.out.println("3.�R�t���f�[�^��ǉ�");
			Strin = scan.next();
			if (chknum1(Strin)) {
				StrDate = sdf1.format(date);
				System.out.println(StrDate);
				break;
			} else {
				System.err.println("�s���Ȓl�ł��B������x���͂��Ă��������B");
			}
		}
		// �{�e�[�u���̏ꍇ
		if (Strin.equals("1")) {
			while (true) {
				System.out.println("ID����͂��Ă�������");
				System.out.println("��FBXXX");
				Strin2 = scan.next();
				if (chkbid(Strin2)) {
					break;
				} else {
					System.err.println("�s���Ȓl�ł��B������x���͂��Ă��������B");
				}
			}
			while (true) {
				System.out.println("�W����������͂��Ă�������");
				Strin3 = scan.next();
				if (chkbyte(Strin3)) {
					break;
				} else {
					System.err.println("�s���Ȓl�ł��B������x���͂��Ă��������B");
				}
			}
			while (true) {
				System.out.println("�^�C�g������͂��Ă�������");
				Strin4 = scan.next();
				if (chkbyte(Strin4)) {
					break;
				} else {
					System.err.println("�s���Ȓl�ł��B������x���͂��Ă��������B");
				}
			}
			while (true) {
				System.out.println("�l�i����͂��Ă�������");
				Strin5 = scan.next();
				if (chkprice(Strin5)) {
					break;
				} else {
					System.err.println("�s���Ȓl�ł��B������x���͂��Ă��������B");
				}
			}
			while (true) {
				System.out.println("��҂���͂��Ă�������");
				Strin6 = scan.next();
				if (chkbyte(Strin6)) {
					break;
				} else {
					System.err.println("�s���Ȓl�ł��B������x���͂��Ă��������B");
				}
			}
			while (true) {
				System.out.println("�o�ŎЂ���͂��Ă�������");
				Strin7 = scan.next();
				if (chkbyte(Strin7)) {
					break;
				} else {
					System.err.println("�s���Ȓl�ł��B������x���͂��Ă��������B");
				}
			}
			scan.close();
			// SQL�̍쐬
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
		// �}���كe�[�u���̏ꍇ
		else if (Strin.equals("2")) {
			while (true) {
				System.out.println("ID����͂��Ă�������");
				System.out.println("��FLXXX");
				Strin2 = scan.next();
				if (chklid(Strin2)) {
					break;
				} else {
					System.err.println("�s���Ȓl�ł��B������x���͂��Ă��������B");
				}
			}
			while (true) {
				System.out.println("�}���ٖ�����͂��Ă�������");
				Strin3 = scan.next();
				if (chkbyte(Strin3)) {
					break;
				} else {
					System.err.println("�s���Ȓl�ł��B������x���͂��Ă��������B");
				}
			}
			scan.close();
			// SQL�̍쐬
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
		// �R�t���e�[�u���̏ꍇ
		else {
			while (true) {
				System.out.println("ID����͂��Ă�������");
				System.out.println("��FLBXX");
				Strin2 = scan.next();
				if (chklbid(Strin2)) {
					break;
				} else {
					System.err.println("�s���Ȓl�ł��B������x���͂��Ă��������B");
				}
			}
			while (true) {
				System.out.println("�}����ID����͂��Ă�������");
				System.out.println("��FLXXX");
				Strin3 = scan.next();
				if (chklid(Strin3)) {
					break;
				} else {
					System.err.println("�s���Ȓl�ł��B������x���͂��Ă��������B");
				}
			}
			while (true) {
				System.out.println("�{ID����͂��Ă�������");
				System.out.println("��FBXXX");
				Strin4 = scan.next();
				if (chkbid(Strin4)) {
					break;
				} else {
					System.err.println("�s���Ȓl�ł��B������x���͂��Ă��������B");
				}
			}
			scan.close();
			// SQL�̍쐬
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
			System.out.println("�������������܂����B");
		} catch (Exception e) {
			/* �G���[���b�Z�[�W */
			System.out.println("�����Ɏ��s���܂���");
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
