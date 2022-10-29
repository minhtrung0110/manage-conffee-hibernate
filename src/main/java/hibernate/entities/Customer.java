package hibernate.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor

@AllArgsConstructor
@Entity
@Table(name = "khachhang")
public class Customer {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id_KH")
private int id;
@Column(name = "first_name")
private String firstName;
@Column(name = "last_name")
private String lastName;
@Column(name = "address")
private String address;
@Column(name = "phone")
private String phoneNumber;
@Column(name = "status")
private int status;

@OneToMany(mappedBy = "customer",fetch=FetchType.EAGER)
    private Set<Order> order;

@Override public String toString() {
    return "Customer( id="+id+" firstName= "+firstName+" lastName= "+lastName+" phone= "+phoneNumber+" status = "+status+")";
}



}
