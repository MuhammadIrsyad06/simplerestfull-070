/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.b.crud.b;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lenovo
 */
@RestController
public class ProductServiceController {
    private static Map<String, Product> productRepo = new HashMap<>();
    static{
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(),honey);
        
        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(),almond);
        
        Product oreo = new Product();
        oreo.setId("3");
        oreo.setName("Oreo Blackpink");
        productRepo.put(oreo.getId(),oreo);
    }
    @RequestMapping(value="/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id){
        //fungsi memanggil pesan exception ketika id yang ingin dihapus tidak tersedia
        if(!productRepo.containsKey(id))throw new ProductNotfoundException(); 
        //fungsi ketika id yang ingin dihapus sudah ada
        productRepo.remove(id);
        return new ResponseEntity<>("Product is deleted successfully",HttpStatus.OK);
    }
    @RequestMapping(value="/products/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product)
    {
        //fungsi memanggil pesan exception  ketika id yang akan diupdate tidak tersedia
        if(!productRepo.containsKey(id))throw new ProductNotfoundException();
        productRepo.remove(id);
        //fungsi ketika id yang ingin diupdate sudah ada
        product.setId(id);
        productRepo.put(id, product);
        return new ResponseEntity<>("Product is update successfully", HttpStatus.OK);
    }
    @RequestMapping(value="/products",method= RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product)
    {
        //fungsi ketika id yang ingin dibuat sudah ada
        if(productRepo.containsKey(product.getId())){
            return new ResponseEntity<>("Id prduct already exists!",HttpStatus.OK);
        }
        //fungsi ketika id product kosong
        else if(!productRepo.containsKey(product.getId())){
                    return new ResponseEntity<>("please fill the Id Product",HttpStatus.OK);
    }
        //fungsi untuk menambahkan product
        else{
            productRepo.put(product.getId(), product);
            return new ResponseEntity<>("Product is created successfully",HttpStatus.CREATED);
        }
            
        
    }
    @RequestMapping(value="/products")
    public ResponseEntity<Object> getProduct(){
        return new ResponseEntity<>(productRepo.values(),HttpStatus.OK);
    }
   
}
