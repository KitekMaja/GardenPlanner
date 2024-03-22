package feri.ita.plantdatabase.model.plant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "habitat")
public class HabitatModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "habitat_id", nullable = false)
    private Long habitatId;
    @Column(name = "habitat_name", nullable = false)
    private String habitatName;
}
