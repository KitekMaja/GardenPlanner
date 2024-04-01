package feri.ita.plantdatabase.model.plant;

import feri.ita.plantdatabase.model.classification.ClassificationModel;
import feri.ita.plantdatabase.model.hardiness_zones.HardinessZoneModel;
import feri.ita.plantdatabase.model.lifespan.LifespanModel;
import feri.ita.plantdatabase.model.part_color.PartModel;
import feri.ita.plantdatabase.model.propagation.PropagationTechniqueModel;
import feri.ita.plantdatabase.model.soil.SoilTypeModel;
import feri.ita.plantdatabase.model.sunlight.SunlightTypesModel;
import feri.ita.plantdatabase.model.time.SeasonModel;
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
    @JoinColumn(name = "scientific_classification_id")
    private ClassificationModel scientificClassification;
    @OneToMany
    @JoinColumn(name = "plant_name_id", referencedColumnName = "plant_name_id")
    private Set<PlantNameModel> plantNames = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "plant_hardiness_zones", joinColumns = @JoinColumn(name = "plant_id", referencedColumnName = "plant_id"), inverseJoinColumns = @JoinColumn(name = "hardiness_zone_id", referencedColumnName = "hardiness_zone_id"))
    private Set<HardinessZoneModel> plantHardinessZones = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "plant_habitats", joinColumns = @JoinColumn(name = "plant_id", referencedColumnName = "plant_id"), inverseJoinColumns = @JoinColumn(name = "habitat_id", referencedColumnName = "habitat_id"))
    private Set<HabitatModel> plantHabitats = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "plant_lifespans", joinColumns = @JoinColumn(name = "plant_id", referencedColumnName = "plant_id"), inverseJoinColumns = @JoinColumn(name = "lifespan_id", referencedColumnName = "lifespan_id"))
    private Set<LifespanModel> plantLifespans = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "plant_propagation_techniques", joinColumns = @JoinColumn(name = "plant_id"), inverseJoinColumns = @JoinColumn(name = "propagation_technique_id", referencedColumnName = "propagation_tech"))
    private Set<PropagationTechniqueModel> plantPropagationTechniques = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "plant_soil_types", joinColumns = @JoinColumn(name = "plant_id"), inverseJoinColumns = @JoinColumn(name = "soil_type_id", referencedColumnName = "soil_type_id"))
    private Set<SoilTypeModel> plantSoilTypes = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "plant_sunlight_conditions", joinColumns = @JoinColumn(name = "plant_id"), inverseJoinColumns = @JoinColumn(name = "plant_sunlight_type_id", referencedColumnName = "sunlight_type_id"))
    private Set<SunlightTypesModel> plantSunlightConditions = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "plant_types", joinColumns = @JoinColumn(name = "plant_id"), inverseJoinColumns = @JoinColumn(name = "plant_type_id", referencedColumnName = "plant_type_id"))
    private Set<PlantTypeModel> plantTypes = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "plant_season", joinColumns = @JoinColumn(name = "plant_id"), inverseJoinColumns = @JoinColumn(name="plant_season_id", referencedColumnName = "plant_season_id"))
    private Set<SeasonModel> plantSeasons = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "plant_parts", joinColumns = @JoinColumn(name = "plant_id"), inverseJoinColumns = @JoinColumn(name = "part_id", referencedColumnName = "part_id"))
    private Set<PartModel> plantParts = new HashSet<>();
}
