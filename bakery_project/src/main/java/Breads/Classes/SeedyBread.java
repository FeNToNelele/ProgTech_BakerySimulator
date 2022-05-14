package Breads.Classes;

import Breads.ABread;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeedyBread extends ABread {

    public SeedyBread(int id) {
        super(id, "Seedy bread", 320);
    }

    @Override
    public ABread clone() {
        return new SeedyBread(this.getId());
    }
}
