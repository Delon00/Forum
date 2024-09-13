package ci.apirest.forum.services.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {
    private Long id;
    private String contenu;
    private Long sujetId; // Référence à l'ID du sujet associé
}