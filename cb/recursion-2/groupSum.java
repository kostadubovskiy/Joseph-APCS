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
