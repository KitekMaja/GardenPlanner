package feri.ita.plantdb.dao.time;

import feri.ita.plantdb.dto.time.SeasonDTO;

import java.util.List;

public interface ISeasonRepository {
    SeasonDTO getSeasonById(Long id);
    SeasonDTO getSeasonByName(String name);
    void addSeason(SeasonDTO season);
    List<SeasonDTO> getAllSeasons();
    SeasonDTO updateSeason(SeasonDTO season);
    void deleteSeason(Long id);
}
