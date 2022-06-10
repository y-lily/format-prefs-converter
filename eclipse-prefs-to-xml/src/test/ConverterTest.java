package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import converter.Converter;


public class ConverterTest {

    private Converter converter;

    private final String inputFileName = "org.eclipse.jdt.core.prefs";
    private final String outputFileName = "eclipse-java-style.xml";


    @Before
    public void initialize() throws IOException {

        try (
                FileReader fileReader = new FileReader(inputFileName);
                BufferedReader reader = new BufferedReader(fileReader);
                FileWriter fileWriter = new FileWriter(outputFileName);
                BufferedWriter writer = new BufferedWriter(fileWriter)) {

            converter = new Converter(reader, writer);
        }
    }


    @Test
    public void lineWithNoEqualsIsConvertedToBlank() {
        var line = "org.eclipse.jdt.core.formatter.blank_lines_after_imports";
        var result = converter.lineToXML(line);
        assertEquals("", result);
    }


    @Test
    public void convertedLineContainsValue() {
        var line = "org.eclipse.jdt.core.formatter.blank_lines_after_imports=2";
        var result = converter.lineToXML(line);
        assertTrue(result.contains("value"));
    }


    @Test
    public void convertedLineContainsSetting() {
        var line = "org.eclipse.jdt.core.formatter.insert_new_line_before_catch_in_try_statement=insert";
        var result = converter.lineToXML(line);
        assertTrue(result.contains("setting"));
    }


    @Test
    public void convertedLineLooksLikeXML() {
        var line = "org.eclipse.jdt.core.formatter.indentation.size=4";
        var expected = "<setting id=\"org.eclipse.jdt.core.formatter.indentation.size\" value=\"4\"/>";
        var result = converter.lineToXML(line);
        assertEquals(expected, result);
    }

}
