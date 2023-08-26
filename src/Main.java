import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Create a new class named Cupcake. This will be the class all other cupcakes inherit from

        // Create a new ArrayList which contains Cupcake and call it cupcakeMenu
        ArrayList<Cupcake> cupcakeMenu = new ArrayList<Cupcake>();

        //Create a new Cupcake object named cupcake.
        Cupcake cupcake = new Cupcake();

        //Create a new RedVelvet object named redVelvet.
        RedVelvet redVelvet = new RedVelvet();

        //Create a new Chocolate object named chocolate.
        Chocolate chocolate = new Chocolate();

        System.out.println("We are in the middle of creating the cupcake menu. We currently have three cupcakes on the menu but we need to decide on pricing.");
        Scanner input = new Scanner(System.in);

        System.out.println("We are deciding on the price for our standard cupcake. Here is the description:");
        cupcake.type();
        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        String priceText = input.nextLine();

        //convert it into a double
        double price = Double.parseDouble(priceText);
        cupcake.setPrice(price);

        System.out.println("We are deciding on the price for our Red Velvet cupcake. Here is the description:");
        redVelvet.type();
        System.out.println("How much would you like to charge for the Red Velvet cupcake? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();

        //convert it into a double
        price = Double.parseDouble(priceText);
        redVelvet.setPrice(price);


        System.out.println("We are deciding on the price for our Chocolate cupcake. Here is the description:");
        chocolate.type();
        System.out.println("How much would you like to charge for the Chocolate cupcake? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();

        //convert it into a double
        price = Double.parseDouble(priceText);
        chocolate.setPrice(price);

        //add each of these Cupcake objects to the cupcakeMenu ArrayList.
        cupcakeMenu.add(cupcake);
        cupcakeMenu.add(redVelvet);
        cupcakeMenu.add(chocolate);


        ArrayList<Drink> drinkMenu = new ArrayList<Drink>();

        Drink water = new Drink();
        Soda soda = new Soda();
        Milk milk = new Milk();


        System.out.println("We are deciding on the price for our Water. Here is the description:");
        water.type();
        System.out.println("How much would you like to charge for the Water? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();

        //convert it into a double
        price = Double.parseDouble(priceText);
        water.setPrice(price);


        System.out.println("We are deciding on the price for our Soda. Here is the description:");
        soda.type();
        System.out.println("How much would you like to charge for the Soda? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();

        //convert it into a double
        price = Double.parseDouble(priceText);
        soda.setPrice(price);

        System.out.println("We are deciding on the price for our Milk. Here is the description:");
        milk.type();
        System.out.println("How much would you like to charge for the Milk? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();

        //convert it into a double
        price = Double.parseDouble(priceText);
        milk.setPrice(price);

        drinkMenu.add(water);
        drinkMenu.add(soda);
        drinkMenu.add(milk);

        new Order(cupcakeMenu, drinkMenu);
    }
}

class Cupcake {

    // Create a public double variable named price, but do not assign it a value
    public double price;

    // Create a public function named getPrice that has no parameters and returns the price
    public double getPrice() {
        return price;
    }

    // Create a public function named setPrice that has one parameter, a double named price, and returns void
    public void setPrice(double price) {
        this.price = price;
    }

    // Create a public function named type that prints a description and returns void
    public void type() {
        System.out.println("A basic, generic cupcake, with vanilla frosting");
    }

}

// Create a new class named RedVelvet that extends from Cupcake
class RedVelvet extends Cupcake {

    // Create a public function named type that returns void and prints a description of the cupcake
    @Override
    public void type() {
        System.out.println("A red velvet based cupcake, with cream cheese frosting.");
    }
}

// Create a new class named Chocolate that extends from Cupcake
class Chocolate extends Cupcake {

    // Create a public function named type that returns void and prints a description of the cupcake
    @Override
    public void type() {
        System.out.println("A chocolate based cupcake, with chocolate frosting.");
    }
}

class Drink {

    public double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void type() {
        System.out.println("A bottle of water");
    }

}

class Soda extends Drink {
    @Override
    public void type() {
        System.out.println("A bottle of soda.");
    }
}

class Milk extends Drink {
    @Override
    public void type() {
        System.out.println("A bottle of milk.");
    }
}
