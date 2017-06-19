package com.dlas.gui.model;

import org.eclipse.core.databinding.conversion.IConverter;

public class IntegerToString  implements IConverter {

	@Override
	public Object convert(Object fromObject) {
		// TODO Auto-generated method stub
		return String.valueOf((String) fromObject);
	}

	@Override
	public Object getFromType() {
		// TODO Auto-generated method stub
		return Integer.class;
	}

	@Override
	public Object getToType() {
		// TODO Auto-generated method stub
		return String.class;
	}

}
