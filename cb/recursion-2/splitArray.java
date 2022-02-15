public boolean splitArray(int[] nums) {
  int totalSum = 0;
  for(int i = 0; i < nums.length; i++) {
    totalSum += nums[i];
  }
  if (totalSum % 2 == 0){
    return groupSum(0, nums, totalSum / 2);
  }
  else{
    return false;
  }
}

public boolean groupSum(int start, int[] nums, int target) {
  if (start >= nums.length) {
    if (target == 0) {
      return true;
    }
    else {
      return false;
    }
  }
  else {
    if (groupSum(start + 1, nums, target - nums[start])) {
      return true;
    }
    else if (groupSum(start + 1, nums, target)) {
      return true;
    }
    else {
      return false;
    }
  }
}
