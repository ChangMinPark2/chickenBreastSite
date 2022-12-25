package domain.entity.productClassification;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import domain.entity.users.Users;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "tbl_productClassification")
@NoArgsConstructor
@AllArgsConstructor
public class ProductClassification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pcno;

    private String name;
}
