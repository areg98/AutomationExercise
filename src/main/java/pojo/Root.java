package pojo;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Root {
    public int responseCode;
    public ArrayList<Products> products;
}


