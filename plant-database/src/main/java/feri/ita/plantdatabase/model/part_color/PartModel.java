package feri.ita.plantdatabase.model.part_color;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "part")
public class PartModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "part_id", nullable = false)
    private Long partId;
    @Column(name = "part_name", nullable = false)
    private String partName;
}
