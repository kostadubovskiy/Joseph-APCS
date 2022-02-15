public int count8(int n) {
    if (n == 8) {
    return 1;
  } else if (n < 10) {
    return 0;
  } else {
    if (n / 10 % 10 == 8) {
      return 2 * count8(n % 10) + count8(n / 10);
    } else {
      return count8(n % 10) + count8(n / 10);
    }
  }
}
