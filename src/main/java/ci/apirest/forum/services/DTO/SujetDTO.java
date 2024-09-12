package ci.apirest.forum.services.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SujetDTO {
    private Long id;
    private String titre;
    private Long forumId; // Référence à l'ID du forum associé
    private List<MessageDTO> messages; // Pour inclure les messages dans le DTO du sujet
}