import java.util.ArrayList;

public class QuickUnion implements UnionFind {
	
	protected int id[];
	protected int count;
	
	public QuickUnion(int n) {
		id = new int[n];
		count = n;
		
		initialize();
	}
	
	private void initialize() {
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}

	@Override
	public void union(int p, int q) {
		int pRoot = root(p);
		int qRoot = root(q);
		
		if(pRoot == qRoot)
			return;
		
		id[pRoot] = qRoot;
		
		count--;
		
	}

	@Override
	public boolean isConnected(int p, int q) {
		int pRoot = root(p);
		int qRoot = root(q);
		return pRoot == qRoot;
	}

	@Override
	public int find(int p) {
		return root(p);
	}

	@Override
	public int getConnectedComponentCount() {
		return count;
	}
	
	protected int root(int p) {
		// create an array that stores the indices along the way to the root
		ArrayList<Integer> indices_visited = new ArrayList<>();
		while(id[p] != p) {
			p = id[p];
//			indices_visited.add(p);
		}
		// point the nodes visited directly at the root index. This is how path
		// compression is being implemented.
//		for(int i=0; i<indices_visited.size(); i++) {
//			id[i] = p;
//		}
		return p;
	}
}
