/**
 * @author chenwei
 *
 */
package chenwei.effect_java.item8;

// 1 避免使用Finalizer和Cleaner机制
// 总之，除了作为一个安全网或者终止非关键的本地资源，不要使用Cleaner机制，或者是在Java 9发布之前的finalizers机制。
// 即使是这样，也要当心不确定性和性能影响。