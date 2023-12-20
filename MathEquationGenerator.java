/*
this program takes an integer as input, and then generates a math equation
that has that integer as the answer
*/

// import
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Program{
    // defining methods
    // random_integer: line 21
    // return_list: line 26
    // addition: line 35
    // subtraction: line 44
    // multiplication: line 54
    // division: line 72
    // make_equation: line 81

    public static int random_integer(int min, int max){
        // this method generates a random integer anywhere between min and max
        int range = max - min + 1;
        return (int)(Math.random() * range) + min;
    }
    public static List<Integer> return_list(int x, int y){
        // this method is used in the additon, subtraction, multiplication, and division
        // methods, it is used so this code doesnt have to be repeated for all of them
        // they just need to use return return_list(x, y);
        List<Integer> L = new ArrayList<>();
        L.add(x);
        L.add(y);
        return L;
    }
    public static List<Integer> addition(int z){
        // this method turns one integer into an addition problem
        // with the integer as the answer
        // 5 >>> 3 + 2
        // x + y = z
        int x = random_integer(z - 100, z);
        int y = z - x; // algebra: (x + y = z) so then (y = z - x)
        return return_list(x, y);
    }
    public static List<Integer> subtraction(int z){
        // this method turns one integer into a subtraction problem
        // with the integer as the answer
        // 5 >>> 7 + 2
        // x - y = z
        int y = random_integer(z, z + 100);
        int x = z + y; // algebra: (x - y = z) so then (x = z + y))
        List<Integer> L = new ArrayList<>();
        return return_list(x, y);
    }
    public static List<Integer> multiplication(int z){
        // this method turns one integer into a multiplication problem
        // with the integer as the answer
        // 6 >>> 3 * 2
        // x * y = z
        int x = 0; // x is 0 so it goes into the while loop, unless z == 0
        int y = 0; // have to set y to an int now, so it doesnt cause an error
        if (z == 0){ // is z is 0, it cant do 0/0 so its sets y to a random number because 0 * anything = 0
            y = random_integer(z -100, z + 100);
        }
        else{
            while (((z/x)%1!=0) || (x == 0)){ // loops until z/x is a whole number and x isnt 0
                x = random_integer(z - 100, z);
                y = z/x; // algebra: (x * y = z) so then (y = z / x)
            }
        }
        return return_list(x, y);
    }
    public static List<Integer> division(int z){
        // this method turns one integer into a division problem
        // with the integer as the answer
        //6 >>> 12 / 2
        // x / y = z
        int y = random_integer(z - 100, z + 100);
        int x = y * z; // algebra: (x / y = z) so then (x = y * z)
        return return_list(x, y);
    }
    public static String make_equation(int z){
        int operation = random_integer(1, 4);
        String equation = "";
        if (operation == 1){
            List<Integer> e = addition(z);
            equation = e.get(0) + " + " + e.get(1) + " = " + z;
        }
        else if (operation == 2){
            List<Integer> e = subtraction(z);
            equation = e.get(0) + " - " + e.get(1) + " = " + z;
        }
        else if (operation == 3){
            List<Integer> e = multiplication(z);
            equation = e.get(0) + " * " + e.get(1) + " = " + z;
        }
        else if (operation == 4){
            List<Integer> e = division(z);
            equation = e.get(0) + " / " + e.get(1) + " = " + z;
        }
        return equation;
    }
    public static void main(String[] args) {
        // this is where the actual program starts
        try{
            Scanner input = new Scanner(System.in);
            System.out.println("Enter Number: ");
            int z = input.nextInt();
            System.out.println(make_equation(z));
        }
        catch (Exception e){ // this is if you input something other than an integer
            System.out.println("INVALID INPUT!");
        }
    }
}