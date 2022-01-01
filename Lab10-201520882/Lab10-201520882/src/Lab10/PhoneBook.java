package Lab10;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class PhoneBook {
	private HashMap<String, String> phoneBook;
	
	public PhoneBook() {
		phoneBook = new HashMap<String, String>();
	}
	
	public Boolean add(String name, String phoneNumber) {
		
		if(phoneBook.containsKey(name)) return false;
		else if(phoneBook.containsValue(phoneNumber)) return false;
		
		phoneBook.put(name, phoneNumber);
		return true;
	}
	
	public Boolean delete(String name) {
		
		if(phoneBook.containsKey(name)) {
			phoneBook.remove(name);
			return true;
		}
		else return false;
	}
	
	public Set<Person> list() {
		Set<Person> returnValue = new HashSet<Person>();
		String sBuffer;
		
		Set<String> setBuffer = phoneBook.keySet();
		Iterator<String> itr = setBuffer.iterator();
		
		while(itr.hasNext()) {
			sBuffer = itr.next();
			returnValue.add(new Person(sBuffer, phoneBook.get(sBuffer)));
		}
		
		return returnValue;
	}
}
