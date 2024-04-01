package feri.ita.plantdatabase.model.hardiness_zones;

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
@Table(name = "hardiness_zone")
public class HardinessZoneModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hardiness_zone_id")
    private Long hardinessZoneId;
    @Column(name = "hardiness_zone_name", nullable = false)
    private String hardinessZoneName;
    @Column(name = "min_temperature", nullable = false)
    private Float minTemperature;
    @Column(name = "max_temperature", nullable = false)
    private Float maxTemperature;
    @ManyToMany(mappedBy = "plantHardinessZones")
    private Set<PlantModel> plants = new HashSet<>();
}
