package problem3;

public class EmptyRegatta implements RegattaDirectory{

  @Override
  public Boolean isEmpty() {
    return Boolean.TRUE;
  }
  @Override
  public Boolean containsRegatta(String regattaName) {
    return Boolean.FALSE;
  }

  @Override
  public RegattaDirectory removeRegatta(String regattaName) throws RegattaNotFoundException {
    throw new RegattaNotFoundException("Cannot find the regatta");
  }
}
