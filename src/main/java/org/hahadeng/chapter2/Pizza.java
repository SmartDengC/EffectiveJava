package org.hahadeng.chapter2;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author: HaHaDeng
 */
public abstract class Pizza {

    /**
     * 一个Topping的枚举类
     */
    public enum Topping {HAM,ONION, PEPPER}

    /**
     * 一个Topping的集合
     */
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>>{
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping){
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }
        abstract Pizza build();

        // 子类必须重写该方法来返回this
        protected abstract T self();
    }

    Pizza(Builder<?> builder){
        toppings = builder.toppings.clone();
    }

}
