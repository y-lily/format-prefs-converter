package converter;


public class Converter {

    public String toXML(String line) {

        if (line.contains("=")) {
            var parts = line.split("=", 2);
            line = "setting id=";
            line += framed(parts[0], "\"");
            line += " value=";
            line += framed(parts[1], "\"");
        }

        return framed(line, "<", "/>");
    }


    private String framed(String line, String left, String right) {
        return left + line + right;
    }


    private String framed(String line, String frame) {
        return framed(line, frame, frame);
    }
}
