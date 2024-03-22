package feri.ita.plantdatabase.model.plant;

import feri.ita.plantdatabase.model.classification.ClassificationModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "plant")
public class PlantModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plant_id")
    private Long plantId;
    @Column(name = "botanical_name")
    private String botanicalName;
    private Boolean poisonous;
    private String description;
    @Column(name = "min_plant_temperature")
    private Float minPlantTemperature;
    @Column(name = "max_plant_temperature")
    private Float maxPlantTemperature;
    @Column(name = "interesting_fact")
    private String interestingFact;
    private String symbolism;
    @Column(name = "plant_height")
    private Float plantHeight;
    private Float spread;
    @Column(name = "plant_size")
    private Float flowerSize;
    @Column(name = "water_info")
    private String waterInfo;
    @Column(name = "fertilizer_info")
    private String fertilizerInfo;
    private String pruning;
    private String potting;
    @Column(name = "care_difficulty")
    private String careDifficulty;
    @OneToOne
    @JoinColumn(name = "habitat_id")
    private HabitatModel habitat;
    @OneToOne
    @JoinColumn(name = "classification_id")
    private ClassificationModel classification;
}
