package edu.neu.css.cs5004;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class CsvProcessorTest {
  protected CsvProcessor processor;
  protected CsvProcessor same;
  protected CsvProcessor different;

  @Before
  public void setUp() throws Exception {
    final String MEMBER_INFO_FILE = "insurance_company_members.csv";
    final String DIFFERENT_FILE = "different.csv";
    processor = new CsvProcessor(MEMBER_INFO_FILE);
    same = new CsvProcessor(MEMBER_INFO_FILE);
    different = new CsvProcessor(DIFFERENT_FILE);
  }

  @Test // No (expected = Exception.class) b/c exception will give file not found message due to try catch
  public void testFileNotFoundExceptionMessage() throws IOException {
    final String NON_EXISTENT_FILE = "ghost.csv";
    final List<List<String>> EMPTY_ARRAY_LIST = new ArrayList<>();
    java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
    System.setOut(new java.io.PrintStream(out));
    final String FILE_NOT_FOUND_MESSAGE = "Sorry, this file was not found: ghost.csv (The system cannot find the file specified)";
    CsvProcessor processor2 = new CsvProcessor(NON_EXISTENT_FILE);

    // test for empty Lists b/c method will continue after try catch
    assertEquals(EMPTY_ARRAY_LIST, processor2.getHeaderArrayList());
    assertEquals(EMPTY_ARRAY_LIST, processor2.getMemberInfoArrayList());
  }

  @Test (expected = Exception.class)
  public void testIOExceptionMessage() throws IOException {
    final String ADMIN_PERMISSION_FILE = "admin-permission-file.txt";

    CsvProcessor processor2 = new CsvProcessor(ADMIN_PERMISSION_FILE);
  }

  @Test
  public void testGetHeaderArrayList() {
    final String HEADER_LIST_LIST_AS_STRING = "[first_name, last_name, company_name, address, city, county, "
        + "state, zip, phone1, phone2, email, web]";

    assertEquals(HEADER_LIST_LIST_AS_STRING, processor.getHeaderArrayList().toString());
  }

  @Test
  public void testGetMemberInfoArrayList() {
    final String MEMBER_ONE_AS_STRING = "[James, Butt, Benton, John B Jr, 6649 N Blue Gum St, New Orleans, Orleans, LA, 70116, 504-621-8927, 504-845-1427, jbutt@gmail.com, http://www.bentonjohnbjr.com]";
    final String MEMBER_ONE_COMPANY_STRING = "Benton, John B Jr";

    assertEquals(MEMBER_ONE_AS_STRING, processor.getMemberInfoArrayList().get(0).toString());
    assertEquals(MEMBER_ONE_COMPANY_STRING, processor.getMemberInfoArrayList().get(0).get(2));
  }

  @Test
  public void testEquals() {
    final String DIFFERENT_DATA_TYPE1 = "first_name, last_name, company_name, address, city, county, "
        + "state, zip, phone1, phone2, email, web";
    final int DIFFERENT_DATA_TYPE2 = 0;
    final float DIFFERENT_DATA_TYPE3 = 0.5f;

    assertEquals(processor, same);
    assertEquals(processor, processor);
    assertEquals(same, same);
    assertEquals(different, different);
    assertNotEquals(processor, different);
    assertNotEquals(processor, DIFFERENT_DATA_TYPE1);
    assertNotEquals(processor, DIFFERENT_DATA_TYPE2);
    assertNotEquals(processor, DIFFERENT_DATA_TYPE3);
  }

  @Test
  public void testHashCode() {
    assertEquals(same.hashCode(), processor.hashCode());
    assertNotEquals(different.hashCode(), processor.hashCode());
  }
  
  @Test
  public void testToString() {
    final String DIFFERENT_HEADER_AS_STRING = "[first_name, last_name, city, state]";
    final String DIFFERENT_DATA_AS_STRING = "[[Avery, Wells, Baton Rouge, LA], [Clara, Wells, Seattle, WA], [Chana, Wells, Pearl, MS], [Norseen, Wells, Baton Rouge, LA], [Averon, Reed, Baton Rouge, LA]]";
    final String DIFFERENT_AS_STRING = "Header titles: " + DIFFERENT_HEADER_AS_STRING + "\n" + "Member data: " + DIFFERENT_DATA_AS_STRING;

    assertEquals(DIFFERENT_AS_STRING, different.toString());
  }
}