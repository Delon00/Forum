package ci.apirest.forum.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {
    private Long id;
    private String contenu;
    private Long sujetId; // Référence à l'ID du sujet associé
}