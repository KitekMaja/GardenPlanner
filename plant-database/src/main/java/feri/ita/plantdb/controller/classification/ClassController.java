package feri.ita.plantdb.controller.classification;

import feri.ita.plantdb.dto.classification.ClassDTO;
import feri.ita.plantdb.exception.ClassificationException;
import feri.ita.plantdb.service.impl.classification.ClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classification/classAPI")
public class ClassController {
    private static final Logger LOG = LoggerFactory.getLogger(ClassController.class);

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    /**
     * Retrieves a list of all ClassDTO objects.
     *
     * @return a ResponseEntity containing a list of ClassDTO objects with HTTP status 200 OK
     * or an empty list if no classes are found, or HTTP status 500 Internal Server Error if there is an unknown error during retrieval
     */
    @GetMapping("/getAllClasses")
    public ResponseEntity<List<ClassDTO>> getAllClassDTOs() {
        try {
            List<ClassDTO> classes = classService.getAll();
            return ResponseEntity.ok().body(classes);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * Adds a new ClassDTO object.
     *
     * @param classDTO the ClassDTO object to add
     * @return a ResponseEntity containing the added ClassDTO object with HTTP status 200 OK
     * or HTTP status 409 Conflict if a conflict occurs
     * or HTTP status 500 Internal Server Error if an error occurs
     */
    @PostMapping("/addClass")
    public ResponseEntity<ClassDTO> addClass(@RequestBody ClassDTO classDTO) {
        try {
            ClassDTO addedClass = classService.add(classDTO);
            return ResponseEntity.ok().body(addedClass);
        } catch (ClassificationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }


    /**
     * Deletes a ClassDTO object by its name.
     *
     * @param className the name of the ClassDTO object to delete
     * @return a ResponseEntity with HTTP status 200 OK if the deletion is successful
     * or HTTP status 404 Not Found if the class with the given name is not found
     * or HTTP status 500 Internal Server Error if an error occurs
     */
    @DeleteMapping("/deleteClass")
    public ResponseEntity<Void> deleteClass(@RequestParam String className) {
        try {
            classService.deleteByName(className);
            return ResponseEntity.ok().build();
        } catch (ClassificationException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
