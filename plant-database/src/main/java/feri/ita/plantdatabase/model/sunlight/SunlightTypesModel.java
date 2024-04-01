package feri.ita.plantdatabase.model.sunlight;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sunlight_types")
public class SunlightTypesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sunlight_type_id", nullable = false)
    private Long sunlightTypeId;
    @Column(name = "sunlight_type_name", nullable = false)
    private String sunlightTypeName;
}
