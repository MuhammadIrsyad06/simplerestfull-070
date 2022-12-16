/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.b.crud.b;

/**
 *
 * @author lenovo
 */
public class Product {
    private String id;
    private String name;


    private int price;
    private int number;
    private int totalbuy;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTotalbuy() {
        return totalbuy;
    }

    public void setTotalbuy() {
        this.totalbuy = price*number;
    }
  


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
