package feri.ita.plantdb.controller.classification;

import feri.ita.plantdb.dto.classification.FamilyDTO;
import feri.ita.plantdb.exception.ClassificationException;
import feri.ita.plantdb.service.impl.classification.FamilyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classification/familyAPI")
public class FamilyController {
    private static final Logger log = LoggerFactory.getLogger(FamilyController.class);

    private final FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    /**
     * Retrieves a list of all FamilyDTO objects.
     *
     * @return a ResponseEntity containing a list of FamilyDTO objects with HTTP status 200 OK
     * or an empty list if no families are found, or HTTP status 500 Internal Server Error if there is an unknown error during retrieval
     */
    @GetMapping("/getAllFamilies")
    public ResponseEntity<List<FamilyDTO>> getAllFamilies() {
        try {
            List<FamilyDTO> families = familyService.getAll();
            return ResponseEntity.ok().body(families);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * Adds a new FamilyDTO object.
     *
     * @param familyDTO the FamilyDTO object to add
     * @return a ResponseEntity containing the added FamilyDTO object with HTTP status 200 OK
     * or HTTP status 409 Conflict if a conflict occurs
     * or HTTP status 500 Internal Server Error if an error occurs
     */
    @PostMapping("/addFamily")
    public ResponseEntity<FamilyDTO> addFamily(@RequestBody FamilyDTO familyDTO) {
        try {
            FamilyDTO addedFamily = familyService.add(familyDTO);
            return ResponseEntity.ok().body(addedFamily);
        } catch (ClassificationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * Deletes a FamilyDTO object by its name.
     *
     * @param familyName the name of the FamilyDTO object to delete
     * @return a ResponseEntity with HTTP status 200 OK if the deletion is successful
     * or HTTP status 404 Not Found if the family with the given name is not found
     * or HTTP status 500 Internal Server Error if an error occurs
     */
    @DeleteMapping("/deleteFamily")
    public ResponseEntity<Void> deleteFamily(@RequestParam String familyName) {
        try {
            familyService.deleteByName(familyName);
            return ResponseEntity.ok().build();
        } catch (ClassificationException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}