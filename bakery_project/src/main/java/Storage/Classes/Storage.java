package Storage.Classes;

import Breads.ABread;
import Storage.Interfaces.IObserver;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    public Storage() {
        this.observers = new ArrayList<>();
    }

    private List<IObserver> observers;
    
    private List<ABread> products;
    
    public List<ABread> getProducts() {
        List<ABread> temp = new ArrayList<>();
        for (ABread bread: products) {
            //temp.add(bread.clone());
        }
        return temp;
    }

    public void addBread(ABread newBread) {
        if (!products.contains(newBread)) {
            products.add(newBread);
        }
    }

    public void removeBread(int id) {
        //var bread = products.stream().filter(x -> )
    }
}
