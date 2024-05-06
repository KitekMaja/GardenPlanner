package feri.ita.plantdb.model.part_color;

import feri.ita.plantdb.model.hardiness_zones.HardinessZoneModel;
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
@Table(name = "plant_part")
public class PartModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plant_part_id", nullable = false)
    private Long partId;
    @Column(name = "name", nullable = false)
    private String partName;
    @ManyToMany
    @JoinTable(name = "part_color", joinColumns = @JoinColumn(name = "plant_part_id"), inverseJoinColumns = @JoinColumn(name = "color_id"))
    private Set<ColorModel> colors = new HashSet<>();
    @ManyToMany(mappedBy = "plantParts")
    private Set<PlantModel> plants = new HashSet<>();

}
