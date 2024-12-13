package org.hahadeng.chapters4.item23;

/**
 * @author 邓聪
 */
public class Circle extends Figure{
    final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}
