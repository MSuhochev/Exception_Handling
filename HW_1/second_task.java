package Home_Works.HW_1;
// Если необходимо, исправьте данный код 
//(задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)

public class second_task {
    public static void main(String[] args) {

        try {
            int d = 0;
            //объявляем массив и заполняем его 
            double[] intArray = new double[] {1.2d, 2, 3, 4, 5, 6, 7, 8, 9.4d};
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
         } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
         }
         
    }
}
