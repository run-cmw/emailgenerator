package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.Objects;

public class VehicleCrash implements IVehicleCrash {
  private IDate date;
  private Crash crash;

  public VehicleCrash(IDate date, Crash crash) {
    this.date = date;
    this.crash = crash;
  }

  /**
   * Returns the date of the crash.
   *
   * @return date of the crash.
   */
  @Override
  public IDate getCrashDate() {
    return this.date;
  }

  /**
   * Returns the type of crash (from enum Crash).
   *
   * @return the type of crash.
   */
  @Override
  public Crash getCrash() {
    return this.crash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    VehicleCrash other = (VehicleCrash) obj;
    return Objects.equals(this.date, other.date) &&
        this.crash == other.crash;
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, crash);
  }

  @Override
  public String toString() {
    return "VehicleCrash{" +
        "date=" + date +
        ", crash=" + crash +
        '}';
  }
}
