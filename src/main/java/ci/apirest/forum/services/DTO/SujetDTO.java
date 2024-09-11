package ci.apirest.forum.services.DTO;

import lombok.Data;

@Data
public class SujetDTO {
    private Long id;
    private String title;
    private String content;
    private Long forumId;
}
