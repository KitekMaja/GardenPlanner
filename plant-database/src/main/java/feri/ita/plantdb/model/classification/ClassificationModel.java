package feri.ita.plantdb.model.classification;

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
    @Column(name = "classification_id")
    private Long classificationId;
    @Column(name = "classification_name")
    private String classificationName;
    @OneToOne
    @JoinColumn(name = "genus_id", referencedColumnName = "genus_id")
    private GenusModel genus;
    @OneToOne
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    private ClassModel clazz;
    @OneToOne
    @JoinColumn(name = "family_id", referencedColumnName = "family_id")
    private FamilyModel family;
    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private OrderModel order;
    @OneToOne
    @JoinColumn(name = "phylum_id", referencedColumnName = "phylum_id")
    private PhylumModel phylum;
}
