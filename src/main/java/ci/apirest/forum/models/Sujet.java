package ci.apirest.forum.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "sujets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sujet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le titre est obligatoire.")
    @Size(max = 150, message = "Le titre ne doit pas dépasser 150 caractères.")
    @Column(nullable = false, length = 150)
    private String titre;

    @Column(unique = true)
    private String slug;

    @NotBlank(message = "Le nom est obligatoire.")
    @Size(max = 100, message = "Le nom ne doit pas dépasser 100 caractères.")
    @Column(nullable = false, length = 100)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "forum_id", nullable = false)
    private Forum forum;

    @OneToMany(mappedBy = "sujet", cascade = CascadeType.ALL)
    private List<Message> messages;
}