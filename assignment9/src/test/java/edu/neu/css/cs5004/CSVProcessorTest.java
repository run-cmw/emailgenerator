package edu.neu.css.cs5004;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
  public void testIOException() throws IOException {
    final String NON_EXISTENT_FILE = "ghost.csv";
    CSVProcessor processor2 = new CSVProcessor(NON_EXISTENT_FILE);


  }

  @Test
  public void testParseHeader() {
    final String HEADER_LIST_LIST_AS_STRING = "[[first_name], [last_name], [company_name], [address], [city], [county], "
        + "[state], [zip], [phone1], [phone2], [email], [web]]";

    assertEquals(HEADER_LIST_LIST_AS_STRING, processor.headerArrayList.toString());
  }

  @Test
  public void testParseMemberInfo() {
    final String MEMBER_ONE_AS_STRING = "[James, Butt, Benton, John B Jr, 6649 N Blue Gum St, New Orleans, Orleans, LA, 70116, 504-621-8927, 504-845-1427, jbutt@gmail.com, http://www.bentonjohnbjr.com]";
    final String MEMBER_ONE_COMPANY_STRING = "Benton, John B Jr";

    assertEquals(MEMBER_ONE_AS_STRING, processor.memberInfoArrayList.get(0).toString());
    assertEquals(MEMBER_ONE_COMPANY_STRING, processor.memberInfoArrayList.get(0).get(2));
  }

//  @Test
//  public void testHeaderEquals() {
//    final String DIFFERENT_DATA_TYPE1 = "first_name, last_name, company_name, address, city, county, "
//        + "state, zip, phone1, phone2, email, web";
//    final int DIFFERENT_DATA_TYPE2 = 0;
//    final float DIFFERENT_DATA_TYPE3 = 0.5f;
//    final CSVProcessor DIFFERENT_DATA_TYPE4 = processor;
//
//    assertEquals(headerArrayList, sameHeaderList);
//    assertEquals(headerArrayList, headerArrayList);
//    assertEquals(sameHeaderList, sameHeaderList);
//    assertEquals(differentHeaderList, differentHeaderList);
//    assertNotEquals(headerArrayList, differentHeaderList);
//    assertNotEquals(headerArrayList, DIFFERENT_DATA_TYPE1);
//    assertNotEquals(headerArrayList, DIFFERENT_DATA_TYPE2);
//    assertNotEquals(headerArrayList, DIFFERENT_DATA_TYPE3);
//    assertNotEquals(headerArrayList, DIFFERENT_DATA_TYPE4);
//  }
//
//  @Test
//  public void testInfoEquals() {
//    final String DIFFERENT_DATA_TYPE1 = "James, Butt, Benton, John B Jr, 6649 N Blue Gum St, "
//        + "New Orleans, Orleans, LA, 70116, 504-621-8927, 504-845-1427, "
//        + "jbutt@gmail.com, http://www.bentonjohnbjr.com";
//    final int DIFFERENT_DATA_TYPE2 = 0;
//    final float DIFFERENT_DATA_TYPE3 = 0.5f;
//    final CSVProcessor DIFFERENT_DATA_TYPE4 = processor;
//
//
//    assertEquals(memberInfoArrayList, sameMemberInfoList);
//    assertEquals(memberInfoArrayList, memberInfoArrayList);
//    assertEquals(sameMemberInfoList, sameMemberInfoList);
//    assertEquals(differentMemberInfoList, differentMemberInfoList);
//    assertNotEquals(memberInfoArrayList, differentMemberInfoList);
//    assertNotEquals(memberInfoArrayList, DIFFERENT_DATA_TYPE1);
//    assertNotEquals(memberInfoArrayList, DIFFERENT_DATA_TYPE2);
//    assertNotEquals(memberInfoArrayList, DIFFERENT_DATA_TYPE3);
//    assertNotEquals(memberInfoArrayList, DIFFERENT_DATA_TYPE4);
//  }
}