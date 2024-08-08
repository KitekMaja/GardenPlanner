package feri.ita.plantdb.dto.hardiness_zones;

import feri.ita.plantdb.dto.plant.PlantDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class HardinessZoneDTO {
    private String hardinessZoneName;
    private Float minTemperature;
    private Float maxTemperature;
    private Set<PlantDTO> plants = new HashSet<>();
}
