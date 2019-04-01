package edu.neu.ccs.cs5004.Assignment8.Problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RideShareSystemTest {
  IRideShareSystem system;
  IName name;
  IDate birthday;
  IDriversLicense license;
  IVehicle vehicle;
  IDate issueDate;
  IDate expirationDate;
  IAddress address;

  @Before
  public void setUp() throws Exception {
    system = new RideShareSystem();
    name = new Name("Tommy", "Land");
    birthday = new Date(3, 3, 1990);
    issueDate = new Date(15, 3, 2017);
    issueDate = new Date(15, 5, 2019);
    address = new Address("123 Made Up Street",
        "Seattle", "WA", "98008");
    license = new DriversLicense("1234567", name, address, birthday, Country.US,
        "Washington", issueDate, expirationDate);
    vehicle = new Vehicle("Toyota", "Camry", 2017, name);

//    (IName name, IDate birthDate, IDriversLicense driversLicense,
  //      IVehicle vehicle, IVehicleInsurance vehicleInsurance, DriverHistory driverHistory,
    //    VehicleHistory vehicleHistory)
  }

  @Test
  public void registerAsProspectiveDriver() {
  }

  @Test
  public void validateRegistration() {
  }

  @Test
  public void getAcceptedDriversList() {
  }

  @Test
  public void testEquals() {
  }

  @Test
  public void testHashCode() {
  }

  @Test
  public void testToString() {
  }
}