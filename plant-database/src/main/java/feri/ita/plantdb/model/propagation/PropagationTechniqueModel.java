package feri.ita.plantdb.model.propagation;

import feri.ita.plantdb.model.plant.PlantModel;
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
@Table(name = "propagation_techniques")
public class PropagationTechniqueModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technique_id")
    private Long propagationTechniqueId;
    @Column(name = "name", nullable = false)
    private String propagationTechniqueName;
    @Column(name = "propagation_technique_description", nullable = false)
    private String description;
    @ManyToMany(mappedBy = "plantPropagationTechniques")
    private Set<PlantModel> plants = new HashSet<>();
}
