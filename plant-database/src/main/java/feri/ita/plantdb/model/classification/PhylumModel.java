package feri.ita.plantdb.model.classification;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phylum")
public class PhylumModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phylum_id", nullable = false)
    private Long phylumId;
    @Column(name = "name", nullable = false)
    private String phylumName;
}
