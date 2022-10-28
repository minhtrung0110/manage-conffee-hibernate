package hibernate.entities;



import javax.persistence.*;
import java.util.Set;

@Entity(name = "loai")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Loai")
    private int id;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Set<Product> product;
    @Column(name = "name")
    private String name;

    public Category(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
