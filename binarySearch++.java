package test;

public class test {
	public static int binarySearch(int[] nums, int target) {
		int left = 0, right = nums.length -1, mid;
		while(left <= right) {
			mid = ((right - left) >> 1) + left;
			if(target == nums[mid]) {
				return mid;
			}
			else if(target < nums[mid]) {
				right = mid -1;
			}
			else {
				left = mid + 1;
			}
		}
		return -1;
	}
	public static int leftboundSearch(int[] nums, int target) {
		if(nums.length == 0) return -1;
		int left = 0;
		int right = nums.length; // 区别点1
		int mid;
		while(left < right) {	// 区别点2
			mid = ((right - left) >> 1) + left;
			if(nums[mid] == target) {
				right = mid;				// 区别点3
			}
			else if(nums[mid] < target) {
				left = mid + 1;				// 区别点4
			}
			else if(nums[mid] > target) {
				right = mid;				// 区别点5
			}
		}					
		if(left == nums.length) return -1;	// 区别点6
		return nums[left] == target ? left: -1;
 		
	}
	public static int UNIONleftboundSearch(int[] nums, int target) {
		if(nums.length == 0) return -1;
		int left = 0;
		int right = nums.length - 1; // 区别点1
		int mid;
		while(left <= right) {	// 区别点2
			mid = ((right - left) >> 1) + left;
			if(nums[mid] == target) {
				right = mid - 1;				// 区别点3
			}
			else if(nums[mid] < target) {
				left = mid + 1;				// 区别点4
			}
			else if(nums[mid] > target) {
				right = mid - 1;				// 区别点5
			}
		}					
		if(left == nums.length || nums[left] != target) return -1;
		return left;
		
	}
	public static int rightboundSearch(int[] nums, int target) {
		if(nums.length == 0) return -1;
		int left = 0;
		int right = nums.length;
		int mid;
		while(left < right) {
			mid = ((right - left) >> 1) + left;
			if(nums[mid] == target) {
				left = mid + 1;
			}
			else if(nums[mid] < target) {
				left = mid + 1;
			}
			else if(nums[mid] > target) {
				right = mid;
			}
		}
		if(left == 0) return -1;
		return nums[left -1] == target ? left - 1: -1;
	}
	public static int UNIONrightboundSearch(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int mid;
		while(left <= right) {
			mid = ((right - left) >> 1) + left;
			if(nums[mid] == target) {
				left = mid + 1;
			}
			else if(nums[mid] < target) {
				left = mid + 1;
			}
			else if(nums[mid] > target) {
				right = mid - 1;
			}
		}
		if(left == 0) return -1;
		return nums[left -1] == target ? left - 1: -1;
	}
	public static void main(String args[]) {
		int nums[] = {1,2,2,2,2,3,5,7,9,12};
		int target = 2;							// special case : 0/13(下溢、上溢)
		int index = binarySearch(nums, target);
		int leftbound = leftboundSearch(nums, target);
		int leftbound2 = UNIONleftboundSearch(nums, target);
		int rightbound 	= rightboundSearch(nums, target);
		int rightbound2 = UNIONrightboundSearch(nums, target);
		System.out.println("index: "+ index);
		System.out.println("leftbound: "+ leftbound);
		System.out.println("leftbound: "+ leftbound2);
		System.out.println("rightbound: "+ rightbound);
		System.out.println("rightbound: "+ rightbound2);
	}
}
