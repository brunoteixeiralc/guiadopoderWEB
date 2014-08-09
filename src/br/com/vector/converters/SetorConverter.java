
package br.com.vector.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.vector.setor.Setor;
import br.com.vector.setor.SetorRN;

@FacesConverter(forClass = Setor.class,value ="setorConverter")
public class SetorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0) {
			Integer codigo = Integer.valueOf(value);
			try {
				SetorRN setorRN = new SetorRN();
				return setorRN.carregar(codigo);
			} catch (Exception e) {
				throw new ConverterException("Não foi possível encontrar a categoria de código " + value + "." + e.getMessage());
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Setor setor = (Setor) value;
			return String.valueOf(setor.getId());
		}
		return "";
	}
}
