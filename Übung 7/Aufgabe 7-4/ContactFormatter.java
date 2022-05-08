import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ContactFormatter {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        ContactReader reader = new ContactReader();
        ContactWriter writer = new ContactWriter();

        System.out.println("Geben Sie die Datei an, die ausgelesen werden soll: ");
        String filename = scan.nextLine();
        File file;
        reader.readFromFile(filename);
        System.out.println("Es wurden " + reader.getContacts().length + " Kontakte gefunden.");
        System.out.println("Geben Sie den Dateinamen der zu erzeugenden Datei an.");
        filename = scan.nextLine();
        writer.writeToFile(reader.getContacts(), filename);
    }
}
