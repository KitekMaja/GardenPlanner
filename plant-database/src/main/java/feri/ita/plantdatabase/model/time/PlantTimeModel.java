package feri.ita.plantdatabase.model.time;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(name = "plant_time", nullable = false)
    private String plantTime;
}
