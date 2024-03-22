package feri.ita.plantdatabase.model.classification;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.message.AsynchronouslyFormattable;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "class")
public class ClassModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id", nullable = false)
    private long classId;
    @Column(name = "class_name", nullable = false)
    private String className;
}
