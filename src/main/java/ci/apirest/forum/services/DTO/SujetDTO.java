package ci.apirest.forum.services.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SujetDTO {
    private Long id;
    private String titre;
    private String nom;
    private String slug;
    private Long forumId; // Référence à l'ID du forum associé
    private List<MessageDTO> messages; // Pour inclure les messages dans le DTO du sujet
}