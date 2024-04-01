package feri.ita.plantdatabase.model.part_color;

import feri.ita.plantdatabase.model.hardiness_zones.HardinessZoneModel;
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
@Table(name = "part")
public class PartModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "part_id", nullable = false)
    private Long partId;
    @Column(name = "part_name", nullable = false)
    private String partName;
    @ManyToMany
    @JoinTable(name = "part_color", joinColumns = @JoinColumn(name = "part_id", referencedColumnName = "part_id"), inverseJoinColumns = @JoinColumn(name = "color_id", referencedColumnName = "color_id"))
    private Set<HardinessZoneModel> colors = new HashSet<>();
    @ManyToMany(mappedBy = "plantParts")
    private Set<PartModel> parts = new HashSet<>();
}
