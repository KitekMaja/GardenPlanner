package feri.ita.plantdb.model.hardiness_zones;

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
@Table(name = "hardiness_zones")
public class HardinessZoneModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zone_id")
    private Long hardinessZoneId;
    @Column(name = "name", nullable = false)
    private String hardinessZoneName;
    @Column(name = "min_temperature", nullable = false)
    private Float minTemperature;
    @Column(name = "max_temperature", nullable = false)
    private Float maxTemperature;
    @ManyToMany(mappedBy = "plantHardinessZones")
    private Set<PlantModel> plants = new HashSet<>();
}
