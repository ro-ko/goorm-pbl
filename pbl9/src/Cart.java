import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<Product, Integer> productIntegerMap = new HashMap<>();

    public void showItems(){
        for(Map.Entry<Product, Integer> entry : productIntegerMap.entrySet()){
            System.out.println("[이름]" + " : " + entry.getKey().getName() + " " + "[갯수]" + " : " + entry.getValue());
        }
    }

    public void addProduct(Product product, int count){
        productIntegerMap.put(product, productIntegerMap.getOrDefault(product, 0) +count);
    }

    public void removeProduct(Product product, int count) throws IllegalAccessException{
        int currentCount = productIntegerMap.getOrDefault(product, 0);
        if (currentCount < count){
            throw new IllegalAccessException();
        }
        productIntegerMap.put(product, currentCount-count);
    }
}