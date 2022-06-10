package converter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;


public class Converter {

    private final String defaultFirstLine = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>";
    private final String eclipseFormatterTag = "org.eclipse.jdt.core.formatter";

    private BufferedReader reader;
    private BufferedWriter writer;


    public Converter(BufferedReader reader, BufferedWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }


    public void toXML() throws IOException {

        writer.write(defaultFirstLine);
        writer.newLine();

        String line = "";

        while ((line = reader.readLine()) != null) {

            if (!line.startsWith(eclipseFormatterTag)) { continue; }

            line = lineToXML(line);

            writer.write(line);
            writer.newLine();
        }
    }


    public String lineToXML(String line) {

        if (!line.contains("=")) { return ""; }

        var parts = line.split("=", 2);
        line = "setting id=";
        line += framed(parts[0], "\"");
        line += " value=";
        line += framed(parts[1], "\"");

        return framed(line, "<", "/>");
    }


    private String framed(String line, String left, String right) {
        return left + line + right;
    }


    private String framed(String line, String frame) {
        return framed(line, frame, frame);
    }
}
