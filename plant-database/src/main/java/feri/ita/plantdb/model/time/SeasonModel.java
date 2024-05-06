package feri.ita.plantdb.model.time;

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
@Table(name = "seasons")
public class SeasonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "season_id")
    private Long seasonId;
    @Column(name = "name")
    private String seasonName;
    @ManyToMany(mappedBy = "plantSeasons")
    private Set<PlantModel> plants = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "season_time", joinColumns = @JoinColumn(name = "season_id"), inverseJoinColumns = @JoinColumn(name = "plant_time_id"))
    private Set<PlantTimeModel> plantTimes = new HashSet<>();
}
