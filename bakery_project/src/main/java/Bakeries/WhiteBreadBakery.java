package Bakeries;

import Breads.ABread;
import Breads.Classes.WhiteBread;

import java.util.ArrayList;
import java.util.List;

public class WhiteBreadBakery extends ABakery{
    @Override
    public List<ABread> bake(int amount) {
        List<ABread> whiteBreads = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            whiteBreads.add(new WhiteBread());
        }
        return whiteBreads;
    }
}
