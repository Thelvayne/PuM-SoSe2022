// Nick Cwertetschka 4070430
// Philipp Jäckel 4070258

import java.io.IOException;
import java.util.Scanner;

public class ContactFormatter {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        ContactReader reader = new ContactReader();
        ContactWriter writer = new ContactWriter();

        System.out.println("Geben Sie die Datei an, die ausgelesen werden soll: ");
        String filename = scan.nextLine();
        reader.readFromFile(filename);
        System.out.println("Es wurden " + reader.getContacts().length + " Kontakte gefunden.");
        System.out.println("Geben Sie den Dateinamen der zu erzeugenden Datei an.");
        filename = scan.nextLine();
        writer.writeToFile(reader.getContacts(), filename);
        scan.close();
    }
}
