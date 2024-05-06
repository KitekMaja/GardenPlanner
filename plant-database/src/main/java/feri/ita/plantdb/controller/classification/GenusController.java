package feri.ita.plantdb.controller.classification;

import feri.ita.plantdb.dto.classification.GenusDTO;
import feri.ita.plantdb.exception.ClassificationException;
import feri.ita.plantdb.service.impl.classification.GenusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classification/genus")
public class GenusController {
    private static final Logger LOG = LoggerFactory.getLogger(GenusController.class);
    private final GenusService genusService;

    public GenusController(GenusService genusService) {
        this.genusService = genusService;
    }

    /**
     * Retrieves a list of all GenusDTO objects.
     *
     * @return a ResponseEntity containing a list of GenusDTO objects with HTTP status 200 OK
     * or an empty list if no genus are found, or HTTP status 500 Internal Server Error if there is an unknown error during retrieval
     */
    @GetMapping("/getAllGenuses")
    public ResponseEntity<List<GenusDTO>> getAllGenusDTOs() {
        try {
            List<GenusDTO> genuses = genusService.getAll();
            return ResponseEntity.ok().body(genuses);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * Adds a new GenusDTO object.
     *
     * @param genusDTO the GenusDTO object to add
     * @return a ResponseEntity containing the added GenusDTO object with HTTP status 200 OK
     * or HTTP status 409 Conflict if a conflict occurs
     * or HTTP status 500 Internal Server Error if an error occurs
     */
    @PostMapping("/addGenus")
    public ResponseEntity<GenusDTO> addClass(@RequestBody GenusDTO genusDTO) {
        try {
            GenusDTO addedGenus = genusService.add(genusDTO);
            return ResponseEntity.ok().body(addedGenus);
        } catch (ClassificationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }


    /**
     * Deletes a GenusDTO object by its name.
     *
     * @param genusName the name of the GenusDTO object to delete
     * @return a ResponseEntity with HTTP status 200 OK if the deletion is successful
     * or HTTP status 404 Not Found if the genus with the given name is not found
     * or HTTP status 500 Internal Server Error if an error occurs
     */
    @DeleteMapping("/deleteGenus")
    public ResponseEntity<Void> deleteClass(@RequestParam String genusName) {
        try {
            genusService.deleteByName(genusName);
            return ResponseEntity.ok().build();
        } catch (ClassificationException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
