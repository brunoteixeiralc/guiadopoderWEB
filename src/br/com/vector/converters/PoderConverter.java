
package br.com.vector.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.vector.poder.Poder;
import br.com.vector.poder.PoderRN;

@FacesConverter(forClass = Poder.class,value ="poderConverter")
public class PoderConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0) {
			Integer codigo = Integer.valueOf(value);
			try {
				PoderRN poderRN = new PoderRN();
				return poderRN.carregar(codigo);
			} catch (Exception e) {
				throw new ConverterException("Não foi possível encontrar a categoria de código " + value + "." + e.getMessage());
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Poder poder = (Poder) value;
			return String.valueOf(poder.getId());
		}
		return "";
	}
}
