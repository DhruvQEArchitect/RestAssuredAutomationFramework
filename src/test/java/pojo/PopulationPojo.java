package pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PopulationPojo {

    private String idNation;
    private String nation;
    private int idYear;
    private String year;
    private long population;
    private String slugNation;
}
