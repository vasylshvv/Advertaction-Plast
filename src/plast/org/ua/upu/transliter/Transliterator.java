package plast.org.ua.upu.transliter;

import java.util.HashMap;
import java.util.Map;

public class Transliterator {
	private static final Map<Character, String> charMap = new HashMap<Character, String>();

    static {
        charMap.put('�', "A");
        charMap.put('�', "B");
        charMap.put('�', "V");
        charMap.put('�', "H");
        charMap.put('�', "G");
        charMap.put('�', "D");
        charMap.put('�', "E");
        charMap.put('�', "Ye");
        charMap.put('�', "Zh");
        charMap.put('�', "Z");
        charMap.put('�', "Y");
        charMap.put('�', "I");
        charMap.put('�', "Yi");
        charMap.put('�', "YY");
        charMap.put('�', "K");
        charMap.put('�', "L");
        charMap.put('�', "M");
        charMap.put('�', "N");
        charMap.put('�', "O");
        charMap.put('�', "P");
        charMap.put('�', "R");
        charMap.put('�', "S");
        charMap.put('�', "T");
        charMap.put('�', "U");
        charMap.put('�', "F");
        charMap.put('�', "Kh");
        charMap.put('�', "Ts");
        charMap.put('�', "Ch");
        charMap.put('�', "Sh");
        charMap.put('�', "Sch");
        charMap.put('�', "'");
        charMap.put('�', "Yu");
        charMap.put('�', "Ya");
        charMap.put('�', "a");
        charMap.put('�', "b");
        charMap.put('�', "v");
        charMap.put('�', "h");
        charMap.put('�', "g");
        charMap.put('�', "d");
        charMap.put('�', "e");
        charMap.put('�', "ye");
        charMap.put('�', "zh");
        charMap.put('�', "z");
        charMap.put('�', "y");
        charMap.put('�', "i");
        charMap.put('�', "yi");
        charMap.put('�', "yy");
        charMap.put('�', "k");
        charMap.put('�', "l");
        charMap.put('�', "m");
        charMap.put('�', "n");
        charMap.put('�', "o");
        charMap.put('�', "p");
        charMap.put('�', "r");
        charMap.put('�', "s");
        charMap.put('�', "t");
        charMap.put('�', "u");
        charMap.put('�', "f");
        charMap.put('�', "kh");
        charMap.put('�', "ts");
        charMap.put('�', "ch");
        charMap.put('�', "sh");
        charMap.put('�', "sch");
        charMap.put('�', "'");
        charMap.put('�', "yu");
        charMap.put('�', "ya");

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
