package Q8_04_Power_Set;

import java.util.*;

public class QuestionA {

//	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
//		ArrayList<ArrayList<Integer>> result;
//		if (set.size() == index) {
//			result = new ArrayList<ArrayList<Integer>>();
//			result.add(new ArrayList<Integer>());
//		} else {
//			result = getSubsets(set, index + 1);
//			int item = set.get(index);
//			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
//			for (ArrayList<Integer> subSet: result) {
//				ArrayList<Integer> newSubSet = new ArrayList<Integer>();
//				newSubSet.addAll(subSet);
//				newSubSet.add(item);
//				moreSubsets.add(newSubSet);
//			}
//			result.addAll(moreSubsets);
//		}
//		return result;		
//	}
//	
//	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
//		return getSubsets(set, 0);
//	}
//	==============================================
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allSubSets = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> initiaList =new ArrayList<Integer>();
		
		allSubSets.add(initiaList);
		
		for (int i = 0; i < set.size(); i++) {
			ArrayList<ArrayList<Integer>> moreSubSets = new ArrayList<ArrayList<Integer>>();
			int item = set.get(i);
			
			for(ArrayList<Integer> subSet: allSubSets) {
				
				ArrayList<Integer> newSubSet = new ArrayList<Integer>();
				newSubSet.addAll(subSet);
				newSubSet.add(item);
				
				moreSubSets.add(newSubSet);
			}

			allSubSets.addAll(moreSubSets);
		}
		return allSubSets;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			list.add(i);
		}
		ArrayList<ArrayList<Integer>> subsets = getSubsets(list);
		System.out.println(subsets.toString());	
	}

}
