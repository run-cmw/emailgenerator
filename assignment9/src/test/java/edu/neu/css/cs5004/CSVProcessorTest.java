package edu.neu.css.cs5004;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class CSVProcessorTest {
  protected CSVProcessor processor;
  protected CSVProcessor same;
  protected CSVProcessor different;

  @Before
  public void setUp() throws Exception {
    final String MEMBER_INFO_FILE = "insurance_company_members.csv";
    final String DIFFERENT_FILE = "different.csv";
    processor = new CSVProcessor(MEMBER_INFO_FILE);
    same = new CSVProcessor(MEMBER_INFO_FILE);
    different = new CSVProcessor(DIFFERENT_FILE);
  }

  @Test
  public void testIOExceptionMessage() throws IOException {
    final String NON_EXISTENT_FILE = "ghost.csv";

    // Because of try catch, exception will give a message.
    // So no (expected = Exception.class after @Test)
    CSVProcessor processor2 = new CSVProcessor(NON_EXISTENT_FILE);
  }

  @Test
  public void testGetHeaderArrayList() {
    final String HEADER_LIST_LIST_AS_STRING = "[[first_name], [last_name], [company_name], [address], [city], [county], "
        + "[state], [zip], [phone1], [phone2], [email], [web]]";

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
    final String DIFFERENT_HEADER_AS_STRING = "[[first_name], [last_name], [city], [state]]";
    final String DIFFERENT_DATA_AS_STRING = "[[Avery, Wells, Baton Rouge, LA], [Clara, Wells, Seattle, WA], [Chana, Wells, Pearl, MS], [Norseen, Wells, Baton Rouge, LA], [Averon, Reed, Baton Rouge, LA]]";
    final String DIFFERENT_AS_STRING = "Header titles: " + DIFFERENT_HEADER_AS_STRING + "\n" + "Member data: " + DIFFERENT_DATA_AS_STRING;

    assertEquals(DIFFERENT_AS_STRING, different.toString());
  }
}