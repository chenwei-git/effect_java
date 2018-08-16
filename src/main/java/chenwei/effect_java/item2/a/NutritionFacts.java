package chenwei.effect_java.item2.a;

public class NutritionFacts {
  private final int servingSize;
  private final int servings;
  private final int calories;
  private final int fat;
  private final int sodium;
  private final int carbohydrate;

  /**
   * 要尽快检测无效参数，检查builder的构造方法和方法中的参数有效性。
   * 在build方法调用的构造方法中检查包含多个参数的不变性。为了确保这些不变性不受攻击，在从builder复制参数后对对象属性进行检查（条目 50）。
   * 如果检查失败，则抛出IllegalArgumentException异常（条目 72），其详细消息指示哪些参数无效（条目 75）。
   */
  public static class Builder {
    // Required parameters
    private final int servingSize;
    private final int servings;

    // Optional parameters - initialized to default values
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;

    public Builder(int servingSize, int servings) {
      this.servingSize = servingSize;
      this.servings = servings;
    }

    public Builder calories(int val) {
      calories = val;
      return this;
    }

    public Builder fat(int val) {
      fat = val;
      return this;
    }

    public Builder sodium(int val) {
      sodium = val;
      return this;
    }

    public Builder carbohydrate(int val) {
      carbohydrate = val;
      return this;
    }

    public NutritionFacts build() {
      return new NutritionFacts(this);
    }
  }

  private NutritionFacts(Builder builder) {
    servingSize = builder.servingSize;
    servings = builder.servings;
    calories = builder.calories;
    fat = builder.fat;
    sodium = builder.sodium;
    carbohydrate = builder.carbohydrate;
  }

  public static void main(String[] args) {
    NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).calories(100)
        .sodium(35).carbohydrate(27).build();
  }
}
