package Lab8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TestDriver {
	public static void main(String[] args) {
		final ArrayList<String> list = new ArrayList<String> (
				Arrays.asList(
						"Malfurion",
						"Uther",
						"Thrall",
						"Guldan",
						"Anduin",
						"Rexxar",
						"Jaina",
						"Valeera",
						"Garrosh"
						)
				);
	
	try(final Scanner scanner = new Scanner(System.in);
			final WordBook wordbook = new WordBook(list)) {
		while(wordbook.getSize() > 0) {
			String name = scanner.nextLine();
			wordbook.enter(name);
			System.out.flush();
		}
	}	catch ( Exception err) {
			err.printStackTrace();		
		} finally {
			System.out.println("Porgram finished");
		}
	}
}