package feri.ita.plantdb.model.plant;

import feri.ita.plantdb.model.classification.ClassificationModel;
import feri.ita.plantdb.model.hardiness_zones.HardinessZoneModel;
import feri.ita.plantdb.model.lifespan.LifespanModel;
import feri.ita.plantdb.model.part_color.PartModel;
import feri.ita.plantdb.model.propagation.PropagationTechniqueModel;
import feri.ita.plantdb.model.soil.SoilTypeModel;
import feri.ita.plantdb.model.sunlight.SunlightTypesModel;
import feri.ita.plantdb.model.time.SeasonModel;
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
    @Column(name = "flower_size")
    private Float flowerSize;
    @Column(name = "watering_information")
    private String waterInfo;
    @Column(name = "fertilization_information")
    private String fertilizerInfo;
    private String pruning;
    private String potting;
    @Column(name = "difficulty_description")
    private String careDifficulty;
    @OneToOne
    @JoinColumn(name = "classification_id", referencedColumnName="classification_id")
    private ClassificationModel scientificClassification;
    @OneToMany(mappedBy = "plant")
    private Set<PlantNameModel> plantNames = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "plant_hardiness_zones",
            joinColumns = @JoinColumn(name = "plant_id"),
            inverseJoinColumns = @JoinColumn(name = "zone_id"))
    private Set<HardinessZoneModel> plantHardinessZones = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "plant_habitats", joinColumns = @JoinColumn(name = "plant_id"), inverseJoinColumns = @JoinColumn(name = "habitat_id"))
    private Set<HabitatModel> plantHabitats = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "plant_lifespans", joinColumns = @JoinColumn(name = "plant_id"), inverseJoinColumns = @JoinColumn(name = "lifespan_id"))
    private Set<LifespanModel> plantLifespans = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "plant_propagation_techniques", joinColumns = @JoinColumn(name = "plant_id"), inverseJoinColumns = @JoinColumn(name = "propagation_technique_id", referencedColumnName = "technique_id"))
    private Set<PropagationTechniqueModel> plantPropagationTechniques = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "plant_soil_types", joinColumns = @JoinColumn(name = "plant_id"), inverseJoinColumns = @JoinColumn(name = "soil__id"))
    private Set<SoilTypeModel> plantSoilTypes = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "plant_sunlight_conditions", joinColumns = @JoinColumn(name = "plant_id"), inverseJoinColumns = @JoinColumn(name = "plant_sunlight_type_id", referencedColumnName = "sunlight_id"))
    private Set<SunlightTypesModel> plantSunlightConditions = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "plant_types", joinColumns = @JoinColumn(name = "plant_id"), inverseJoinColumns = @JoinColumn(name = "plant_type_id"))
    private Set<PlantTypeModel> plantTypes = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "plant_season", joinColumns = @JoinColumn(name = "plant_id"), inverseJoinColumns = @JoinColumn(name = "plant_season_id", referencedColumnName = "season_id"))
    private Set<SeasonModel> plantSeasons = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "plant_parts", joinColumns = @JoinColumn(name = "plant_id"), inverseJoinColumns = @JoinColumn(name = "plant_part_id"))
    private Set<PartModel> plantParts = new HashSet<>();
}
