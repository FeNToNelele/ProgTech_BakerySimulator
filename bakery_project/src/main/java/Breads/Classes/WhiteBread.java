package Breads.Classes;

import Breads.ABread;

import java.util.ArrayList;
import java.util.List;

public class WhiteBread extends ABread {
    public WhiteBread() {
        super("White bread", 260);
    }

    @Override
    public ABread clone() {
        return new WhiteBread();
    }
}
