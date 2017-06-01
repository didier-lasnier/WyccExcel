package com.dlas.tools;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

public class Tools {

	public Tools() {
	}

	public static Logger logger = Logger.getLogger("wycc");

	public static String getNewNumColonne(String formule, String pattern, int colStart, int colOffset) {
		//logger.info("Formule entrante : " + formule);
		// List<String> allMatches = new ArrayList<String>();
		Matcher m = Pattern.compile(pattern).matcher(formule);

		String str = null;
		while (m.find()) {
			if (!m.group().startsWith("$")) {
				if (m.group().length() != 0) {
					int colInt = 0;
					int compteur = 1;
					int ascii = 0;
					while (compteur <= m.group().length()) {

						if (compteur < m.group().length()) {
							ascii = m.group().substring(compteur - 1, compteur).charAt(0) - 64;
							colInt = colInt + (colStart * ascii);
						} else {
							ascii = m.group().substring(compteur - 1, compteur).charAt(0);
							colInt = colInt + (ascii - 64);
						}
						compteur++;
					}

					String replacement = "";
					int colonenumber = 0;

					colonenumber = 64 + ((colOffset + colInt) / 26);
					if ((colOffset + colInt) > 26) {
						if ((colOffset + colInt) % 26 != 0) {
							replacement = Character.toString((char) colonenumber);
						} else {
							replacement = Character.toString((char) (colonenumber - 1));
						}
					}
					// String replacement=Character.toString((char)
					// (64+((colOffset+colInt)/26)))
					if ((colOffset + colInt) % 26 == 0) {
						replacement = replacement + "Z";
					} else {
						replacement = replacement + Character.toString((char) (64 + ((colOffset + colInt) % 26)));

					}

					formule = formule.replace(m.group(), replacement);
				}
			}
		}

		return formule;

	}

	
	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) 
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
	
	public static <T> List<T> distinctList(List<T> list, Function<? super T, ?>... keyExtractors) {

	    return list
	        .stream()
	        .filter(distinctByKeys(keyExtractors))
	        .collect(Collectors.toList());
	}

	private static <T> Predicate<T> distinctByKeys(Function<? super T, ?>... keyExtractors) {

	    final Map<List<?>, Boolean> seen = new ConcurrentHashMap<>();

	    return t -> {

	        final List<?> keys = Arrays.stream(keyExtractors)
	            .map(ke -> ke.apply(t))
	            .collect(Collectors.toList());

	        return seen.putIfAbsent(keys, Boolean.TRUE) == null;

	    };

	}
	
}
