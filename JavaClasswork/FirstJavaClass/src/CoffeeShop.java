package PACKAGE_NAME;

import java.util.List;

public class CoffeeShop {
  private  List<Products> products = new ArrayList<>();
    public void initProducts(){
    Products coffee = new Products();
        coffee.setPrice(5.46);
        coffee.setName("Small Coffee");
        coffee.setBeverage(true);
        products.add(coffee);

    Products cakePop = new Product();
        cakePop.setPrice(3.89);
        cakePop.setBeverage(false);
        products.add(cakePop);

    String s = " egg Sandwich, beverage:false";
}
public void printProducts() {
    for ( int pos 0; pos < products.size() ; pos++){
        Products products = products.get(pos);
        System.out.println((pos+1) +) +product.getName()  + "\t" + products.getPrice();
    }
}

public void main() {
}
