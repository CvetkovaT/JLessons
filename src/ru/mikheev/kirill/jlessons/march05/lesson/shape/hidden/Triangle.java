package ru.mikheev.kirill.jlessons.march05.lesson.shape.hidden;

public class Triangle extends Shape{
    public Triangle(Point firstAngle, Point secondAngle, Point thirdAngle) {
        this.firstAngle = firstAngle;
        this.secondAngle = secondAngle;
        this.thirdAngle = thirdAngle;
    }

    private Point firstAngle, secondAngle, thirdAngle;
    @Override
    public double getArea() {
        return Math.abs(
                (secondAngle.getX() - firstAngle.getX())
                * (thirdAngle.getY() - firstAngle.getY())
                - ((thirdAngle.getX() - firstAngle.getX())
                        * (secondAngle.getY() - firstAngle.getY()))
        ) / 2.0;

    }

    @Override
    public double getPerimeter() {
        return getLineLength(firstAngle, secondAngle) + getLineLength(secondAngle, thirdAngle) + getLineLength(thirdAngle, firstAngle);
    }

    @Override
    public double getAngleCount() {
        return 3;
    }

    private double getLineLength(Point first, Point second) {
        return Math.sqrt(
               Math.pow(second.getX() - first.getX(), 2) + Math.pow(second.getY() - first.getY(), 2)
        );
    }
}
