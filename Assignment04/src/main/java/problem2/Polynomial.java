package problem2;

public interface Polynomial {

  Polynomial createEmpty();
  Integer getDegree();
  Integer getCoefficient(int power);
  void addTerm(int power, int coefficient);
  void removeTerm(int power);
  Boolean isSame(Polynomial polynomial);
  Polynomial add(Polynomial polynomial);
  String printPolynomial();
}
