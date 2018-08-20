/**
 * 
 */
/**
 * @author chenwei
 *
 */
package chenwei.effect_java.item10;

// 1 重写equals方法时遵守通用约定
// 1.1 不需要重写equals方法, 类的每个实例只与自身相等
// 1.1.1 每个类的实例都是固有唯一的。 对于像Thread这样代表活动实体而不是值的类来说，这是正确的。 Object提供的equals实现对这些类完全是正确的行为。
// 1.1.2 类不需要提供一个“逻辑相等（logical equality）”的测试功能。
// 1.1.3 父类已经重写了equals方法，则父类行为完全适合于该子类。
// 1.1.4 类是私有的或包级私有的，可以确定它的equals方法永远不会被调用。
// 如果你非常厌恶风险，可以重写equals方法，以确保不会被意外调用：
// @Override public boolean equals(Object o) { throw new AssertionError(); // Method is never called }
// 1.2 那什么时候需要重写 equals方法呢？如果一个类包含一个逻辑相等（ logical equality）的概念，
// 此概念有别于对象标识（object identity），而且父类还没有重写过equals方法。这通常用在值类（ value classes）的情况。
// 1.2.1 当你重写equals方法时，必须遵守它的通用约定。Object的规范如下：
// 1.2.1.1 equals方法实现了一个等价关系（equivalence relation）。它有以下这些属性:
// 1.2.1.1.1 自反性：对于任何非空引用x，x.equals(x)必须返回true。
// 1.2.1.1.2 对称性：对于任何非空引用x和y，如果且仅当y.equals(x)返回true时x.equals(y)必须返回true。
// 1.2.1.1.3 传递性：对于任何非空引用x、y、z，如果x.equals(y)返回true，y.equals(z)返回true，则x.equals(z)必须返回true。
// 除非您愿意放弃面向对象抽象的好处，否则无法继承可实例化的类，并在保留 equals 约定的同时添加一个值组件。
// 虽然没有令人满意的方法来继承一个可实例化的类并添加一个值组件，但是有一个很好的变通方法：按照条目18的建议，“优先使用组合而不是继承”。
// 你可以将值组件添加到抽象类的子类中，而不会违反equals约定。
// 1.2.1.1.4 一致性：对于任何非空引用x和y，如果在equals比较中使用的信息没有修改，则x.equals(y)的多次调用必须始终返回true或始终返回false。
// 对于任何非空引用x，x.equals(null)必须返回false。

// 1.3 编写高质量equals方法的配方
// 1.3.1 使用==运算符检查参数是否为该对象的引用。
// 1.3.2 使用instanceof运算符来检查参数是否具有正确的类型。 
// 1.3.3 参数转换为正确的类型。
// 1.3.3 对于类中的每个“重要”的属性，请检查该参数属性是否与该对象对应的属性相匹配。
// 1.4 equals方法的性能可能受到属性比较顺序的影响。
// 1.4.1 为了获得最佳性能，你应该首先比较最可能不同的属性，开销比较小的属性，或者最好是两者都满足（derived fields）。
// 1.4.2 你不要比较不属于对象逻辑状态的属性，例如用于同步操作的lock 属性。 不需要比较可以从“重要属性”计算出来的派生属性，但是这样做可以提高equals方法的性能。
// 如果派生属性相当于对整个对象的摘要描述，比较这个属性将节省在比较失败时再去比较实际数据的开销。

// 1.5 最后提醒：
// 1.5.1 当重写equals方法时，同时也要重写hashCode方法（条目 11）。
// 1.5.2 不要让equals方法试图太聪明。
// 1.5.3 在equal 时方法声明中，不要将参数Object替换成其他类型。
