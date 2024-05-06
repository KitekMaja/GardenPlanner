package feri.ita.plantdb.controller.classification;

import feri.ita.plantdb.dto.classification.ClassificationDTO;
import feri.ita.plantdb.exception.ClassificationException;
import feri.ita.plantdb.service.impl.classification.ClassificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classification")
public class ClassificationController {
    private static final Logger LOG = LoggerFactory.getLogger(ClassificationController.class);
    private final ClassificationService classificationService;

    public ClassificationController(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    /**
     * Retrieves a list of all ClassificationDTO objects.
     *
     * @return a ResponseEntity containing a list of ClassificationDTO objects with HTTP status 200 OK
     * or an empty list if no classes are found, or HTTP status 500 Internal Server Error if there is an unknown error during retrieval
     */
    @GetMapping("/getAllClassifications")
    public ResponseEntity<List<ClassificationDTO>> getAllClassificationDTOs() {
        try {
            List<ClassificationDTO> classifications = classificationService.getAll();
            return ResponseEntity.ok().body(classifications);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * Adds a new ClassificationDTO object.
     *
     * @param classificationDTO the ClassificationDTO object to add
     * @return a ResponseEntity containing the added ClassificationDTO object with HTTP status 200 OK
     * or HTTP status 409 Conflict if a conflict occurs
     * or HTTP status 500 Internal Server Error if an error occurs
     */
    @PostMapping("/addClassification")
    public ResponseEntity<ClassificationDTO> addClassification(@RequestBody ClassificationDTO classificationDTO) {
        try {
            ClassificationDTO classification = classificationService.add(classificationDTO);
            return ResponseEntity.ok().body(classification);
        } catch (ClassificationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * Deletes a ClassificationDTO object by its name.
     *
     * @param classificationName the name of the ClassificationDTO object to delete
     * @return a ResponseEntity with HTTP status 200 OK if the deletion is successful
     * or HTTP status 404 Not Found if the phylum with the given name is not found
     * or HTTP status 500 Internal Server Error if an error occurs
     */
    @DeleteMapping("/deleteClassification")
    public ResponseEntity<Void> deleteClassification(@RequestParam String classificationName) {
        try {
            classificationService.deleteByName(classificationName);
            return ResponseEntity.ok().build();
        } catch (ClassificationException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/updateClassification")
    public ResponseEntity<ClassificationDTO> updateClassification(@RequestParam String classificationName, @RequestBody ClassificationDTO classificationDTO) {
        try {
            ClassificationDTO updatedClassification = classificationService.update(classificationName, classificationDTO);
            return ResponseEntity.ok().body(updatedClassification);
        } catch (ClassificationException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/getClassificationsByType")
    public ResponseEntity<List<ClassificationDTO>> getClassificationsByType(@RequestParam String genusName, @RequestParam String className, @RequestParam String familyName, @RequestParam String orderName, @RequestParam String phylumName) {
        try {
            List<ClassificationDTO> classifications = classificationService.retrieveClassificationsByType(genusName, className, familyName, orderName, phylumName);
            return ResponseEntity.ok().body(classifications);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}