package org.hahadeng.chapters4.item23;

/**
 * @author 邓聪
 */
public class Rectangle extends Figure{

    final double width;
    final double length;

    Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }

    @Override
    double area() {
        return width * length;
    }
}
