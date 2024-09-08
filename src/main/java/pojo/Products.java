package pojo;

import lombok.Data;

@Data

public class Products {
    public int id;
    public String name;
    public String price;
    public String brand;
    public Category category;
}
