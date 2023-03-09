package ru.mikheev.kirill.jlessons.march05.lesson.shape.hidden;

public class Circle extends Shape{
    public Circle(Point centreOfCircle, double radius) {
        this.centreOfCircle = centreOfCircle;
        this.radius = radius;
    }

    private Point centreOfCircle;
    private double radius;

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getAngleCount() {
        return 0;
    }
}
