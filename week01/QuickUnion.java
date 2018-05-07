public class QuickUnion {
  private int[] id;

  public QuickUnion(int n) {
    id = new int[n];

    for (int i = 0; i < id.length; i++)
      id[i] = i;
  }

  private int root(int p) {
    while (p != id[p])
      p = id[p];

    return p;
  }

  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  public void union(int p, int q) {
    int rp = root(p);
    int rq = root(q);
    id[rp] = rq;
  }
}
