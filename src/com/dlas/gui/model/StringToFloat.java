package com.dlas.gui.model;

import org.eclipse.core.databinding.conversion.IConverter;

public class StringToFloat implements IConverter{

	@Override
	public Object convert(Object fromObject) {
		// TODO Auto-generated method stub
		
		return Float.parseFloat((String) fromObject);
	}

	@Override
	public Object getFromType() {
		// TODO Auto-generated method stub
		return String.class;
	}

	@Override
	public Object getToType() {
		// TODO Auto-generated method stub
		return Float.class;
	}

}
