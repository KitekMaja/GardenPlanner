package feri.ita.plantdatabase.model.part_color;

import feri.ita.plantdatabase.model.plant.PlantModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "color")
public class ColorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_id")
    private long colorId;
    @Column(name = "color_name")
    private String colorName;
    @ManyToMany(mappedBy = "colors")
    private Set<PartModel> parts = new HashSet<>();
}
