package feri.ita.plantdatabase.model.classification;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classification")
public class ClassificationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "family_Id")
    private Long familyId;
    @OneToOne(mappedBy = "genus_id")
    @JoinColumn(name = "genus_id")
    private GenusModel genus;
    @OneToOne(mappedBy = "clazz_id")
    @JoinColumn(name = "clazz_id")
    private ClassModel clazz;
    @OneToOne(mappedBy = "family_id")
    @JoinColumn(name = "family_id")
    private FamilyModel family;
    @OneToOne(mappedBy = "order_id")
    @JoinColumn(name = "order_id")
    private OrderModel order;
    @OneToOne(mappedBy = "phylum_id")
    @JoinColumn(name = "phylum_id")
    private PhylumModel phylum;
}
