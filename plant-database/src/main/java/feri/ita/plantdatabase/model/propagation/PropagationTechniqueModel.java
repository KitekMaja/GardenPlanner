package feri.ita.plantdatabase.model.propagation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "propagation_technique")
public class PropagationTechniqueModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "propagation_technique_id")
    private long propagationTechniqueId;
    @Column(name = "propagation_technique_name", nullable = false)
    private String propagationTechniqueName;
}
