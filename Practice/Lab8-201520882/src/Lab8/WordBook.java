package Lab8;
import java.util.ArrayList;

public class WordBook implements AutoCloseable {
	ArrayList<String> list;
	
	public WordBook(ArrayList<String> list) {
		this.list = list;
		boolean flag = false;
		
		System.out.print("=====Created words=====\n[");
		for(String item : this.list) {
			
			if(flag == true) System.out.print(", ");
			else flag = true;
			
			System.out.printf("%s", item);
		}
		System.out.println("]");
	}
	public int getSize() {
		return list.size();
	}
	public void enter(String name) throws Exception{
		
		if(name.equals("")) {
			throw new Exception("You must type a word! Your input is empty");
		}
		
		try {
		list.remove(list.indexOf(name));
		} catch(Exception e) {
		throw new Exception(String.format("%s is not in the WordBook", name));
		}
		System.out.printf("%s Deleted\n", name);
	}
	
	@Override
	public void close() throws Exception {
		boolean flag = false;
		
		System.out.print("=====Remained words=====\n[");
		for(String item : this.list) {
			
			if(flag == true) System.out.print(", ");
			else flag = true;
			
			System.out.printf("%s", item);
		}
		System.out.println("]");
	}
}
