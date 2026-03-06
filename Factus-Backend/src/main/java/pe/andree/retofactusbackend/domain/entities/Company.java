package pe.andree.retofactusbackend.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "companies")
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "name_company", length = 100, nullable = false, unique = true)
    private String nameCompany;

    @Column(name = "ruc_nit", length = 40, nullable = false)
    private String rucNit;


    @Column(name = "tax_address", length = 150, nullable = false)
    private String taxAddress;


    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @OneToOne(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private AppSetting appSetting;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<User> users;

}





