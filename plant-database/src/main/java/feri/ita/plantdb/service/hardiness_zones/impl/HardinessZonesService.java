package feri.ita.plantdb.service.hardiness_zones.impl;

import feri.ita.plantdb.dao.impl.hardiness_zones.HardinessZoneRepository;
import feri.ita.plantdb.dao.impl.plant.PlantRepository;
import feri.ita.plantdb.dto.hardiness_zones.HardinessZoneDTO;
import feri.ita.plantdb.dto.plant.PlantDTO;
import feri.ita.plantdb.dto.plant.PlantNameDTO;
import feri.ita.plantdb.exception.ClassificationException;
import feri.ita.plantdb.model.hardiness_zones.HardinessZoneModel;
import feri.ita.plantdb.model.plant.PlantModel;
import feri.ita.plantdb.service.IEntityService;
import feri.ita.plantdb.service.plant.impl.PlantService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HardinessZonesService implements IEntityService<HardinessZoneDTO> {
    /**
     * Exception messages
     */
    private static final String HARDINESS_ZONE_NOT_FOUND = "Hardiness zone with name [%s] not found.";
    private final HardinessZoneRepository hardinessZoneRepository;
    private final PlantRepository plantRepository;
    public HardinessZonesService(HardinessZoneRepository hardinessZoneRepository, PlantRepository plantRepository) {
        this.hardinessZoneRepository = hardinessZoneRepository;
        this.plantRepository = plantRepository;
    }

    /**
     * Retrieves a list of all HardinessZoneDTO objects from the database.
     *
     * @return a list of all HardinessZoneDTO objects
     */
    @Override
    public List<HardinessZoneDTO> getAll() {
        List<HardinessZoneModel> hardinessZones = hardinessZoneRepository.retrieveAllFromDatabase();
        return hardinessZones.stream().map(this::convertToDTOWithoutPlants).collect(Collectors.toList());
    }

    /**
     * Adds a new HardinessZoneDTO object to the database.
     *
     * @param entity the HardinessZoneDTO object to add
     * @return the added HardinessZoneDTO object
     * @throws ClassificationException if a HardinessZoneDTO object with the same name already exists
     */
    @Override
    public HardinessZoneDTO add(HardinessZoneDTO entity) {
        return convertToDTOWithoutPlants(hardinessZoneRepository.addEntityToDatabase(convertDTOToModel(entity)));

    }

    /**
     * Deletes a HardinessZoneDTO object from the database by its name.
     *
     * @param name the name of the entity to delete
     * @throws ClassificationException if the HardinessZoneDTO with the given name is not found in the database
     */
    @Override
    public void deleteByName(String name) {
        HardinessZoneModel model = hardinessZoneRepository.getHardinessZoneByName(name);
        if (model == null) {
            throw new ClassificationException(HARDINESS_ZONE_NOT_FOUND, name);
        }
        hardinessZoneRepository.removeEntityFromDatabase(model);
    }

    /**
     * Converts a HardinessZoneModel object to a HardinessZoneDTO object.
     *
     * @param zoneModel the HardinessZoneModel object to convert
     * @return the corresponding HardinessZoneDTO object
     */
    private HardinessZoneDTO convertToDTOWithoutPlants(HardinessZoneModel zoneModel) {
        HardinessZoneDTO zone = new HardinessZoneDTO();
        zone.setHardinessZoneName(zoneModel.getHardinessZoneName());
        zone.setMinTemperature(zoneModel.getMinTemperature());
        zone.setMaxTemperature(zoneModel.getMaxTemperature());
        return zone;
    }

    /**
     * Converts a HardinessZoneDTO object to a HardinessZoneModel object.
     *
     * @param zoneDTO the HardinessZoneDTO object to convert
     * @return the corresponding HardinessZoneModel object
     */
    private HardinessZoneModel convertDTOToModel(HardinessZoneDTO zoneDTO) {
        HardinessZoneModel zoneModel = new HardinessZoneModel();
        zoneModel.setHardinessZoneName(zoneDTO.getHardinessZoneName());
        zoneModel.setMinTemperature(zoneDTO.getMinTemperature());
        zoneModel.setMaxTemperature(zoneDTO.getMaxTemperature());

        PlantService plantService = new PlantService();
        // add plants
        return zoneModel;
    }

    private PlantDTO convertPlantToDTO(PlantModel plantModel) {
        PlantDTO plant = new PlantDTO();
        plant.setBotanicalName(plantModel.getBotanicalName());
        plant.setMinPlantTemperature(plantModel.getMinPlantTemperature());
        plant.setMaxPlantTemperature(plantModel.getMaxPlantTemperature());
        return plant;
    }
}
