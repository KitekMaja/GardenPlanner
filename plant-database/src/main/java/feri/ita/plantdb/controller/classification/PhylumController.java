package feri.ita.plantdb.controller.classification;

import feri.ita.plantdb.dto.classification.PhylumDTO;
import feri.ita.plantdb.exception.ClassificationException;
import feri.ita.plantdb.service.impl.classification.PhylumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classification/phylum")
public class PhylumController {
    private static final Logger LOG = LoggerFactory.getLogger(PhylumController.class);
    private final PhylumService phylumService;

    public PhylumController(PhylumService phylumService) {
        this.phylumService = phylumService;
    }

    /**
     * Retrieves a list of all PhylumDTO objects.
     *
     * @return a ResponseEntity containing a list of PhylumDTO objects with HTTP status 200 OK
     * or an empty list if no classes are found, or HTTP status 500 Internal Server Error if there is an unknown error during retrieval
     */
    @GetMapping("/getAllPhylums")
    public ResponseEntity<List<PhylumDTO>> getAllPhylumDTOs() {
        try {
            List<PhylumDTO> phylumDTOS = phylumService.getAll();
            return ResponseEntity.ok().body(phylumDTOS);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * Adds a new PhylumDTO object.
     *
     * @param phylumDTO the PhylumDTO object to add
     * @return a ResponseEntity containing the added PhylumDTO object with HTTP status 200 OK
     * or HTTP status 409 Conflict if a conflict occurs
     * or HTTP status 500 Internal Server Error if an error occurs
     */
    @PostMapping("/addPhylum")
    public ResponseEntity<PhylumDTO> addClass(@RequestBody PhylumDTO phylumDTO) {
        try {
            PhylumDTO phylum = phylumService.add(phylumDTO);
            return ResponseEntity.ok().body(phylum);
        } catch (ClassificationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * Deletes a PhylumDTO object by its name.
     *
     * @param phylumName the name of the PhylumDTO object to delete
     * @return a ResponseEntity with HTTP status 200 OK if the deletion is successful
     * or HTTP status 404 Not Found if the phylum with the given name is not found
     * or HTTP status 500 Internal Server Error if an error occurs
     */
    @DeleteMapping("/deletePhylum")
    public ResponseEntity<Void> deleteClass(@RequestParam String phylumName) {
        try {
            phylumService.deleteByName(phylumName);
            return ResponseEntity.ok().build();
        } catch (ClassificationException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
