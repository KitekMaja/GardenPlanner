package feri.ita.plantdatabase.dao.time.impl;

import feri.ita.plantdatabase.dao.time.ISeasonRepository;
import feri.ita.plantdatabase.dto.time.SeasonDTO;

import java.util.List;

public class SeasonRepository implements ISeasonRepository {
    /**
     * @param id
     * @return
     */
    @Override
    public SeasonDTO getSeasonById(Long id) {
        return null;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public SeasonDTO getSeasonByName(String name) {
        return null;
    }

    /**
     * @param season
     */
    @Override
    public void addSeason(SeasonDTO season) {

    }

    /**
     * @return
     */
    @Override
    public List<SeasonDTO> getAllSeasons() {
        return null;
    }

    /**
     * @param season
     * @return
     */
    @Override
    public SeasonDTO updateSeason(SeasonDTO season) {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deleteSeason(Long id) {

    }
}
