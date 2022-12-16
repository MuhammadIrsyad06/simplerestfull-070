/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.b.crud.b;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author lenovo
 */
@ControllerAdvice
public class ProductExceptionController extends RuntimeException {
    private static final long serialVersionUID=1L;
    
    //method memunculkan pesan exception
    @ExceptionHandler(value=ProductNotfoundException.class)
    public ResponseEntity<Object>exception(ProductNotfoundException exception){
        return new ResponseEntity<>("Product not found",HttpStatus.NOT_FOUND);
    }
    @RequestMapping(value="/products/[id]", method =RequestMethod.PUT)
    public ResponseEntity<Object>updateProduct(){
        throw new ProductNotfoundException();
    }
}
