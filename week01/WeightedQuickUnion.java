public class WeightedQuickUnion {
  private int[] id;

  public WeightedQuickUnion(int n) {
    id = new int[n];
    sz = new int[n];

    for (int i = 0; i < id.length; i++) {
      id[i] = i;
      sz[i] = 1;
    }
  }

  private int root(int p) {
    while (p != id[p]) {
      // path compression
      id[p] = id[id[p]];
      p = id[p];
    }

    return p;
  }

  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  public void union(int p, int q) {
    int rp = root(p);
    int rq = root(q);
    
    if (rp == rq) return;
    if (sz[rp] < sz[rq]) {
      id[rp] = rq;
      sz[rq] += sz[rp];
    } else {
      id[rq] = rp;
      sz[rp] += sz[rq];
    }
  }
}
