import java.util.HashSet;
import java.util.Set;

public class CartApp{
    public static void main(String[] args) throws IllegalAccessException {
        // 상품 목록 생성
        Set<Product> productSet = new HashSet<>();
        Product apple = new Product("001", "사과", 2500);
        Product banana = new Product("002", "바나나", 1900);
        Product milk = new Product("003", "우유", 2500);

        // TODO : 상품 클래스를 생성하여 상품목록에 넣는다
        productSet.add(apple);
        productSet.add(banana);
        productSet.add(milk);


        // 상품 목록 확인
        System.out.println("고유한 상품 목록: ");
        for (Product product : productSet){
            System.out.println(product.getName() + " : " + product.getPrice());
        }

        // 장바구니 생성
        Cart myCart = new Cart();


        // TODO : 상품을 장바구니에 추가
        myCart.addProduct(apple, 1);
        myCart.addProduct(banana, 2);
        myCart.addProduct(milk, 3);

        // TODO : 상품을 장바구니에서 제거
        myCart.removeProduct(apple, 1);
        myCart.removeProduct(banana, 1);
        myCart.removeProduct(milk, 1);


        // TODO : 장바구니에 현재 담긴 상품들을 출력(상품이름, 각 상품의 갯수)
        System.out.println("장바구니에 현재 담긴 품목");
        myCart.showItems();
    }
}