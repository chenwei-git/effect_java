package chenwei.effect_java.item8;

import java.lang.ref.Cleaner;

//An autocloseable class using a cleaner as a safety net
public class Room implements AutoCloseable {
  private static final Cleaner cleaner = Cleaner.create();

  // Resource that requires cleaning. Must not refer to Room!
  /**
   * 一个State实例不引用它的Room实例是非常重要的。如果它引用了，则创建了一个循环，
   * 阻止了Room实例成为垃圾收集的资格(以及自动清除)。因此，State必须是静态的嵌内部类，
   * 因为非静态内部类包含对其宿主类的实例的引用(条目24)。同样，使用lambda表达式也是不明智的， 因为它们很容易获取对宿主类对象的引用。
   *
   */
  private static class State implements Runnable {
    int numJunkPiles; // Number of junk piles in this room

    State(int numJunkPiles) {
      this.numJunkPiles = numJunkPiles;
    }

    // Invoked by close method or cleaner
    @Override
    public void run() {
      System.out.println("Cleaning room");
      numJunkPiles = 0;
    }
  }

  // The state of this room, shared with our cleanable
  private final State state;

  // Our cleanable. Cleans the room when it’s eligible for gc
  private final Cleaner.Cleanable cleanable;

  public Room(int numJunkPiles) {
    state = new State(numJunkPiles);
    cleanable = cleaner.register(this, state);
  }

  @Override
  public void close() {
    cleanable.clean();
  }
}