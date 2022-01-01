package Lab10;

import java.util.Iterator;
import java.util.Set;

public class TestDriver {
	

	public static void main(String[] args) {
		String[] names = {
				"Lasandra Packer",
				"Oren Evan",
				"Danelle Wasko",
				"Rich Havel",
				"Kristle Woodruff",
				"Tara Witt",
				"Patti Kellner",
				"Thanh Bunkley",
				"Lorraine Skelly", // duplicate
				"Lorraine Skelly"  // duplicate
		};
		
		String[] phoneNumbers = {
				"(958) 416-6820",  // duplicate
				"(958) 416-6820",  // duplicate
				"(422) 559-3857",
				"(673) 509-8613",
				"(551) 981-6195",
				"(513) 781-8347",
				"(892) 408-6187",
				"(554) 452-6981",
				"(531) 558-3976",
				"(260) 206-2730"
		};
		
		String[] deleteNames = {
				"Lasandra Packer",
				"some name"
		};
		
		
		PhoneBook pb;
		pb = new PhoneBook();
		
		
		System.out.println("### Add information to the phone book");
		for(int i =0; i < names.length; i++) {
			if(!pb.add(names[i], phoneNumbers[i])) {
				System.out.printf("Add failure: Duplicate name or phone number: (%s, %s)\n", names[i], phoneNumbers[i]);
			};
		}
		
		System.out.println("### Delete information");
		for(String item : deleteNames) {
			if(!pb.delete(item)) {
				System.out.printf("Delete failure - No such name: (%s)\n", item);
			}
		}
		
		System.out.println("### List of all the Person objects in the phone book");
		Set<Person> pbSet = pb.list();
		
		Iterator<Person> itr = pbSet.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next().toString());
		}
		
		System.out.println();
		
	}
}
