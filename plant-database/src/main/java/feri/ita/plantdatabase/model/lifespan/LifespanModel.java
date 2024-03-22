package feri.ita.plantdatabase.model.lifespan;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lifespan")
public class LifespanModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lifespan_id", nullable = false)
    private Long lifespanId;
    @Column(name = "lifespan_name", nullable = false)
    private String lifespanName;
}
