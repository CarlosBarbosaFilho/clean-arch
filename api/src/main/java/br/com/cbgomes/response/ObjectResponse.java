package br.com.cbgomes.response;

import br.com.cbgomes.helper.ConverterUtils;
import br.com.cbgomes.ports.data.output.ObjectOutputPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObjectResponse {

    private Long id;
    private String name;
}
