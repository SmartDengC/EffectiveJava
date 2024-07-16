package org.hahadeng.chapter2;

import java.util.Objects;

/**
 * @author dCong
 * @package_name:org.test
 * @date: 2024/7/17
 * @desc:
 */

public class NyPizza extends Pizza{
    // 表示大小
    public enum Size {SMALL, MEDIUM, LARGE}
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder>{
        private final Size size;

        public Builder(Size size){
            this.size = Objects.requireNonNull(size);
        }

        @Override public NyPizza build() {
            return new NyPizza(this);
        }

        @Override protected Builder self() {
            return this;
        }
    }

    private NyPizza(Builder builder){
        super(builder);
        size = builder.size;
    }



}
