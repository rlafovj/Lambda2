package com.linus.api.product;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
@Test
  public void systemOut() {
    Item s = new Item();
    String s2 = s.systemOut();
    System.out.println("-->"+s2);
    String s3 = "Hello";
    Assertions.assertEquals(s.systemOut(), "Hello");
  }
@Test
  public void add(){
  Item i = new Item();
  int i2 = i.add(2, 3);
    System.out.println("-->"+i2);
    int i3 = 5;
    Assertions.assertEquals(i2, i3);
  }
}