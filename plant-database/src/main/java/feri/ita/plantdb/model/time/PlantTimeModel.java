package feri.ita.plantdb.model.time;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "plant_time")
public class PlantTimeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plant_time_id", nullable = false)
    private Long plantTimeId;
    @Column(name = "name", nullable = false)
    private String plantTime;
    @ManyToMany(mappedBy = "plantTimes")
    private Set<SeasonModel> seasons = new HashSet<>();
}
