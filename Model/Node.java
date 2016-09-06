package Model;
import java.util.*;


public class Node {
  private char value;
  private Node left, mid, right;
  private boolean isWord;
  //suggestion
  public Node(char c, boolean isWord)
  {
    this.value = c;
    this.isWord = isWord;
    this.left = null;
    this.mid = null;
    this.right = null;
  }

  public char getValue()
  {
    return this.value;
  }

  public Node getLeft() {
    return this.left;
  }

  public Node getMid() {
    return this.mid;
  }

  public Node getRight() {
    return this.right;
  }

  public void setLeft(Node n) {
    this.left = n;
  }

  public void setMid(Node n) {
    this.mid = n;
  }

  public void setRight(Node n) {
    this.right = n;
  }

  public void setIsWord(boolean b) {
    this.isWord = b;
  }

}
