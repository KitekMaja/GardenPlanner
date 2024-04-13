package feri.ita.plantdb.model.classification;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "genus")
public class GenusModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genus_id", nullable = false)
    private Long genusId;
    @Column(name = "name", nullable = false)
    private String genusName;
}
