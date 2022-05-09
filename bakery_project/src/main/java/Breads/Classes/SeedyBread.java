package Breads.Classes;

import Breads.ABread;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeedyBread extends ABread {

    public SeedyBread(int id) {
        super(id);
    }

    @Override
    public String getName() {
        return "Seedy bread";
    }

    @Override
    public int getPrice() {
        return 320;
    }

    @Override
    public ABread clone() {
        return new SeedyBread(this.getId());
    }
}
