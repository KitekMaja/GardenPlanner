package feri.ita.plantdb.model.soil;

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
@Table(name = "soil_types")
public class SoilTypeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "soil_id", nullable = false)
    private Long soilTypeId;
    @Column(name = "name", nullable = false)
    private String soilTypeName;
    @ManyToMany(mappedBy = "plantSoilTypes")
    private Set<PlantModel> plants = new HashSet<>();
}
