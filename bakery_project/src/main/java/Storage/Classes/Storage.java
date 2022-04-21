package Storage.Classes;

import Breads.ABread;
import Storage.Exceptions.BreadAlreadyExistsException;
import Storage.Interfaces.IObserver;
import Storage.Interfaces.IObservedSubject;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Storage implements IObservedSubject {
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
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            IObserver observer = observers.get(i);
            //TODO: átadni a változásokat
            //observer.log();
        }
    }
}
