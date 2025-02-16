package pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AirlinePojo {

    private String id;
    private String name;
    private String country;
    private String logo;
    private String slogan;
    private String head_quaters;
    private String website;
    private String established;
}
