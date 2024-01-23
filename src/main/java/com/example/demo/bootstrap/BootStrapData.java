package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private ProductService productService;
    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;

    }
    @Override
    public void run(String... args) throws Exception {
        // Check if both the part and product lists are empty
        if(productRepository.count() == 0 && outsourcedPartRepository.count() == 0 && partRepository.count() == 0) {
            // Create & save sample parts
            InhousePart part1 = new InhousePart();
            part1.setName("Car Body");
            part1.setPrice(600.00);
            part1.setInv(47);
            part1.setPartId(1);
            part1.setMinInv(5);
            part1.setMaxInv(100);
            partRepository.save(part1);

            InhousePart part2 = new InhousePart();
            part2.setName("Truck Body");
            part2.setPrice(750.00);
            part2.setInv(24);
            part2.setPartId(2);
            part2.setMinInv(5);
            part2.setMaxInv(100);
            partRepository.save(part2);

            OutsourcedPart part3 = new OutsourcedPart();
            part3.setName("V6 Engine");
            part3.setPrice(1000.00);
            part3.setInv(9);
            part3.setCompanyName("Toyota");
            part3.setMinInv(0);
            part3.setMaxInv(10);
            outsourcedPartRepository.save(part3);

            OutsourcedPart part4 = new OutsourcedPart();
            part4.setName("V8 Engine");
            part4.setPrice(2000.00);
            part4.setInv(5);
            part4.setCompanyName("BMW");
            part4.setMinInv(0);
            part4.setMaxInv(10);
            outsourcedPartRepository.save(part4);

            OutsourcedPart part5 = new OutsourcedPart();
            part5.setName("I4 Engine");
            part5.setPrice(700.00);
            part5.setInv(11);
            part5.setCompanyName("Toyota");
            part5.setMinInv(0);
            part5.setMaxInv(10);
            outsourcedPartRepository.save(part5);

            // Create & save sample products
            Product prod1 = new Product("Compact Car", 1500.00, 3);
            productRepository.save(prod1);

            Product prod2 = new Product("Full-size Sedan", 2700.00, 6);
            productRepository.save(prod2);

            Product prod3 = new Product("Light-Duty Pickup Truck", 2900.00, 4);
            productRepository.save(prod3);

            Product prod4 = new Product("Heavy-Duty Pickup Truck", 4100.00, 3);
            productRepository.save(prod4);

            Product prod5 = new Product("Sport Utility Vehicle (SUV)", 4400.00, 1);
            productRepository.save(prod5);

           /*
            OutsourcedPart o= new OutsourcedPart();
            o.setCompanyName("Western Governors University");
            o.setName("out test");
            o.setInv(5);
            o.setPrice(20.0);
            o.setId(100L);
            outsourcedPartRepository.save(o);
            OutsourcedPart thePart=null;
            List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for(OutsourcedPart part:outsourcedParts){
                if(part.getName().equals("out test"))thePart=part;
            }

            System.out.println(thePart.getCompanyName());
            */
            List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                System.out.println(part.getName() + " " + part.getCompanyName());
            }

            /*
            Product bicycle= new Product("bicycle",100.0,15);
            Product unicycle= new Product("unicycle",100.0,15);
            productRepository.save(bicycle);
            productRepository.save(unicycle);
            */

            System.out.println("Started in Bootstrap");
            System.out.println("Number of Products" + productRepository.count());
            System.out.println(productRepository.findAll());
            System.out.println("Number of Parts" + partRepository.count());
            System.out.println(partRepository.findAll());
        }
    }
}
