# 对第二章内容总结以及需要掌握的内容

## 原书内容
### 条目1：用静态工厂方法代替构造器
- 静态工厂方法的第一个优点，与构造器不同，他们有名称
- 静态工厂方法的第二个优点，与构造器不同，不用在每次被调用时都创建一个新对象
- 静态工厂方法的第三个优点，与构造器不同，他们可以返回所声明的返回类型的任何子类型的对象
- 静态工厂方法的第四个优点，在方法每次被调用时，所返回的对象的类可以随输入参数的不同而改变
- 静态工厂方法的第五个优点，在编写包含该方法的类时，所返回对象的类并不一定要存在


## 内部类

非静态内部类：[OutClass](./inner/OuterClass.java)  
静态内部类： [OutClass2](./inner/OutClass2.java)  
匿名内部类： [MyInterface](./inner/MyInterface.java)  


## Java的关键词 static abstract

### static
static可以修饰类，方法，变量，代码块。  

static method 静态方法， 整个Class共享的method  
not-static method 实例方法，具体实例的method  

static variable   静态变量，全Class  
instance variable   实例变量， 具体的某个实例

```java
public class Tree {
    public static String name;

    public static String callName(String name){
        return name;
    }

    public static void main(String[] args) {
        // Pine Tree
        System.out.println(Tree.callName("Pine Tree"));  
        Tree.name = "Aspen";
        // Aspen
        System.out.println(Tree.name);
    }
}
```
不管是静态方法，还是静态变量都是使用Class名.method Or Class名.variable
