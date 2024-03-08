package proxy;

import java.util.function.Function;

public class TypeProxy {
  public static Function<Object, String> string = String :: valueOf;
  public static Function<String , Integer> integerof = Integer::valueOf;
  public static Function<String , Double> doubleof = Double::valueOf;
  public static Function<String , Float> floatof = Float::valueOf;
  public static Function<String , Long> longof = Long::valueOf;
}
