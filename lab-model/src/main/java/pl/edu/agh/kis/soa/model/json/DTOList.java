package pl.edu.agh.kis.soa.model.json;

import java.util.ArrayList;

public class DTOList {

    ArrayList item = new ArrayList();

    public void setItem(ArrayList item) {
        this.item = item;
    }

    public ArrayList getItem() {
        return item;
    }

    public int size() {
        return item.size();
    }
}
