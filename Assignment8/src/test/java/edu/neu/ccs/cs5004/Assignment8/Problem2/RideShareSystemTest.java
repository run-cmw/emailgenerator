package edu.neu.ccs.cs5004.Assignment8.Problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
  IVehicleInsurance vehicleInsurance;
  ArrayList<IName> insuredDrivers;
  IName insured1;
  IName insured2;
  IHistory driverHistory;
  IHistory vehicleHistory;
  ArrayList<ITrafficViolation> driverViolations;
  ArrayList<ITrafficViolation> vehicleViolations;
  ITrafficViolation driverViolation;
  ITrafficViolation vehicleViolation;
  IDate violationDate;
  ArrayList<IVehicleCrash> crashes;
  IVehicleCrash crash;
  IAcceptedDriver acceptedDriver;


  @Before
  public void setUp() throws Exception {
    system = new RideShareSystem();

    // Creating vehicle insurance
    insuredDrivers = new ArrayList<>();
    name = new Name("Tommy", "Land");
    insured1 = new Name("Insured", "First");
    insured2 = new Name("Insured", "Second");
    insuredDrivers.add(insured1);
    insuredDrivers.add(insured2);
    birthday = new Date(3, 3, 1990);
    issueDate = new Date(15, 3, 2017);
    expirationDate = new Date(15, 5, 2019);
    vehicleInsurance = new VehicleInsurance(name, insuredDrivers, expirationDate, vehicle);

    // Creating Driver's License
    address = new Address("123 Made Up Street",
        "Seattle", "WA", "98008");
    license = new DriversLicense("1234567", name, address, birthday, Country.US,
        "Washington", issueDate, expirationDate);

    //Creating vehicle
    vehicle = new Vehicle("Toyota", "Camry", 2017, name);

    // Creating Driver Traffic Violations and History
    violationDate = new Date(10, 1, 2018);
    driverViolation =
        new MovingTrafficViolation(violationDate, MovingViolation.IGNORE_TRAFFIC_SIGNS);
    driverViolations = new ArrayList<>();
    driverViolations.add(driverViolation);
    driverHistory = new DriverHistory(driverViolations);

    // Creating Vehicle Traffic Violations, crashes, and history
    vehicleViolations = new ArrayList<>();
    vehicleViolation =
        new MovingTrafficViolation(violationDate, MovingViolation.IGNORE_TRAFFIC_SIGNS, name);
    vehicleViolations.add(vehicleViolation);
    crashes = new ArrayList<>();
    crash = new VehicleCrash(violationDate, Crash.FENDER_BENDER);
    crashes.add(crash);
    vehicleHistory = new VehicleHistory(vehicleViolations, crashes);

    // Creating accepted driver
    acceptedDriver = new AcceptedDriver(name, birthday, license, vehicle);
  }

  @Test
  public void registerAsProspectiveDriver() {
    assertEquals(true, system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory));
  }


  @Test
  public void getAcceptedDriversList() {
    system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory);
    ArrayList<IAcceptedDriver> drivers = system.getAcceptedDriversList();
    IAcceptedDriver driver = drivers.get(0);
    assertEquals(true, acceptedDriver.equals(driver));

  }

  @Test
  public void testEquals() {
    system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory);

    IRideShareSystem newSystem = new RideShareSystem();
    newSystem.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory);
    assertEquals(true, system.equals(newSystem));

    name = new Name("Tommy", "Lan");
    IRideShareSystem different = new RideShareSystem();
    different.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory);

    assertEquals(false, system.equals(different));

  }

  @Test
  public void testHashCode() {
    system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory);

    IRideShareSystem newSystem = new RideShareSystem();
    newSystem.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory);

    name = new Name("Tommy", "Lan");
    IRideShareSystem different = new RideShareSystem();
    different.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory);

    assertEquals(true, newSystem.hashCode() == system.hashCode());
    assertEquals(false, different.hashCode() == system.hashCode());
  }

  @Test
  public void testToString() {
    system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory);
    assertEquals("RideShareSystem - acceptedDrivers = [Driver: Tommy Land, "
            + "Vehicle: 2017 Toyota Camry]", system.toString());
  }
}