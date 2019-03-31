package edu.neu.ccs.cs5004.Assignment8.Problem2;

/**
 * This interface contains all functionality that all Violations should support.
 */
public interface IViolations {

  /**
   * Return description of moving violation.
   *
   * @return description of moving violation
   */
  MovingViolation getMoving();

  /**
   * Return description of non-moving violation.
   * @return description of non-moving violation
   */
  NonMovingViolation getNonMoving();
}
