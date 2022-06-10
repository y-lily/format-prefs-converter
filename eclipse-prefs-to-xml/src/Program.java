import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import converter.Converter;


public class Program {

    public static void main(String[] args) throws IOException {

        String inputFileName = "org.eclipse.jdt.core.prefs";
        String outputFileName = "eclipse-java-style.xml";

        if (args.length > 1) { inputFileName = args[1]; }


        try (FileReader fileReader = new FileReader(inputFileName);
                BufferedReader reader = new BufferedReader(fileReader);
                FileWriter fileWriter = new FileWriter(outputFileName);
                BufferedWriter writer = new BufferedWriter(fileWriter)) {

            Converter converter = new Converter(reader, writer);
            converter.toXML();

        }
    }
}
