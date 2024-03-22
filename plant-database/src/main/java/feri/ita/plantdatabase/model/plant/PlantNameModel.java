package feri.ita.plantdatabase.model.plant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "plant_name")
public class PlantNameModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plant_name_id", nullable = false)
    private Long plantNameId;
    @Column(name = "plant_name", nullable = false)
    private String plantName;
    private String story;
    @ManyToOne
    @JoinColumn(name = "plant_id")
    private PlantModel plant;
}
