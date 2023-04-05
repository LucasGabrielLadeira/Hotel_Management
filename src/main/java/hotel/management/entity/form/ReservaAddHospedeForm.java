package hotel.management.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaAddHospedeForm {

    private String hospedeCpf;

    private Long reservaId;
}
