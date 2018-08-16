package chenwei.effect_java.item8;

public class Adult {
  /**
   * 就像我们之前说的，Room的Cleaner机制仅仅被用作一个安全网。 如果客户将所有Room的实例放在try-with-resource块中，
   * 则永远不需要自动清理。行为良好的客户端如下所示
   */
  public static void main(String[] args) {
    try (Room myRoom = new Room(7)) {
      System.out.println("Goodbye");
    }
  }
}
