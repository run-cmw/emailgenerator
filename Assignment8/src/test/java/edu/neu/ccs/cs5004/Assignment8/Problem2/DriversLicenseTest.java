package edu.neu.ccs.cs5004.Assignment8.Problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DriversLicenseTest {
  private IDriversLicense driversLicense;
  private IName name;
  private IAddress address;
  private IDate birthDate;
  private IDate issueDate;
  private Date expirationDate;

  private IDriversLicense same;
  private IDriversLicense different;


  @Before
  public void setUp() throws Exception {
    name = new Name("Unicorn", "Goddess");
    address = new Address("1039 45th Street #6", "Emeryville", "CA", "94608");
    birthDate = new Date(20, 3, 1989);
    issueDate = new Date(1, 7, 2017);
    expirationDate = new Date(30, 4, 2020);
    driversLicense = new DriversLicense("abc123", name, address, birthDate, Country.US, "Louisiana", issueDate, expirationDate);

    same = new DriversLicense("abc123", name, address, birthDate, Country.US, "Louisiana", issueDate, expirationDate);
    Date differentExpDate = new Date(31, 12, 2019);
    different = new DriversLicense("abc123", name, address, birthDate, Country.US, "Louisiana", issueDate, differentExpDate);
  }

  @Test
  public void getLicenseNumber() {
    assertEquals("abc123", driversLicense.getLicenseNumber());
  }

  @Test
  public void getDriverName() {
    final String NAME_AS_STRING = "Unicorn Goddess";

    assertEquals(NAME_AS_STRING, driversLicense.getDriverName().toString());
  }

  @Test
  public void getDriverAddress() {
    final String ADDRESS_AS_STRING = "1039 45th Street #6\nEmeryville, CA 94608";

    assertEquals(ADDRESS_AS_STRING, driversLicense.getDriverAddress().toString());
  }

  @Test
  public void getDriverBirthDate() {
    final String DATE_AS_STRING = "3/20/1989";

    assertEquals(DATE_AS_STRING, driversLicense.getDriverBirthDate().toString());
  }

  @Test
  public void getIssuingCountry() {
    assertEquals(Country.US, driversLicense.getIssuingCountry());
  }

  @Test
  public void getIssuingState() {
    assertEquals("Louisiana", driversLicense.getIssuingState());
  }

  @Test
  public void getIssueDate() {
    final String DATE_AS_STRING = "7/1/2017";

    assertEquals(DATE_AS_STRING, driversLicense.getIssueDate().toString());
  }

  @Test
  public void getExpirationDate() {
    final String DATE_AS_STRING = "4/30/2020";

    assertEquals(DATE_AS_STRING, driversLicense.getExpirationDate().toString());
  }

  @Test
  public void equals() {
    assertTrue(same.equals(driversLicense));
    assertTrue(same.equals(same));
    assertFalse(different.equals(driversLicense));
    assertFalse(same.equals(2));
  }

  @Test
  public void equalHashCode() {
    assertEquals(same.hashCode(), driversLicense.hashCode());
  }

  @Test
  public void differentHashCode() {
    assertNotEquals(different.hashCode(), driversLicense.hashCode());
  }

  @Test
  public void testToString() {
    final String LICENSE_AS_STRING = "License number: abc123, Driver: Unicorn Goddess, Expiration date: 4/30/2020";

    assertEquals(LICENSE_AS_STRING, driversLicense.toString());
  }
}