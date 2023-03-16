package ru.mikheev.kirill.jlessons.march05.lesson.complex;


import static java.lang.Math.pow;

public class ComplexNumber implements Number {

    private final double re, im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    /**
     * Метод прибавляет к текущему числу другое
     *
     * @param anotherNumber - Первое слагаемое
     * @return результат сложения
     */
    @Override
    public Number add(Number anotherNumber) {
        if(anotherNumber instanceof ComplexNumber) {
            return add((ComplexNumber) anotherNumber);
        }
        return new ComplexNumber(re + anotherNumber.getNumberModulo(), im);
    }

    public ComplexNumber add(ComplexNumber anotherNumber) {
        return new ComplexNumber(
                re + anotherNumber.re,
                im + anotherNumber.im
        );
    }

    /**
     * Метод вычитает из текущего числа другое
     *
     * @param anotherNumber - Вычитаемое
     * @return результат вычитания
     */
    @Override
    public Number sub(Number anotherNumber) {
        if(anotherNumber instanceof ComplexNumber) {
            return sub((ComplexNumber) anotherNumber);
        }
        return new ComplexNumber(re - anotherNumber.getNumberModulo(), im);
    }

    public ComplexNumber sub(ComplexNumber anotherNumber) {
        return new ComplexNumber(
                re - anotherNumber.re,
                im - anotherNumber.im
        );
    }

    @Override
    public Number multiply(Number anotherNumber) {
        if(anotherNumber instanceof ComplexNumber){
            return multiply((ComplexNumber) anotherNumber);
        }
        return new ComplexNumber(
                re * anotherNumber.getNumberModulo(),
                im * anotherNumber.getNumberModulo()
        );
    }

    public ComplexNumber multiply(ComplexNumber anotherNumber) {
        return new ComplexNumber(
                re * anotherNumber.re - im * anotherNumber.im,
                re * anotherNumber.im + im * anotherNumber.re
        );
    }

    @Override
    public Number div(Number anotherNumber) {
        if (anotherNumber instanceof ComplexNumber){
            return div((ComplexNumber) anotherNumber);
        }
        return new ComplexNumber(
                re/anotherNumber.getNumberModulo(),
                im/anotherNumber.getNumberModulo()
        );
    }

    public ComplexNumber div(ComplexNumber anotherNumber){
        ComplexNumber tmp = new ComplexNumber(re, im);
        tmp = tmp.multiply(conjugate(anotherNumber));
        return new ComplexNumber(
                tmp.re / anotherNumber.multiplicationByInverse(),
                tmp.im / anotherNumber.multiplicationByInverse()
        );
    }

    @Override
    public double getNumberModulo() {
        return Math.sqrt(re*re + im*im);
    }



    private ComplexNumber conjugate(ComplexNumber complexNumber) {
        return new ComplexNumber(complexNumber.re, -1 * complexNumber.im);
    }

    private double multiplicationByInverse(){
        return pow(re, 2) + im * im;
    }

    @Override
    public String toString() {
        return "ComplexNumber{" +
                "re=" + re +
                ", im=" + im +
                '}';
    }

}
