package edu.neu.css.cs5004;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;


public class ReadTemplateTest {
  ReadTemplate newTemplateRead;
  ReadTemplate newTemplateRead1;
  StringBuilder templateToBeLoaded;
  String templateName;
  String corruptedFileName;
  String EmptyFile;
  String temps;


  //String line;


  @Before
  public void setUp() throws Exception {
    templateToBeLoaded = new StringBuilder();
    ReadTemplate tem = new ReadTemplate();
    String temps = tem.parseTemplate("custom-letter-template.txt");
    templateName = "custom-email-template.txt";
    corruptedFileName = "noTemplate.txt";
    newTemplateRead = new ReadTemplate();
    newTemplateRead1 = new ReadTemplate();
  }

  @Test
  public void parseTemplate() {
    //System.out.println(newTemplateRead.parseTemplate("custom-email-template.txt"));

    String temp1 = newTemplateRead1.parseTemplate("custom-email-template.txt");
    String temp = newTemplateRead.parseTemplate("custom-email-template.txt");
    assertFalse(temp.isEmpty());
    assertTrue(temp1.equals(temp));

  }

  @Test// (expected = FileNotFoundException.class)
  public void testNoFileFound() throws FileNotFoundException {


    // Uncomment to see error thrown
    //String newTemp = newTemplateRead.parseTemplate(corruptedFileName);

  }

  @Test
  public void testToString(){
    String parsed = newTemplateRead.parseTemplate(templateName);
    assertEquals(parsed, parsed.toString());

    // Uncomment to see that these tests fail when a corruptedFile is given
    //String unParsed = newTemplateRead.parseTemplate(corruptedFileName);

    //assertNotEquals(unParsed, parsed);

  }

  @Test
  public void testEquals(){
    String parsed = newTemplateRead.parseTemplate(templateName);
    ReadTemplate tem = new ReadTemplate();
    String temps = tem.parseTemplate("custom-letter-template.txt");
    assertNotEquals(temps,parsed);
    assertNotEquals(parsed, temps);
    assertTrue(temps.equals(temps));


  }

  @Test
  public void testHashCode(){
    ReadTemplate temp1 = new ReadTemplate();
    String parsed = temp1.parseTemplate(templateName);
    //assertNotEquals(temps.hashCode(), parsed.hashCode());

  }





}