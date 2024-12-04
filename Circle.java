public class Circle {

    int radius;
    final float PI = 3.14159F;

    public Circle(int radius){
        this.radius = radius;
    }

    public float calculateArea(){
        System.out.println();

        return PI*radius*radius;
    }

    public float calculateCircumference(){
        System.out.println();

        return 2*PI*radius;
    }

}
