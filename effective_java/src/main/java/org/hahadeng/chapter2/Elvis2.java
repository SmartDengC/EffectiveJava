package org.hahadeng.chapter2;

/**
 * 使用枚举来实现单例模式
 */
public enum Elvis2 {
    INSTANCE;
    Integer value;

    private Elvis2(){
        this.value = 1;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}

