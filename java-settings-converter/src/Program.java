import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

import converter.Converter;


public class Program {

    public static void main(String[] args) throws IOException {

        String inputFileName = "org.eclipse.jdt.core.prefs";
        String outputFileName = "eclipse-java-style.xml";

        Scanner reader = new Scanner(Paths.get(inputFileName));
        Converter converter = new Converter();

        try (FileWriter writer = new FileWriter(outputFileName)) {

            while (reader.hasNextLine()) {
                var line = reader.nextLine();
                line = converter.toXML(line);
                writer.write(line + "\n");
            }
        }
    }
}
