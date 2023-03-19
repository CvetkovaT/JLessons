package ru.mikheev.kirill.jlessons.march05.lesson.shape.hidden;

import java.io.IOException;

public class Square extends Shape{

    private Point leftUpCorner;

    public Square(Point leftUpCorner, double lineLength) {
        this.leftUpCorner = leftUpCorner;
        this.lineLength = lineLength;
    }

    private double lineLength;
    @Override
    public double getArea() {
        return Math.pow(lineLength, 2);
    }

    @Override
    public double getPerimeter() {
        return 4 * lineLength;
    }

    @Override
    public double getAngleCount() throws IOException {
        return 4;
    }
}
