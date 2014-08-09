
package br.com.vector.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.vector.cargo.Cargo;
import br.com.vector.cargo.CargoRN;

@FacesConverter(forClass = Cargo.class,value ="cargoConverter")
public class CargoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0) {
			Integer codigo = Integer.valueOf(value);
			try {
				CargoRN cargoRN = new CargoRN();
				return cargoRN.carregar(codigo);
			} catch (Exception e) {
				throw new ConverterException("Não foi possível encontrar a categoria de código " + value + "." + e.getMessage());
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Cargo cargo = (Cargo) value;
			return String.valueOf(cargo.getId());
		}
		return "";
	}
}
