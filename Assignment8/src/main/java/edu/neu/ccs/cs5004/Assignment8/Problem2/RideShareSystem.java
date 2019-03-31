package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 * This class implements IRideShareSystem and represents a ride share system.
 */
public class RideShareSystem implements IRideShareSystem {
 private ArrayList<IAcceptedDriver> acceptedDrivers;
 private static final int MINIMUM_AGE = 21;
 private static final Country VALID_COUNTRY = Country.US;

  public RideShareSystem() {
  }

  /**
   * Validate information to determine if the driver meets rideshare acceptance requirements.
   *
   * @return true if applicant meets all requirements, false if missing at least one
   * requirement
   */
  @Override
  public boolean validateRegistration(IName name,
      IDate birthDate, IDriversLicense driversLicense, IVehicle vehicle,
      IVehicleInsurance vehicleInsurance,
      DriverHistory driverHistory, VehicleHistory vehicleHistory) {
    return false;
  }

 /**
  * Helper to check whether or not the driver is over the minimum age. Returns false if younger
  * than 21. Returns true if 21 or over.
  * @param birthday - The birthday of the driver.
  * @return - True if the driver is 21 or over, false if under 21.
  */
  private boolean validateAge(IDate birthday) {
   int currentMonth = LocalDateTime.now().getMonthValue();
   int currentDay = LocalDateTime.now().getDayOfMonth();
   int currentYear = LocalDateTime.now().getYear();

   // If the current month is greater than the birthday month (birthday month hasn't passed yet)
   // or if the current month is equal to the birthday month and the current date is greater
   // than the birthday day (birthday day and month haven't passed yet), subtract one year
   // from the current year since the birthday hasn't happened for this year yet.
   if ((currentMonth > birthday.getMonth()) ||
       (currentMonth == birthday.getMonth() && currentDay > birthday.getDay())) {
    currentYear --;
   }
   if (currentYear - birthday.getYear() >= MINIMUM_AGE) {
    return true;
   } else {
    return false;
   }
  }

 /**
  * Helper method that checks four of the following information on the driver's license.
  * 1. If the name on the license doesn't match the name provided on the application.
  * 2. If there are differences between the birthday provided on the application
  * and that of the license.
  * 3. If the license was not issued in the United States.
  * 4. If the driver license was issued less than six months ago.
  * 5. If the driver license has expired.
  * If any of the above are true, this method will return false
  * and the application will be rejected.
  * @param license - The driver license of the applicant.
  * @return - True if none of the conditions above are true,
  * false if any of the conditions are true.
  */
  private boolean checkLicenseInformation(IDriversLicense license) {
   return true;
  }

}
