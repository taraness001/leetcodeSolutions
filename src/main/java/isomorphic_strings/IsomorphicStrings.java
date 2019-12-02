package isomorphic_strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {

	public boolean isIsomorphic(String s, String t) {
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();

		Map<Character, Character> keyMap = new HashMap<>();
		Set<Character> valueDup = new HashSet<>();


		for (int index=0; index < s.length(); index++) {

			if (keyMap.containsKey(sArray[index])) {
				if (!keyMap.get(sArray[index]).equals(tArray[index])) return false;
			}
			else {
				if (valueDup.contains(tArray[index])) return false;

				keyMap.put(sArray[index], tArray[index]);
				valueDup.add(tArray[index]);
			}
		}

		return true;
	}
}
