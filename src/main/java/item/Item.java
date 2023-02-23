package item;

import jakarta.persistence.*;

@Entity
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String Name;
    String ModelNr;
    String ExtraInfo;
    String Price;

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getModelNr() {
        return ModelNr;
    }
    public void setModelNr(String modelNr) {
        ModelNr = modelNr;
    }
    public String getExtraInfo() {
        return ExtraInfo;
    }
    public void setExtraInfo(String extraInfo) {
        ExtraInfo = extraInfo;
    }
    public String getPrice() {
        return Price;
    }
    public void setPrice(String price) {
        Price = price;
    }

    public Item(){}
    public Item(String name,
                String modelNr,
                String extraInfo,
                String price) {
        this.Name = name;
        this.ModelNr = modelNr;
        this.ExtraInfo = extraInfo;
        this.Price = price;
    }
}