package feri.ita.plantdb.controller.classification;

import feri.ita.plantdb.dto.classification.ClassDTO;
import feri.ita.plantdb.service.classification.impl.ClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gp/pdb/classification/classAPI")
public class ClassController {
    private static final Logger log = LoggerFactory.getLogger(ClassController.class);

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping("/getAllClasses")
    public ResponseEntity<List<ClassDTO>> getAllClassDTOs() {
        try {
            List<ClassDTO> classes = classService.getAllClassDTOs();
            return ResponseEntity.ok().body(classes);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/getClassByName")
    public ResponseEntity<ClassDTO> getClassDTOByName(String name) {
        try {
            ClassDTO classDTO = classService.getClassDTOByName(name);
            return ResponseEntity.ok().body(classDTO);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/addClass")
    public ResponseEntity<ClassDTO> addClass(@RequestBody ClassDTO classDTO) {
        try {
            ClassDTO addedClass = classService.addClass(classDTO);
            return ResponseEntity.ok().body(addedClass);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/modifyClass")
    public ResponseEntity<ClassDTO> updateClass(String className, @RequestBody ClassDTO classDTO)
    {
        try
        {
            ClassDTO updatedClass = classService.updateClass(className, classDTO);
            return ResponseEntity.ok().body(updatedClass);
        }
        catch(Exception e)
        {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
