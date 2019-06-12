package pomocnaKlasaZaDatume;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class RadSaDatumima {

	public static SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("dd.MM.yyyy. HH:mm");
	
	static Scanner sc = new Scanner(System.in);
	
	public static java.util.Date ocitajDatumVreme() {
		java.util.Date dateTime = null;

		while (dateTime == null) {
			String text = sc.nextLine();
			try {
				dateTime = DATE_TIME_FORMAT.parse(text);
			} catch (Exception ex) {
				System.out.println("GRESKA - Pogresno unsesena vrednost, pokusajte ponovo: ");
			}
		}

		return dateTime;
	}
}
