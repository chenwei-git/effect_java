/**
 * @author chenwei
 *
 */
package chenwei.effect_java.item6;
// 1 避免创建不必要的对象
// 1.1 优先使用基本类型而不是装箱的基本类型，也要注意无意识的自动装箱。
// 1.2 这个条目不应该被误解为暗示对象创建是昂贵的，应该避免创建对象。
// 相反，使用构造方法创建和回收小的对象是非常廉价，构造方法只会做很少的显示工作，尤其是在现代JVM实现上。
// 创建额外的对象以增强程序的清晰度，简单性或功能性通常是件好事。
// 1.3. 请注意，重用防御性复制所要求的对象所付出的代价，要远远大于不必要地创建重复的对象。
// 未能在需要的情况下防御性复制会导致潜在的错误和安全漏洞；而不必要地创建对象只会影响程序的风格和性能。