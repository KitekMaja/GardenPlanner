package feri.ita.plantdatabase.model.classification;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "family_model")
public class FamilyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "family_id", nullable = false)
    private Long familyId;
    @Column(name = "family_name", nullable = false)
    private String familyName;
}
