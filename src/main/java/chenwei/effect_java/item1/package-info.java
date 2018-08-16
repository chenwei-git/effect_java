/**
 * 
 * 
 * @author chenwei
 *
 */
package chenwei.effect_java.item1;
// 1 考虑使用静态工厂方法替代构造方法
// 1.1 静态工厂方法的一个优点是，不像构造方法，它们是有名字的。
// 1.2 静态工厂方法的第二个优点是，与构造方法不同，它们不需要每次调用时都创建一个新对象。
// 1.3 静态工厂方法的第三个优点是，与构造方法不同，它们可以返回其返回类型的任何子类型的对象。
// 1.4 静态工厂的第四个优点是返回对象的类可以根据输入参数的不同而不同。
// 1.5 静态工厂的第5个优点是，在编写包含该方法的类时，返回的对象的类不需要存在。

// 1.6 只提供静态工厂方法的主要限制是，没有公共或受保护构造方法的类不能被子类化。
// 1.7 静态工厂方法的第二个缺点是，程序员很难找到它们。

// 1.8 命名规范
// 1.8.1
// Date d = Date.from(instant);
// Set<Rank> faceCards = EnumSet.of(JACK, QUEEN, KING);
// BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);
// StackWalker luke = StackWalker.getInstance(options);
// Object newArray = Array.newInstance(classObject, arrayLen);
// FileStore fs = Files.getFileStore(path);
// BufferedReader br = Files.newBufferedReader(path);
// List<Complaint> litany = Collections.list(legacyLitany);