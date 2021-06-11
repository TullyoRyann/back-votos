package com.back.votos.util;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class CpfUtil {

	private CpfUtil() {
	}

	public static String formatarCpf(String cpf) {
		MaskFormatter mask;
		try {
			mask = new MaskFormatter("###.###.###-##");
			mask.setValueContainsLiteralCharacters(false);
			return mask.valueToString(cpf);
		} catch (ParseException e) {
		}

		return cpf;
	}

}
