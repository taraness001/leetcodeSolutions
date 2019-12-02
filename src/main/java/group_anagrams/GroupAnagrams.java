package group_anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> retList = new ArrayList<>();
		List<Map<Character, Integer>> anagramList = new ArrayList<>();

		for (String str :  strs) {
			Map<Character, Integer> anagramMap = new HashMap<>();
			char[] strArray = str.toCharArray();

			for (char c : strArray) {
				if (anagramMap.containsKey(c)) {
					anagramMap.put(c, anagramMap.get(c) + 1);
				}
				else {
					anagramMap.put(c, 1);
				}
			}

			boolean insertFlag = true;
			for (int index = 0; index < anagramList.size(); index++) {
				Map<Character, Integer> listMap = anagramList.get(index);
				if (diffMap(anagramMap, listMap)) {
					insertFlag = false;
					retList.get(index).add(str);
				}
			}

			if (insertFlag) {
				anagramList.add(anagramMap);
				List<String> newList = new ArrayList<>();
				newList.add(str);
				retList.add(newList);
			}
		}

		return retList;
	}


	public boolean diffMap (Map<Character, Integer> anagramMap, Map<Character, Integer> listMap) {
		for (Map.Entry<Character, Integer> listMapEntry : listMap.entrySet()) {
			if (!anagramMap.containsKey(listMapEntry.getKey()) || !anagramMap.get(listMapEntry.getKey()).equals(listMapEntry.getValue())) return false;
		}






		return true;
	}

}
