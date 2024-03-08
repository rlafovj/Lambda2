package proxy;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MathProxy {
  public static Function<Integer, Integer> absInt = Math::abs;
  public static BiFunction<Integer, Integer, Integer> maxInt = Math::max;
  public static BiFunction<Long, Long, Long> maxLong = Math::max;
  public static BiFunction<Double, Double, Double> maxDouble = Math::max;
  public static BiFunction<Float, Float, Float> maxFloat = Math::max;
  public static BiFunction<Integer, Integer, Integer> minInt = Math::min;
  public static BiFunction<Long, Long, Long> minLong = Math::min;
  public static BiFunction<Double, Double, Double> minDouble = Math::min;
  public static BiFunction<Float, Float, Float> minFloat = Math::min;
  public static BiFunction<Double, Double, Double> powDouble = Math::pow;
  public static Function<Integer, Double> sqrtDouble = Math::sqrt;
  public static Supplier<Double> randomDouble = Math::random;
  public static BiFunction<Integer, Integer, Integer> randomInt = (a, b) -> (int)(Math.random()*(b-a)+a);

  //Integer.parseInt
}
