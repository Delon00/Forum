package ci.apirest.forum.services.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ForumDTO {
    private Long id;
    private String slug;
    private String nom;
    private String description;
    private List<SujetDTO> sujets; // Pour inclure les sujets dans le DTO du forum
}