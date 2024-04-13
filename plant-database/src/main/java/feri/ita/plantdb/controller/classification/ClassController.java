package feri.ita.plantdb.controller.classification;

import feri.ita.plantdb.dao.classification.impl.ClassRepository;
import feri.ita.plantdb.dto.classification.ClassDTO;
import feri.ita.plantdb.service.classification.impl.ClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gp/pdb/classification/classAPI")
public class ClassController {
    private static final Logger log = LoggerFactory.getLogger(ClassController.class);
    private final ClassRepository repository;
    private final ClassService classService;

    public ClassController(ClassRepository repository, ClassService classService) {
        this.repository = repository;
        this.classService = classService;
    }

    @GetMapping("/getAllClasses")
    public ResponseEntity<List<ClassDTO>> getAllClasses()
    {
        try
        {
            List<ClassDTO> classes = classService.getAllClassDTOs();
            return ResponseEntity.ok().body(classes);
        }
        catch(Exception e)
        {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
