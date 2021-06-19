import java.util.Random;
import java.util.Scanner;

public class squareRootAlgorithm {
    /**
     * Implementing the binary search method to find the
     * ceiling square root value of a number
     * @param number the number to find the square root off
     * @return the ceiling square root value of the number
     */
    public static int binarySearch(int number){
        if(number == 0){
            return 0;
        }
        int left = 0;
        int right = number;
        int middle;
        int middleSquare;
        int middleMinusOneSquare;

        while(left <= right) {
            middle = (left + right) / 2;
            middleSquare = middle * middle;
            middleMinusOneSquare = ((middle - 1) * (middle - 1));
            if(middleSquare >= number && middleMinusOneSquare < number) {
                return middle;
            } else if(middleSquare > number) {
                right = middle;
            }
            else if(middleSquare < number){
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void menu(){
        System.out.println("1.Enter a number to get the ceiling value of the square root");
        System.out.println("2.Get a random number to find the ceiling value of the square root");
        System.out.println("3.Press 3 to Quit");
        System.out.print("What option would you like: ");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner((System.in));
        menu();
        int option = in.nextInt();
        while(option != 3){
            if(option <= 0 || option > 3){
                System.out.println("\nYou entered an invalid option");
                System.out.print("Enter a new option: ");
                option = in.nextInt();
            }
            if(option == 1){
                System.out.print("\nWhat positive number would you like to see the square root off: ");
                int num = in.nextInt();
                while(num < 0){
                    System.out.println("The number cannot be negative");
                    System.out.print("Enter a positive number: ");
                    num = in.nextInt();
                }
                int squareRootValue = binarySearch(num);
                System.out.println("The ceiling square root value " + num + " is: " + squareRootValue + "\n");
                menu();
                option = in.nextInt();
            }
            else if(option == 2){
                Random rand = new Random();
                int randNum = rand.nextInt(100) + 1;
                int randSquareRoot = binarySearch(randNum);
                System.out.println("\nThe ceiling square root of " + randNum + " is: " + randSquareRoot + "\n");
                menu();
                option = in.nextInt();
            }
        }
        if(option == 3){
            System.out.println("See Ya Later!!!");
        }
    }
}
