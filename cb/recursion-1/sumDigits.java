public int sumDigits(int n) {
  if (n == 0) {
    return n;
  } else {
    return n % 10 + sumDigits(n / 10);
  }
}
