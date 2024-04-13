package feri.ita.plantdb.model.part_color;

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
    private Long colorId;
    @Column(name = "name")
    private String colorName;
    @ManyToMany(mappedBy = "colors")
    private Set<PartModel> parts = new HashSet<>();
}
