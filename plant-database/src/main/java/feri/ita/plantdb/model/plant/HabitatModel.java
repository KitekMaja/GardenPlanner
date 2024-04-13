package feri.ita.plantdb.model.plant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

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
    @Column(name = "name", nullable = false)
    private String habitatName;
    @ManyToMany(mappedBy = "plantHabitats")
    private Set<PlantModel> plants = new HashSet<>();
}
