class Solution {
    public void sortColors(int[] nums) {
          
	int zero= 0;
	int one=0;
	int two= 0;
	
	for (int i = 0; i < nums.length; i++) {
		switch(nums[i]) {
		case 0:
			zero++;
			break;
			
		case 1:
			one++;
			break;
			
		case 2:
			two++;
			break;
			
		}
		
		
			
	}
	
	int i=0;
	while(zero>0) {
		nums[i]= 0;
		i++;
		zero--;
	}
	
	while(one>0) {
		nums[i]= 1;
		i++;
		one--;
	}
	
	while(two>0) {
		nums[i]= 2;
		i++;
		two--;
	}
    }
}