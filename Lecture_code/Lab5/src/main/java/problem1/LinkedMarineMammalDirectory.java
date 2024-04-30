package problem1;

import java.util.Objects;

public class LinkedMarineMammalDirectory implements MarineMammalDirectory{

    private MarineMammalNode headNode;
    private Integer numMarineMammals;

    public LinkedMarineMammalDirectory(MarineMammalNode headNode,
                                       Integer numMarineMammals) {
        this.headNode = headNode;
        this.numMarineMammals = numMarineMammals;
    }

    public LinkedMarineMammalDirectory() {
        this.headNode = null;
        this.numMarineMammals = 0;
    }

    @Override
    public MarineMammalDirectory createEmpty() {
        return new LinkedMarineMammalDirectory();
    }

    @Override
    public MarineMammalDirectory add(MarineMammal marineMammal) {
        if(this.containsMammal(marineMammal)) {
            return this;
        }
        else{
            MarineMammalNode newMammalNode = new MarineMammalNode(marineMammal, this.headNode);
            return new LinkedMarineMammalDirectory(newMammalNode, this.numMarineMammals + 1);
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
        MarineMammalNode currNode = this.headNode;
        for(int i = 0; i < this.numMarineMammals - 1; i++){
            if(currNode.getMarineMammal().equals(marineMammal))
                return true;
            else {
                currNode = currNode.getNextNode();
            }
        }
        return currNode.getMarineMammal().equals(marineMammal);
    }

    @Override
    public MarineMammalDirectory remove(MarineMammal marineMammal) {
        if(!this.containsMammal(marineMammal))
            return this;
        if(this.headNode.getMarineMammal().equals(marineMammal))
            return new LinkedMarineMammalDirectory(this.headNode.getNextNode(),
                    this.numMarineMammals - 1);
        else {
            MarineMammalNode currNode = this.headNode;
            while (currNode.getNextNode() != null) {
                MarineMammalNode nodeToRemove = currNode.getNextNode();
                if (nodeToRemove.getMarineMammal().equals(marineMammal)) {
                    currNode.setNextNode(nodeToRemove.getNextNode());
                    break;
                }
                currNode = currNode.getNextNode();
            }
            return new LinkedMarineMammalDirectory(this.headNode, this.numMarineMammals - 1);
        }
    }

    @Override
    public MarineMammal getSomeMammal() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedMarineMammalDirectory that = (LinkedMarineMammalDirectory) o;
        return Objects.equals(headNode, that.headNode) && Objects.equals(numMarineMammals, that.numMarineMammals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(headNode, numMarineMammals);
    }
}
