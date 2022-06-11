package main.java.converter;

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


    public void toXML(String profileName) throws IOException {

        writer.write(defaultFirstLine + "\n");


        String profileOpenLine = "profile kind="
                + wrapped("CodeFormatterProfile", "\"");
        profileOpenLine += " name=" + wrapped(profileName, "\"");
        profileOpenLine = wrapped(profileOpenLine, "<", ">");

        writer.write(profileOpenLine + "\n");


        String line = "";

        while ((line = reader.readLine()) != null) {

            if (!line.startsWith(eclipseFormatterTag)) { continue; }

            line = lineToXML(line);

            writer.write(line + "\n");
        }

        String profileCloseLine = "</profile>";
        writer.write(profileCloseLine + "\n");
    }


    public String lineToXML(String line) {

        if (!line.contains("=")) { return ""; }

        var parts = line.split("=", 2);
        line = "setting id=";
        line += wrapped(parts[0], "\"");
        line += " value=";
        line += wrapped(parts[1], "\"");

        return wrapped(line, "<", "/>");
    }


    private String wrapped(String line, String left, String right) {
        return left + line + right;
    }


    private String wrapped(String line, String wrap) {
        return wrapped(line, wrap, wrap);
    }
}
