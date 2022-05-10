package Storage.Classes;

import Breads.ABread;
import Storage.Exceptions.BreadAlreadyExistsException;
import Storage.Interfaces.IObserver;
import Storage.Interfaces.IObservedSubject;
import Storage.Strategies.LogAdd;
import com.mysql.cj.log.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Storage implements IObservedSubject {
    private static int ID = 1;
    public static int getID() {
        return ID++;
    }

    public Storage() {
        this.observers = new ArrayList<>();
    }


    private List<IObserver> observers;
    
    private List<ABread> products;
    
    public List<ABread> getProducts() {
        List<ABread> temp = new ArrayList<>();
        for (ABread bread: products) {
            temp.add(bread.clone());
        }
        return temp;
    }

    public void addBread(ABread newBread) throws BreadAlreadyExistsException {
        if (!products.contains(newBread)) {
            products.add(newBread);
            observers.notify();
        } else throw new BreadAlreadyExistsException();
    }

    public void removeBread(ABread bread) {
        if (products.contains(bread)) {
            products.remove(bread);
        }
        else throw new NoSuchElementException();
    }


    @Override
    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notify(IObserver observer) {
        //observer.logTo(); //TODO: a singleton meghívása, hogy abba a fájlba írjon
    }
}
