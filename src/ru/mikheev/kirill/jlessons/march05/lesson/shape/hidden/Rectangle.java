package ru.mikheev.kirill.jlessons.march05.lesson.shape.hidden;

import java.util.NoSuchElementException;

public class Rectangle extends Shape {


    private Point leftUpCorner, rightDownCorner;

    Rectangle(Point leftUpCorner, Point rightDownCorner) {
        if(rightDownCorner.getY() < leftUpCorner.getY() || rightDownCorner.getX() < leftUpCorner.getX())
            throw new NoSuchElementException("wrong angles");
        if(rightDownCorner.getY() == leftUpCorner.getY() || rightDownCorner.getX() == leftUpCorner.getX())
            throw new NoSuchElementException("not a rectangle");

        this.leftUpCorner = leftUpCorner;
        this.rightDownCorner = rightDownCorner;
    }

    @Override
    public double getArea() {
     //   checkParams();
        return (rightDownCorner.getX() - leftUpCorner.getX()) * (rightDownCorner.getY() - leftUpCorner.getY());
    }

    @Override
    public double getPerimeter() {
   //     checkParams();
        return 2 * (rightDownCorner.getX() - leftUpCorner.getX() + rightDownCorner.getY() - leftUpCorner.getY());
    }

    @Override
    public double getAngleCount() {
    //    checkParams();
        return 4;
    }
}
