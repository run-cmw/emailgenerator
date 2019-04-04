package edu.neu.ccs.cs5004.assignment8.problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AcceptedDriverTest {
  IAcceptedDriver accepted;
  IName name;
  IDate birthday;
  IDriversLicense license;
  IVehicle vehicle;
  IDate issueDate;
  IDate expirationDate;
  IAddress address;

  @Before
  public void setUp() throws Exception {
    name = new Name("Tommy", "Land");
    birthday = new Date(3, 3, 1990);
    issueDate = new Date(15, 3, 2017);
    issueDate = new Date(15, 5, 2019);
    address = new Address("123 Made Up Street",
        "Seattle", "WA", "98008");
    license = new DriversLicense("1234567", name, address, birthday, Country.US,
        "Washington", issueDate, expirationDate);
    vehicle = new Vehicle("Toyota", "Camry", 2017, name);
    accepted = new AcceptedDriver(name, birthday, license, vehicle);
  }

  @Test
  public void getName() {
    assertEquals(name.toString(), accepted.getName().toString());
  }

  @Test
  public void getBirthday() {
    assertEquals(birthday.toString(), accepted.getBirthday().toString());
  }

  @Test
  public void getLicense() {
    assertEquals(license, accepted.getLicense());
  }

  @Test
  public void getVehicle() {
    assertEquals(vehicle, accepted.getVehicle());
  }

  @Test
  public void equalHashCode() {
    IAcceptedDriver same = new AcceptedDriver(name, birthday, license, vehicle);
    assertEquals(same.hashCode(), accepted.hashCode());

  }

  @Test
  public void differentHashCode() {
    license = new DriversLicense("123456", name, address, birthday, Country.US,
        "Washington", issueDate, expirationDate);
    IAcceptedDriver different = new AcceptedDriver(name, birthday, license, vehicle);
    assertNotEquals(different.hashCode(), accepted.hashCode());
  }

  @Test
  public void equals() {
    IAcceptedDriver same = new AcceptedDriver(name, birthday, license, vehicle);
    assertEquals(true, same.equals(same));
    assertEquals(true, same.equals(accepted));
    assertEquals(false, same.equals(license));

    // Different license
    license = new DriversLicense("123456", name, address, birthday, Country.US,
        "Washington", issueDate, expirationDate);
    IAcceptedDriver different = new AcceptedDriver(name, birthday, license, vehicle);
    assertEquals(false, different.equals(accepted));

    // Different Birthday
    birthday = new Date(2, 2, 1970);
    different = new AcceptedDriver(name, birthday, license, vehicle);
    assertEquals(false, different.equals(accepted));

    // Different name
    name = new Name("Tom", "Tom");
    different = new AcceptedDriver(name, birthday, license, vehicle);
    assertEquals(false, different.equals(accepted));


  }

  @Test
  public void testToString() {
    assertEquals("Driver: Tommy Land, Vehicle: 2017 Toyota Camry", accepted.toString());

  }
}