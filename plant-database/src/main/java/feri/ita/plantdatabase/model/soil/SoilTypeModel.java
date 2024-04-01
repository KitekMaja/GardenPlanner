package feri.ita.plantdatabase.model.soil;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "soil_type")
public class SoilTypeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "soil_type_id", nullable = false)
    private Long soilTypeId;
    @Column(name = "soil_type_name", nullable = false)
    private String soilTypeName;
}
