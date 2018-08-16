package chenwei.effect_java.item8;

public class Teenager {
  /**
   * 你可能期望它打印出Peace out，然后打印Cleaning room字符串，但在我的机器上，它从不打印Cleaning room字符串；仅仅是程序退出了。 这是我们之前谈到的不可预见性。 Cleaner机制的规范说：“System.exit方法期间的清理行为是特定于实现的。 不保证清理行为是否被调用。”虽然规范没有说明，但对于正常的程序退出也是如此。 在我的机器上，将System.gc()方法添加到Teenager类的main方法足以让程序退出之前打印Cleaning room，但不能保证在你的机器上会看到相同的行为。 
   */
  public static void main(String[] args) {
    new Room(99);
    System.out.println("Peace out");
    System.gc();
  }
}
