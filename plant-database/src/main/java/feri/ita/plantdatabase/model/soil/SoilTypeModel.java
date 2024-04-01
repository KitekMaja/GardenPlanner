package feri.ita.plantdatabase.model.soil;

import feri.ita.plantdatabase.model.plant.PlantModel;
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
@Table(name = "soil_type")
public class SoilTypeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "soil_type_id", nullable = false)
    private Long soilTypeId;
    @Column(name = "soil_type_name", nullable = false)
    private String soilTypeName;
    @ManyToMany(mappedBy = "plantSoilTypes")
    private Set<PlantModel> plants = new HashSet<>();
}
