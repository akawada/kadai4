import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DataSelStore {
	public <T> List<T>  SetDbData(ResultSet InRs, String Strin) throws Exception{
        List SelList = new ArrayList();
        if (Strin.equals("1")){
        	while (InRs.next()) {
                Book book = new Book();
                book.setId(InRs.getString(1));
                book.setGenre(InRs.getString(2));
                book.setTitle(InRs.getString(3));
                book.setPrice(InRs.getInt(4));
                book.setAuthor(InRs.getString(5));
                book.setPublisher(InRs.getString(6));
                book.setEntry_date(InRs.getString(7));
                book.setUpdate_date(InRs.getString(8));
                SelList.add(book);
            }
        }
        else if (Strin.equals("2")){
        	while (InRs.next()) {
                Library library = new Library();
                library.setId(InRs.getString(1));
                library.setLibname(InRs.getString(2));
                library.setEntry_date(InRs.getString(3));
                library.setUpdate_date(InRs.getString(4));
                SelList.add(library);
            }
        }
        else if (Strin.equals("3")){
        	while (InRs.next()) {
        		BookLibName booklibname = new BookLibName();
        		booklibname.setLibname(InRs.getString(15));
        		booklibname.setTitle(InRs.getString(8));
        		booklibname.setAuthor(InRs.getString(10));
                SelList.add(booklibname);
            }
        }
        else{
        	while (InRs.next()) {
                Lblink lblink = new Lblink();
                lblink.setLibname(InRs.getString(1));
                lblink.setCount(InRs.getInt(2));
                SelList.add(lblink);
            }
        }
    	return SelList;
    }
}





