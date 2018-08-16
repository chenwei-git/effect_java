package chenwei.effect_java.item2.b;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

import chenwei.effect_java.item2.b.NyPizza.Size;
/**
 * Builder模式非常适合类层次结构。 使用平行层次的builder，每个嵌套在相应的类中。 抽象类有抽象的builder;
 * 具体的类有具体的builder。
 */
public abstract class Pizza {
  public enum Topping {
    HAM, MUSHROOM, ONION, PEPPER, SAUSAGE
  }
  final Set<Topping> toppings;
  /**
   * 请注意，Pizza.Builder是一个带有递归类型参数（ recursive type parameter）（条目 30）的泛型类型。
   * 这与抽象的self方法一起，允许方法链在子类中正常工作，而不需要强制转换。
   */
  abstract static class Builder<T extends Builder<T>> {
    EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

    public T addTopping(Topping topping) {
      toppings.add(Objects.requireNonNull(topping));
      return self();
    }

    /**
     * 请注意，每个子类builder中的build方法被声明为返回正确的子类：NyPizza.Builder的build方法返回NyPizza，
     * 而Calzone.Builder中的build方法返回Calzone。
     * 这种技术，其一个子类的方法被声明为返回在超类中声明的返回类型的子类型，称为协变返回类型(covariant return typing)。
     * 它允许客户端使用这些builder，而不需要强制转换。
     */
    abstract Pizza build();
    // Subclasses must override this method to return "this"
    protected abstract T self();
  }

  Pizza(Builder<?> builder) {
    toppings = builder.toppings.clone(); // See Item 50
  }

  public static void main(String[] args) {
    NyPizza pizza = new NyPizza.Builder(Size.SMALL).addTopping(Topping.SAUSAGE)
        .addTopping(Topping.ONION).build();
    Calzone calzone = new Calzone.Builder().addTopping(Topping.HAM)
        .sauceInside().build();
  }
}
