package ci.apirest.forum.services.DTO;

import ci.apirest.forum.models.Sujet;
import lombok.Data;

@Data
public class MessageDTO {
    private Long id;
    private String content;
    private Long sujetId;
}
