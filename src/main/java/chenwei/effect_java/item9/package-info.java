/**
 * @author chenwei
 *
 */
package chenwei.effect_java.item9;

// 1 使用try-with-resources语句替代try-finally语句
// 1.1 当Java 7引入了try-with-resources语句时，所有这些问题一下子都得到了解决[JLS,14.20.3]。
// 要使用这个构造，资源必须实现 AutoCloseable接口，该接口由一个返回为void的close组成。
// Java类库和第三方类库中的许多类和接口现在都实现或继承了AutoCloseable接口。
// 如果你编写的类表示必须关闭的资源，那么这个类也应该实现AutoCloseable接口。
