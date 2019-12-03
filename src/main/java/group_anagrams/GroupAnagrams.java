package group_anagrams;

import java.util.*;

public class GroupAnagrams {


	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> retList = new HashMap<>();

		for (String str :  strs) {
			char[] strArray = str.toCharArray();
			Arrays.sort(strArray);
			String sortString = String.valueOf(strArray);

			if (retList.containsKey(sortString)) {
				retList.get(sortString).add(str);
			}
			else {
				List<String> insertList = new ArrayList<>();
				insertList.add(str);
				retList.put(sortString, insertList);
			}

		}

		return new ArrayList<>(retList.values());
	}

}
