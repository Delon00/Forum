package ci.apirest.forum.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "forums")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Forum implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String slug;

    @NotBlank(message = "Le nom (titre) est obligatoire.")
    @Size(max = 100, message = "Le nom ne doit pas dépasser 100 caractères.")
    @Column(nullable = false, length = 100)
    private String nom;

    @NotBlank(message = "La description est obligatoire.")
    @Size(max = 500, message = "La description ne doit pas dépasser 500 caractères.")
    @Column(nullable = false, length = 500)
    private String description;

    @OneToMany(mappedBy = "forum", cascade = CascadeType.ALL)
    private List<Sujet> sujets;
}