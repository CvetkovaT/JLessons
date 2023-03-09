package ru.mikheev.kirill.jlessons.march05.lesson.shape.hidden;

public class ShapeFactory {

    public static Rectangle createRectangle(double leftUpX, double leftUpY, double rightDownX, double rightDownY) {
        return new Rectangle(
                new Point(leftUpX, leftUpY),
                new Point(rightDownX, rightDownY)
        );
    }


    public static Rectangle createSquare(double leftUpX, double leftUpY, double lineLength) {
        return new Rectangle(
                new Point(leftUpX, leftUpY),
                new Point(leftUpX + lineLength, leftUpY + lineLength)
        );
    }

    public static Triangle createTriangle(double firstPointX, double firstPointY,
                                          double secondPointX, double secondPointY,
                                          double thirdPointX, double thirdPointY){
        return new Triangle(
                new Point(firstPointX, firstPointY),
                new Point(secondPointX, secondPointY),
                new Point(thirdPointX,thirdPointY)
        );
    }

    public static Circle createCircle(double centreX, double centreY, double radius) {
        return new Circle(
                new Point(centreX, centreY),
                radius
        );
    }

//    public static Shape createShape(ShapeType shapeType, double[] params) {
//        switch (shapeType) {
//            case RECTANGLE: {
//                if(params.length != 4) throw new RuntimeException("It should be four doubles for rectangle creation");
//                return createRectangle(params[0], params[1], params[2], params[3]);
//            }
//            case CIRCLE:
//            case SQUARE:
//            case TRIANGLE:
//            default: throw new UnsupportedOperationException("There is no realisation for this shapes");
//        }
//    }
}
