import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    // Create a public constructor function named Order
    // Parameters: an ArrayList of Cupcake objects named cupcakeMenu, and an ArrayList of Drink objects named drinkMenu.
    public Order(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu) {
        System.out.println("Hello customer. Would you like to place an order? (Y or N)");
        Scanner input = new Scanner(System.in);
        String placeOrder = input.nextLine();
        //Create an Arraylist of Objects and name it order. Note: we are creating an ArrayList of Objects so any objects can be added to the ArrayList - they do not have to all be the same type.
        ArrayList<Object> order = new ArrayList<Object>();
        if(placeOrder.equalsIgnoreCase("Y")) {
            order.add(LocalDate.now());
            order.add(LocalTime.now());
            System.out.println("Here is the menu.");
            System.out.println("CUPCAKES:");
            int itemNumber = 0;
            for(int i = 0; i < cupcakeMenu.size(); i++) {
                itemNumber++;
                System.out.println(itemNumber);
                // Print a description of the cupcake at cupcakeMenu at index i
                cupcakeMenu.get(i).type();
                System.out.println("Price:"+ cupcakeMenu.get(i).getPrice());
                System.out.println();
            }

            System.out.println("DRINKS:");
            for(int i = 0; i < drinkMenu.size(); i++) {
                itemNumber++;
                System.out.println(itemNumber);
                drinkMenu.get(i).type();
                System.out.println("Price:"+ drinkMenu.get(i).getPrice());
                System.out.println();
            }
        }
        else {
            System.out.println("Have a nice day then.");
        }

        boolean ordering = true;
        while(ordering) {
            System.out.println("What would you like to order? Please use the number associated with each item to order.");
            int orderChoice = input.nextInt();
            //Call input.nextLine() to correct the terminal scanner input location.
            input.nextLine();
            if(orderChoice == 1) {
                order.add(cupcakeMenu.get(0));
                System.out.println("Item added to order");
            } else if (orderChoice == 2) {
                order.add(cupcakeMenu.get(1));
                System.out.println("Item added to order");
            }else if (orderChoice == 3) {
                order.add(cupcakeMenu.get(2));
                System.out.println("Item added to order");
            }else if (orderChoice == 4) {
                order.add(drinkMenu.get(0));
                System.out.println("Item added to order");
            }else if (orderChoice == 5) {
                order.add(drinkMenu.get(1));
                System.out.println("Item added to order");
            }else if (orderChoice == 6) {
                order.add(drinkMenu.get(2));
                System.out.println("Item added to order");
            }
            else {
                System.out.println("Sorry, we don’t seem to have that on the menu.");
            }
            System.out.println("Would you like to continue ordering? (Y/N)");
            String continueOrder = input.nextLine();
            if(!continueOrder.equalsIgnoreCase("Y")) {
                ordering=false;
            }
        }
        System.out.println(order.get(0));
        System.out.println(order.get(1));
        double subTotal = 0.0;
        for(int i = 2; i < order.size(); i++) {
            if(order.get(i).equals(cupcakeMenu.get(0))) {
                cupcakeMenu.get(0).type();
                System.out.println(cupcakeMenu.get(0).getPrice());
                subTotal += cupcakeMenu.get(0).getPrice();
            } if(order.get(i).equals(cupcakeMenu.get(0))) {
                cupcakeMenu.get(0).type();
                System.out.println(cupcakeMenu.get(0).getPrice());
                subTotal += cupcakeMenu.get(0).getPrice();
            } else if (order.get(i).equals(cupcakeMenu.get(1))) {
                cupcakeMenu.get(1).type();
                System.out.println(cupcakeMenu.get(1).getPrice());
                subTotal += cupcakeMenu.get(1).getPrice();
            }else if (order.get(i).equals(cupcakeMenu.get(2))) {
                cupcakeMenu.get(2).type();
                System.out.println(cupcakeMenu.get(2).getPrice());
                subTotal += cupcakeMenu.get(2).getPrice();
            }else if (order.get(i).equals(drinkMenu.get(0))) {
                drinkMenu.get(0).type();
                System.out.println(drinkMenu.get(0).getPrice());
                subTotal += drinkMenu.get(0).getPrice();
            }else if (order.get(i).equals(drinkMenu.get(1))) {
                drinkMenu.get(1).type();
                System.out.println(drinkMenu.get(1).getPrice());
                subTotal += drinkMenu.get(1).getPrice();
            }else if (order.get(i).equals(drinkMenu.get(2))) {
                drinkMenu.get(2).type();
                System.out.println(drinkMenu.get(2).getPrice());
                subTotal += drinkMenu.get(2).getPrice();
            }
        }
        System.out.println("Total:" + subTotal);
        new CreateFile();
        new WriteToFile(order);
    }
}

class CreateFile {
    // Create a try catch block, with a catch parameter of IOException e
    public CreateFile() {
        // Create a File object named salesData and set it equal to a new File with the parameter "salesData.txt"
        try{
            File salesData = new File("salesData.txt");
            //Create an if statement with the parameter salesData.createNewFile(). .createNewFile() will return true if a new file is created.
            if(salesData.createNewFile()) {
                System.out.println("File created:" + salesData.getName());
            }
            else {
                System.out.println("File already exists");
            }
        } catch(IOException e) {

            System.out.println("An error occurred");
        }
    }
}

class WriteToFile {
    public WriteToFile(ArrayList<Object> order) {
        try {
            //create a new FileWriter object named fw, and set it equal to new FileWriter object whose constructor parameters are the name of the object, “salesData.txt”, and the boolean true, which is an option that allows for appending to the file.
            FileWriter fw = new FileWriter("salesData.txt",true);
            //Create a new PrintWriter object named salesWriter, and set it equal to new PrintWriter object whose constructor parameter is the FileWriter object fw created previously.
            PrintWriter salesWriter = new PrintWriter(fw);
            //Iterate through each element in order using a for loop to print the values by calling the method .println()
            //on the salesWriter object.
            // Print each value in order.
            for(int i = 0; i < order.size(); i++) {
                salesWriter.println(order.get(i));
            }
            // Stop the writer from continuing to run
            salesWriter.close();
            System.out.println("Successfully wrote to the file");
        }catch (IOException e) {
            System.out.println("An error occurred");
        }

    }
}
