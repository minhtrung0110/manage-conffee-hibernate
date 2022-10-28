package hibernate.entities;

import javax.persistence.*;

@Entity
@Table(name = "sanpham")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_SP")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Loai",nullable = false,foreignKey = @ForeignKey(name = "sanpham_ibfk_1"))
    private Category category;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "amount",nullable=true)
    private int amount;

    @Column(name = "price")
    private float price;

    @Column(name = "img")
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product(){

    }

    public Product(int id,  String name, String description, int amount, float price, String image) {
        this.id = id;

        this.name = name;
        this.description = description;
        this.amount = amount;
        this.price = price;
        this.image = image;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return this.name+" - "+this.category.getName()+" - "+this.description+ " - "+this.amount+ " - "+this.price;
    }
}
