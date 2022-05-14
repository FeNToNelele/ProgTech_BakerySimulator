package Storage.Classes;

import Breads.ABread;
import Storage.Exceptions.BreadAlreadyExistsException;
import Storage.Interfaces.IObserver;
import Storage.Interfaces.ISubject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Storage implements ISubject {
    public Storage() {
        this.products = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    private int userid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    private static int ID = 1;
    public static int getID() {
        return ID++;
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

    public void addBread(ABread newBread) throws BreadAlreadyExistsException, IOException {
        if (!products.contains(newBread)) {
            products.add(newBread);
            notifyObservers(new ArrayList<>(), this.getUserid(), newBread.getId());
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
    public void notifyObservers(List<IObserver> observers, int userid, int productid) throws IOException {
        for (IObserver observer : observers) {
            observer.updateFields(userid, productid);
        }
    }
}
