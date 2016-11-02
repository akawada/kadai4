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
			System.out.println("������I�����Ă�������");
			System.out.println("1.�{�f�[�^��I��");
			System.out.println("2.�}���كf�[�^��I��");
			System.out.println("3.�}���ٖ��̖{�̐���I��");
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
		            // �擾�������ʂ�S���o�͂���
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
			                System.out.print(Lblink2.getCount() + "��\n");
			            }
		            	
		            }
				}
				catch (Exception e){			
					/* �G���[���b�Z�[�W */
					System.out.println("�����Ɏ��s���܂���");
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
  
