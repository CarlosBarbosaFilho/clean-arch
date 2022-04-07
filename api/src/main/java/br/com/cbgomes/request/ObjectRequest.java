package br.com.cbgomes.request;

import br.com.cbgomes.helper.ConverterUtils;
import br.com.cbgomes.ports.data.input.ObjectInputPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObjectRequest {

    private String name;

}
