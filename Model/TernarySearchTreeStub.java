package Model;
import java.util.*;

public class TernarySearchTreeStub {
  public static void main(String[] args) {
    TernarySearchTree TST = new TernarySearchTree();
    TST.insert("hello", 0, TST.getRoot());
    TST.insert("herla", 0, TST.getRoot());
    TST.printTree(TST.getRoot());
    System.out.println(TST.getRoot().getMid().getMid().getRight().getMid());
    System.out.println(TST.getRoot().getMid().getMid());
    System.out.println(TST.getRoot().getMid().getMid().getMid());
  }
}
