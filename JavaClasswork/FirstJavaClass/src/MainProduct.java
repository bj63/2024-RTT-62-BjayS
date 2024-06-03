import java.util.List;

public class MainProduct {
    public static void main(String[] args) {
        List<Products> products = new ArrayList<>();

        Products coffee = new Products();
        coffee.setPrice(5.46);
        coffee.setName("Small Coffee");
        coffee.setBeverage(true);
        products.add(coffee);

        Products cakePop = new Products();
        cakePop. setPrice(3.89);
        cakePop. setBeverage(false);
        products.add(cakePop);

        String s = " egg Sandwich, beverage:false";
        Products eggSandwich = new Products(7.89, "Egg Sandwich",false );
        products.add(eggSandwich);

    }
}
