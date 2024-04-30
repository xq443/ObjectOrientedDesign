package problem3;

/**
 * Interface for the RegattaDirectory ADT.
 */
public interface RegattaDirectory {

  /**
   * Checks whether the RegattaDirectory is empty.
   *
   * @return true if the RegattaDirectory is empty, false otherwise.
   */
  Boolean isEmpty();

  /**
   * Checks if a Regatta with the requested name exists in the RegattaDirectory.
   *
   * @param regattaName the name of the Regatta to check.
   * @return true if the Regatta with the requested name exists, false otherwise.
   */
  Boolean containsRegatta(String regattaName);

  /**
   * Removes a specified Regatta from the RegattaDirectory : assume search by its name
   * If the Regatta does not exist in the RegattaDirectory, it throws a RegattaNotFoundException.
   *
   * @param regattaName the name of the Regatta to remove.
   * @throws RegattaNotFoundException if the Regatta does not exist in the RegattaDirectory.
   */
  RegattaDirectory removeRegatta(String regattaName) throws RegattaNotFoundException;
}
