1class Fancy {
2
3    private static final long MOD = 1_000_000_007;
4    private List<Long> arr;
5    private long mul;
6    private long add;
7
8    public Fancy() {
9        arr = new ArrayList<>();
10        mul = 1;
11        add = 0;
12    }
13
14    private long modInverse(long x) {
15        return pow(x, MOD - 2);
16    }
17
18    private long pow(long base, long exp) {
19        long result = 1;
20        base %= MOD;
21
22        while (exp > 0) {
23            if ((exp & 1) == 1)
24                result = (result * base) % MOD;
25
26            base = (base * base) % MOD;
27            exp >>= 1;
28        }
29
30        return result;
31    }
32
33    public void append(int val) {
34        long normalized = (val - add + MOD) % MOD;
35        normalized = (normalized * modInverse(mul)) % MOD;
36        arr.add(normalized);
37    }
38
39    public void addAll(int inc) {
40        add = (add + inc) % MOD;
41    }
42
43    public void multAll(int m) {
44        mul = (mul * m) % MOD;
45        add = (add * m) % MOD;
46    }
47
48    public int getIndex(int idx) {
49        if (idx >= arr.size()) return -1;
50
51        long value = (arr.get(idx) * mul + add) % MOD;
52        return (int) value;
53    }
54}