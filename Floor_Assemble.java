package com.greatlearning.labassgn3;

import java.util.*;

public class Floor_Assemble {
	@SuppressWarnings("resource")
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		// take the input for number of floor
		Stack<Integer> stack = new Stack<Integer>();
		System.out.println("Enter the total no of floors in the building:");
		int no_of_floors = sc.nextInt();

		if (no_of_floors <= 0) {

			System.out.println("Invalid Number");
			System.out.println("Enter the total no of floors in the building:");
			no_of_floors = sc.nextInt();
		}

		Integer arr_floor_size[];
		Integer temp_floor_size[];
		Integer temp_floor_size2[];

		int largest_floor_size = no_of_floors;
		arr_floor_size = new Integer[no_of_floors + 1];
		temp_floor_size = new Integer[no_of_floors + 1];
		temp_floor_size2 = new Integer[no_of_floors + 1];

		int i, j, k, l, lv_pop;

		for (i = 1; i <= no_of_floors; i++) {
			stack.push(i);
			System.out.println("Enter the floor size given on day : " + i);
			arr_floor_size[i] = sc.nextInt();
			if (arr_floor_size[i] <= 0) {
				System.out.println("Invalid Number");
				System.out.println("Enter the floor size given on day : " + i);
				arr_floor_size[i] = sc.nextInt();
			}

		}

		j = 0;
		lv_pop = 0;
		for (i = 1; i <= no_of_floors; i++) {

			System.out.println("Day:" + i);

			if (arr_floor_size[i] == largest_floor_size) {
				Integer temp_floor = (Integer) stack.pop();
				System.out.print(temp_floor + " ");
				largest_floor_size = largest_floor_size - 1;
				l = 0;
				// sort and compare
				Arrays.sort(temp_floor_size,
						Collections.reverseOrder(Comparator.nullsFirst(Comparator.naturalOrder())));
				for (k = 0; k < j; k++) {

					if (temp_floor_size[k] == largest_floor_size) {
						temp_floor = (Integer) stack.pop();
						System.out.print(temp_floor + " ");
						lv_pop++;
						largest_floor_size = largest_floor_size - 1;
					} else {
						if (temp_floor_size[k] != 0) {
							temp_floor_size2[l] = temp_floor_size[k];
							l++;
						}
					}
					if (largest_floor_size == 0) {
						break;
					}
				}
				System.out.println();

				temp_floor_size = temp_floor_size2;
				temp_floor_size2 = new Integer[no_of_floors];

				j = j - lv_pop;
				lv_pop = 0;

			}

			else {
				if (arr_floor_size[i] != 0)

				{
					temp_floor_size[j] = arr_floor_size[i];
					j = j + 1;
				}
				System.out.println();
			}

		}
	}
}