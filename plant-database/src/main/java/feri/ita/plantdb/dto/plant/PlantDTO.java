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
public class PlantDTO {
    private Long plantId;
    private String botanicalName;
    private String description;
    private Float minPlantTemperature;
    private Float maxPlantTemperature;
}

