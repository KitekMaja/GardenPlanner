package feri.ita.plantdatabase.model.plant;

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
@Table(name = "plant_type")
public class PlantTypeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plant_type_id", nullable = false)
    private Long plantTypeId;
    @Column(name = "plant_type", nullable = false)
    private String plantTypeName;
    @ManyToMany(mappedBy = "plantTypes")
    private Set<PlantModel> plants = new HashSet<>();
}

