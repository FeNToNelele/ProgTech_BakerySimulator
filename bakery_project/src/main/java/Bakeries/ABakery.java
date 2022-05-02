package Bakeries;


import Breads.ABread;
import Storage.Classes.Storage;

import java.util.List;

public abstract class ABakery {
    Storage storage;
    public abstract List<ABread> bake(int amount);
}
