package plast.org.ua.upu.transliter;

import java.util.HashMap;
import java.util.Map;

public class Transliterator {
	private static final Map<Character, String> charMap = new HashMap<Character, String>();

    static {
        charMap.put('À', "A");
        charMap.put('Á', "B");
        charMap.put('Â', "V");
        charMap.put('Ã', "H");
        charMap.put('¥', "G");
        charMap.put('Ä', "D");
        charMap.put('Å', "E");
        charMap.put('ª', "Ye");
        charMap.put('Æ', "Zh");
        charMap.put('Ç', "Z");
        charMap.put('È', "Y");
        charMap.put('²', "I");
        charMap.put('¯', "Yi");
        charMap.put('É', "YY");
        charMap.put('Ê', "K");
        charMap.put('Ë', "L");
        charMap.put('Ì', "M");
        charMap.put('Í', "N");
        charMap.put('Î', "O");
        charMap.put('Ï', "P");
        charMap.put('Ğ', "R");
        charMap.put('Ñ', "S");
        charMap.put('Ò', "T");
        charMap.put('Ó', "U");
        charMap.put('Ô', "F");
        charMap.put('Õ', "Kh");
        charMap.put('Ö', "Ts");
        charMap.put('×', "Ch");
        charMap.put('Ø', "Sh");
        charMap.put('Ù', "Sch");
        charMap.put('Ü', "'");
        charMap.put('Ş', "Yu");
        charMap.put('ß', "Ya");
        charMap.put('à', "a");
        charMap.put('á', "b");
        charMap.put('â', "v");
        charMap.put('ã', "h");
        charMap.put('´', "g");
        charMap.put('ä', "d");
        charMap.put('å', "e");
        charMap.put('º', "ye");
        charMap.put('æ', "zh");
        charMap.put('ç', "z");
        charMap.put('è', "y");
        charMap.put('³', "i");
        charMap.put('¿', "yi");
        charMap.put('é', "yy");
        charMap.put('ê', "k");
        charMap.put('ë', "l");
        charMap.put('ì', "m");
        charMap.put('í', "n");
        charMap.put('î', "o");
        charMap.put('ï', "p");
        charMap.put('ğ', "r");
        charMap.put('ñ', "s");
        charMap.put('ò', "t");
        charMap.put('ó', "u");
        charMap.put('ô', "f");
        charMap.put('õ', "kh");
        charMap.put('ö', "ts");
        charMap.put('÷', "ch");
        charMap.put('ø', "sh");
        charMap.put('ù', "sch");
        charMap.put('ü', "'");
        charMap.put('ş', "yu");
        charMap.put('ÿ', "ya");

    }

    public String transliterate(String string) {
        StringBuilder transliteratedString = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            Character ch = string.charAt(i);
            if(ch != ' '){
            String charFromMap = charMap.get(ch);
            if (charFromMap == null) {
                transliteratedString.append(ch);
            } else {
                transliteratedString.append(charFromMap);
            }
            }
        }
        return transliteratedString.toString();
    }
   
}
