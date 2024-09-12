package ci.apirest.forum.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForumDTO {
    private Long id;
    private String slug;
    private String nom;
    private String description;
    private List<SujetDTO> sujets; // Pour inclure les sujets dans le DTO du forum
}