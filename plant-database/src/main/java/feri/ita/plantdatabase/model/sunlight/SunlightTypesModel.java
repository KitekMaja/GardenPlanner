package feri.ita.plantdatabase.model.sunlight;

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
@Table(name = "sunlight_types")
public class SunlightTypesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sunlight_type_id", nullable = false)
    private Long sunlightTypeId;
    @Column(name = "sunlight_type_name", nullable = false)
    private String sunlightTypeName;
    @ManyToMany(mappedBy = "plantSunlightConditions")
    private Set<PlantModel> plants = new HashSet<>();
}
