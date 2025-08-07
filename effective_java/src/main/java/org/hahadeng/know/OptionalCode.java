package org.hahadeng.know;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * 简单学习Optional
 * <a href="https://javabetter.cn/java8/optional.html">Java 8 Optional最佳指南，优雅解决空指针</a>
 *
 * @author 邓聪
 * @since 2025/3/26 09:47
 *
 */
public class OptionalCode {
    public static String getDefaultValue(){
        System.out.println("getDefaultValue");
        return "hello world";
    }

    public static void basicDemo(){
        Optional<Object> empty = Optional.empty();
        Optional<String> name = Optional.ofNullable("name");

        // 不管name是否为空，getDefaultValue()方法都会被执行一次
        name.orElse(getDefaultValue());
        // 只有当name为空的时候，才会执行一次getDefaultValue方法
        name.orElseGet(OptionalCode::getDefaultValue);

        String password = "12345";
        Optional<String> opt = Optional.ofNullable(password);
        System.out.println(opt.filter(p -> p.length() > 6).isPresent());

        Predicate<String> len6 = pwd -> pwd.length() > 6;
        Predicate<String> len10 = pwd -> pwd.length() < 10;
        password = "1234567";
        opt = Optional.ofNullable(password);
        boolean present = opt.filter(len6.and(len10)).isPresent();
        System.out.println(present);

    }

    public static void optionalMapFilterDemo(){
        String password = "password";
        Optional<String> opt = Optional.ofNullable(password);
        Predicate<String> len6 = pwd -> pwd.length() > 6;
        Predicate<String> len10 = pwd -> pwd.length() < 10;
        Predicate<String> eq = pwd -> pwd.equals(password);

        boolean present = opt.map(String::toLowerCase).filter(len6.and(len10).and(eq)).isPresent();
        System.out.println(present);
    }

    public static void main(String[] args) {
        // OptionalCode.t1();
        OptionalCode.optionalMapFilterDemo();
    }

}
