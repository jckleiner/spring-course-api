//package com.greydev.courseapi;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.Objects;
//import java.util.Set;
//
//public class Test {
//	public static void main(String[] args) throws java.lang.Exception {
//		//		// simple test 
//		//		Set<Good> goods = new HashSet<>();
//		//		Good good1 = new Good("g3", 10);
//		//		goods.add(good1);
//		//		Good good2 = new Good("g2", 10);
//		//		goods.add(good2);
//		//		Good good3 = new Good("g1", 10);
//		//		goods.add(good3);
//		//		Good good4 = new Good("g4", 44);
//		//		goods.add(good4);
//		//
//		//		Good[] sortedGoods = sortGoods(goods);
//		//		if (sortedGoods != null) {
//		//			for (int i = 0; i < sortedGoods.length; i++) {
//		//				System.out.print(sortedGoods[i].getName() + " ");
//		//			}
//		//		}
//		//		else {
//		//			System.out.println("No goods sorted.");
//		//		}
//
//		distinct(new int[] { 7, 1, 3, 5, 3, 3, 1, 1, 5 });
//
//	}
//
//	//	public static int[] distinct(int[] inputArray) {
//	//		// TODO 
//	//		ArrayList<Integer> resultList = new ArrayList<Integer>();
//	//		
//	//		for (int i = 0; i < inputArray.length; i++) {
//	//			resultList.add(inputArray[i]);
//	//		}
//	//		
//	//		ArrayList<Integer> newList = new ArrayList<Integer>();
//	//		for (Integer element : resultList) {
//	//			if (!newList.contains(element)) {
//	//				newList.add(element);
//	//			}
//	//		}
//	//		
//	//		int[] resultArray = new int[newList.size()];
//	//		for (int i = 0; i < newList.size(); i++) {
//	//			resultArray[i] = newList.get(i);
//	//		}
//	//		
//	//		newList.forEach(e -> System.out.println(e));
//	//		
//	//		return resultArray;
//	//	}
//
//	public static int[] distinct(int[] inputArray) {
//		// TODO 
//
//		Integer[] sourceArray = { 0, 1, 2, 3, 4, 5 };
//		List<Integer> targetList = Arrays.asList(sourceArray);
//
//		int[] sourceArray2 = { 0, 1, 2, 3, 4, 5 };
//		List<Integer> targetList2 = Arrays.asList(sourceArray2);
//
//		int[] sourceArray4 = inputArray;
//		List<Integer> targetList4 = Arrays.asList(sourceArray4);
//
//		int[] sourceArray3 = inputArray;
//		List<Integer> targetList3 = Arrays.asList(sourceArray3);
//
//		List<Integer> resultList = Arrays.asList(new Integer[inputArray.length]);
//		ArrayList<Integer> resultList3 = Arrays.asList(new Integer[inputArray.length]);
//
//		for (int i = 0; i < inputArray.length; i++) {
//			resultList.add(inputArray[i]);
//		}
//
//		ArrayList<Integer> newList = new ArrayList<Integer>();
//		for (Integer element : resultList) {
//			if (!newList.contains(element)) {
//				newList.add(element);
//			}
//		}
//
//		int[] resultArray = new int[newList.size()];
//		for (int i = 0; i < newList.size(); i++) {
//			resultArray[i] = newList.get(i);
//		}
//
//		newList.forEach(e -> System.out.println(e));
//
//		return resultArray;
//	}
//
//	public int[] distinct2(int[] inputArray) {
//
//		List<Integer> result = new ArrayList<>();
//
//		for (int i = 0; i < inputArray.length; i++) {
//			for (int j = i; j < inputArray.length; j++) {
//				if (inputArray[i] == inputArray[j]) {
//					break;
//				}
//				System.out.println("*");
//				if (j + 1 == inputArray.length) {
//					result.add(inputArray[i]);
//				}
//			}
//		}
//
//		int[] resultArray = new int[result.size()];
//		for (int i = 0; i < result.size(); i++) {
//			resultArray[i] = result.get(i);
//		}
//		System.out.println("asd");
//		result.forEach(r -> System.out.print(r + " "));
//
//		return resultArray;
//	}
//
//	public static Good[] sortGoods(Set<Good> goods) {
//		// TODO: Write your code here
//
//		Objects.requireNonNull(goods, "goods set can't be null!");
//
//		goods.forEach(g -> {
//			if (g.getWeight() < 0) {
//				throw new RuntimeException("good can't have negative weight!");
//			}
//		});
//
//		List<Good> result = new ArrayList<Good>(goods);
//
//		result.forEach(g -> {
//			System.out.println(g.name + ", " + g.getWeight());
//		});
//
//		Collections.sort(result, (o1, o2) -> {
//
//			if (o1.getWeight() > o2.getWeight()) {
//				return -1;
//			}
//			if (o1.getWeight() == o2.getWeight()) {
//				return o1.getName().compareTo(o2.getName());
//			}
//			else {
//				return 1;
//			}
//		});
//
//		System.out.println("\nresult:");
//
//		Good[] arr = new Good[goods.size()];
//
//		for (int i = 0; i < goods.size(); i++) {
//			arr[i] = result.get(i);
//		}
//
//		result.forEach(g -> {
//			System.out.println(g.name + ", " + g.getWeight());
//		});
//
//		return arr;
//	}
//
//	public static class Good {
//		private final String name;
//		private final int weight;
//
//		Good(String name, int weight) {
//			this.name = name;
//			this.weight = weight;
//		}
//
//		public String getName() {
//			return name;
//		}
//
//		public int getWeight() {
//			return weight;
//		}
//
//	}
//}
