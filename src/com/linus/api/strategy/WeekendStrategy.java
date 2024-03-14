package com.linus.api.strategy;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum WeekendStrategy {
  Monday("1", i -> "Monday"),
  Tuesday(),
  Wednesday(),
  Thursday(),
  Friday(),
  Saturday(),
  Sunday()
  ;

  private final String name;
  private final Function<String, String> function;

  public WeekendStrategy(String name, Function<String, String> function) {
    this.name = name;
    this.function = function;
  }

  public static String execute(Scanner sc) {
    System.out.println("1~7입력");
    String s = sc.next();

    return Stream.of(values())

            .findAny().orElseGet(() -> null)
            .function.apply(s)
            ;
  }
}
