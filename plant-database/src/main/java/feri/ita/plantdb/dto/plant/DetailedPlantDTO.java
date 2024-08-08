package feri.ita.plantdb.dto.plant;

import feri.ita.plantdb.dto.hardiness_zones.HardinessZoneDTO;
import feri.ita.plantdb.dto.lifespan.LifespanDTO;
import feri.ita.plantdb.dto.part_color.PartDTO;
import feri.ita.plantdb.dto.propagation.PropagationTechniqueDTO;
import feri.ita.plantdb.dto.soil.SoilDTO;
import feri.ita.plantdb.dto.sunlight.SunlightTypeDTO;
import feri.ita.plantdb.dto.time.SeasonDTO;
import feri.ita.plantdb.model.classification.ClassificationModel;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class DetailedPlantDTO {
    private Long plantId;
    private String botanicalName;
    private Boolean poisonous;
    private String description;
    private Float minPlantTemperature;
    private Float maxPlantTemperature;
    private String interestingFact;
    private String symbolism;
    private Float plantHeight;
    private Float spread;
    private Float flowerSize;
    private String waterInfo;
    private String fertilizerInfo;
    private String pruning;
    private String potting;
    private String careDifficulty;
    private ClassificationModel scientificClassification;
    private Set<PlantNameDTO> plantNames = new HashSet<>();
    private Set<HardinessZoneDTO> plantHardinessZones = new HashSet<>();
    private Set<HabitatDTO> plantHabitats = new HashSet<>();
    private Set<LifespanDTO> plantLifespans = new HashSet<>();
    private Set<PropagationTechniqueDTO> plantPropagationTechniques = new HashSet<>();
    private Set<SoilDTO> plantSoilTypes = new HashSet<>();
    private Set<SunlightTypeDTO> plantSunlightConditions = new HashSet<>();
    private Set<PlantTypeDTO> plantTypes = new HashSet<>();
    private Set<SeasonDTO> plantSeasons = new HashSet<>();
    private Set<PartDTO> plantParts = new HashSet<>();
}
