package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {

	/* �̷� Ž��
	 * 
	 * ����: N��Mũ���� �迭�� ǥ���Ǵ� �̷ΰ� �ִ�.
	 *      1	0	1	1	1	1
	 *      1	0	1	0	1	0
	 *      1	0	1	0	1	1
	 *      1	1	1	0	1	1
	 *      �̷ο��� 1�� �̵��� �� �ִ� ĭ�� ��Ÿ����, 0�� �̵��� �� ���� ĭ�� ��Ÿ����. 
	 *      �̷��� �̷ΰ� �־����� ��, (1, 1)���� ����Ͽ� (N, M)�� ��ġ�� �̵��� �� ������ �ϴ� �ּ��� ĭ ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. 
	 *      �� ĭ���� �ٸ� ĭ���� �̵��� ��, ���� ������ ĭ���θ� �̵��� �� �ִ�.
	 *      ���� �������� 15ĭ�� ������ (N, M)�� ��ġ�� �̵��� �� �ִ�. 
	 *      ĭ�� �� ������ ���� ��ġ�� ���� ��ġ�� �����Ѵ�.
	 * 
	 * �Է�: ù° �ٿ� �� ���� N, M(2 �� N, M �� 100)�� �־�����. ���� N���� �ٿ��� M���� ������ �̷ΰ� �־�����. ������ ������ �پ �Է����� �־�����.
	 * 
	 * ���: ù° �ٿ� ������ �ϴ� �ּ��� ĭ ���� ����Ѵ�. �׻� ������ġ�� �̵��� �� �ִ� ��츸 �Է����� �־�����.
	 * 
	 * Ǯ��: �ִ� �Ÿ��� ���ϴ� ������ BFS �ʿ��� visited���� 0�ΰ�� �湮���� ��
	 *     
	 * */

	static int[][] map;
	static int[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int n,m;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		bfs(0,0);
		System.out.println(visited[n-1][m-1]);
	}

	static void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		visited[x][y] = 1;
		queue.add(new Node(x, y));
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (visited[nx][ny] == 0 && map[nx][ny] == 1) {
						queue.add(new Node(nx, ny));
						visited[nx][ny] = visited[node.x][node.y] + 1;
					}
				}
			}
		}
	}
}

class Node {
	int x;
	int y;
	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}	

}
