import java.util.Scanner;

public class Selectdb {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DBConnectDao2 dbconnectdao = new DBConnectDao2();
		String strin = null;
		while (true) {
			System.out.println("������I�����Ă�������");
			System.out.println("1.�{�f�[�^��I��");
			System.out.println("2.�}���كf�[�^��I��");
			System.out.println("3.�}���ٖ��̖{�̐���I��");
			strin = scan.next();
			if (chknum(strin)){
				try{
					dbconnectdao.conectOracle(strin);
				}
				catch (Exception e){			
					/* �G���[���b�Z�[�W */
					System.out.println("�ڑ��Ɏ��s���܂���");
				}
				break;
			}
			else{
				System.err.println("�s���Ȑ��l�ł��B������x���͂��Ă��������B");
			}
		}
		scan.close();
	}
	// ���l�`�F�b�N
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
  
