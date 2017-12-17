package com.dlas.gui.model;

import org.eclipse.core.databinding.conversion.IConverter;

public class FloatToString  implements IConverter {

	@Override
	public Object convert(Object fromObject) {
		if(fromObject == null) {
			return "";
		}
		return Float.toString((Float) fromObject);
	}

	@Override
	public Object getFromType() {
		// TODO Auto-generated method stub
		return Float.class;
	}

	@Override
	public Object getToType() {
		// TODO Auto-generated method stub
		return String.class;
	}

}
