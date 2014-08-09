
package br.com.vector.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.vector.orgao.Orgao;
import br.com.vector.orgao.OrgaoRN;

@FacesConverter(forClass = Orgao.class,value ="orgaoConverter")
public class OrgaoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0) {
			Integer codigo = Integer.valueOf(value);
			try {
				OrgaoRN orgaoRN = new OrgaoRN();
				return orgaoRN.carregar(codigo);
			} catch (Exception e) {
				throw new ConverterException("Não foi possível encontrar a categoria de código " + value + "." + e.getMessage());
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Orgao orgao = (Orgao) value;
			return String.valueOf(orgao.getId());
		}
		return "";
	}
}