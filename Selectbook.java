import java.util.ArrayList;
import java.util.List;

public class Selectbook {
	public static void main(String[] args) {
		DBConnectDao dbconnectdao = new DBConnectDao();
        List bookList = new ArrayList();
        try{
        	bookList = dbconnectdao.conectOracle();
            // �擾�������ʂ�S���o�͂���
            Book book2;
            for (int i = 0; i < bookList.size(); i++) {
            	book2 = (Book) bookList.get(i);
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
		catch (Exception e){			
			/* �G���[���b�Z�[�W */
			System.out.println("�ڑ��Ɏ��s���܂���");
		}
	}
}
  
