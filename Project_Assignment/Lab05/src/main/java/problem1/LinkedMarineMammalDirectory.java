package problem1;

import java.util.Objects;
import java.util.Random;

public class LinkedMarineMammalDirectory implements MarineMammalDirectory{
  private MarineMammalNode headNode;
  private Integer numMarineMammals;

  public LinkedMarineMammalDirectory(MarineMammalNode headNode, Integer numMarineMammals) {
    this.headNode = headNode;
    this.numMarineMammals = numMarineMammals;
  }
  public LinkedMarineMammalDirectory(){
    this.headNode = null;
    this.numMarineMammals = 0;
  }

  /**
   * LinkedMarineMammalDirectory is a child of MarineMammalDirectory
   * and implements all the methods defined in the interface MarineMammalDirectory.
   * Therefore, any methods that can be called on a MarineMammalDirectory object
   * can also be called on a LinkedMarineMammalDirectory object.
   */
  @Override
  public MarineMammalDirectory createEmpty() {
    //upcasting
    return new LinkedMarineMammalDirectory();
  }

  @Override
  public MarineMammalDirectory add(MarineMammal marineMammal) {
    if(this.containsMammal(marineMammal)) return this;
    else{
      MarineMammalNode newMarineMammalNode = new MarineMammalNode(marineMammal, this.headNode);
      return new LinkedMarineMammalDirectory(newMarineMammalNode, this.numMarineMammals + 1);
    }
  }

  @Override
  public Boolean isEmpty() {
    return this.numMarineMammals.equals(0);
  }

  @Override
  public Integer size() {
    return this.numMarineMammals;
  }

  @Override
  public Boolean containsMammal(MarineMammal marineMammal) {
    MarineMammalNode curr = this.headNode;
    for(int i = 0; i < this.numMarineMammals - 1; i++){
      if(curr.getMarineMammal().equals(marineMammal)) return true;
      else {
        curr = curr.getNextNode();
      }
    }
    return curr.getMarineMammal().equals(marineMammal);
  }

  @Override
  public MarineMammalDirectory remove(MarineMammal marineMammal) {
    if(!this.containsMammal(marineMammal)) return this;
    if(this.headNode.getMarineMammal().equals(marineMammal)) return new LinkedMarineMammalDirectory(this.headNode.getNextNode(),
                                                      this.numMarineMammals - 1);
    else{
      MarineMammalNode curr = this.headNode;
      while(curr.getNextNode() != null){
        MarineMammalNode nodeToRemove = curr.getNextNode();
        if(nodeToRemove.getMarineMammal().equals(marineMammal)){
          //remove: curr.next = nodeToRemove.next;
          curr.setNextNode(nodeToRemove.getNextNode());
          break;
        }
        curr = curr.getNextNode();
      }
      return new LinkedMarineMammalDirectory(this.headNode, this.numMarineMammals - 1);
    }
  }

  @Override
  public MarineMammal getSomeMammal() {
    if(this.numMarineMammals == 0) return null;
    Random random = new Random();
    int randomIdx = random.nextInt(this.numMarineMammals);
    MarineMammalNode curr = this.headNode;
    for (int i = 0; i < randomIdx; i++) {
      curr = curr.getNextNode();
    }
    return curr.getMarineMammal();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LinkedMarineMammalDirectory that = (LinkedMarineMammalDirectory) o;
    return Objects.equals(headNode, that.headNode) && Objects.equals(
        numMarineMammals, that.numMarineMammals);
  }

  @Override
  public int hashCode() {
    return Objects.hash(headNode, numMarineMammals);
  }
}
