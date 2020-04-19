package eg.gov.iti.jets;

import eg.gov.iti.jets.model.*;
import eg.gov.iti.jets.repository.ProductRepository;
import eg.gov.iti.jets.repository.impl.ImageRepositoryImpl;
import eg.gov.iti.jets.repository.impl.ProductRepositoryImpl;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
       /* UserRepository userRepository = UserRepositoryImpl.getInstance();
        User u = new User("ahmed", "shaheen", "01061510304",
                "ahmedshaheen67@yahoo.com", "123456",
                Role.CUSTOMER_ROLE, 200d,
                LocalDate.of(1993, 4, 20), null, new Address());
        User save = userRepository.save(u);
        System.out.println("saved user-------------------");
        System.out.println(save);
        System.out.println("findByMailAndPassword user-------------------");
        User byMailAndPassword = userRepository.findByMailAndPassword("ahmedshaheen67@yahoo.com", "123456");
        System.out.println(byMailAndPassword);
        System.out.println("checkBalanceGreaterThan user-------------------");
        Boolean aBoolean = userRepository.checkBalanceGreaterThan(save, 100d);
        System.out.println(aBoolean);
        System.out.println("updateUserBalance user-------------------");
        Double aDouble = userRepository.addUserBalance(save, 100d);
        System.out.println(aDouble);
        System.out.println(save.getBalance());
*/

        //------------------

        ImageRepositoryImpl imageRepository = ImageRepositoryImpl.getInstance();

        Category category = new Category("cloths");
        Category category1 = new Category("cars");
        Product product = new Product();
        product.getCategories().add(category);
        product.setProductName("T-shirt");
        product.setQuantity(8);
        product.setBuyPrice(10d);
        product.setDescription("good one");
        product.setManufacturingDate(LocalDate.now());
        product.setManufacturingName("China");
        product.setSellPrice(15d);

        Product product2 = new Product();
        product2.getCategories().add(category1);
        product2.setProductName("new product");
        product2.setQuantity(8);
        product2.setBuyPrice(15d);
        product2.setDescription("good one");
        product2.setManufacturingDate(LocalDate.now());
        product2.setManufacturingName("China");
        product2.setSellPrice(20d);
        product2.getImages().add(imageRepository.findById(2L));
        product2.getImages().add(imageRepository.findById(3L));
        product2.getImages().add(imageRepository.findById(4L));

        ProductRepository productRepository = ProductRepositoryImpl.getInstance();
        product = productRepository.save(product);
        product2 = productRepository.save(product2);

//        Purchase purchase = new Purchase(8, product.getSellPrice(), product);
//        Purchase purchase2 = new Purchase(8, product2.getSellPrice(), product2);
//        OrderService orderService = OrderServiceImpl.getInstance();
//        Set<Purchase> p = new HashSet<>();
//        p.add(purchase);
////        p.add(purchase2);
//        try {
//            orderService.createOrder(save, p);
//        } catch (UserBalanceViolation | ProductQuantityLimitExceeded userBalanceViolation) {
//            userBalanceViolation.printStackTrace();
//        }
//        ProductRepositoryImpl instance = ProductRepositoryImpl.getInstance();
//        Product byId = instance.findById(2l);
//        System.out.println(byId);

    }
}
