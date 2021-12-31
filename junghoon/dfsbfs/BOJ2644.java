package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2644 {
	
	/* �̼����
	 * 
	 * ����: �츮 ����� ���� Ȥ�� ģô�� ������ ���踦 �̼���� ������ ǥ���ϴ� ��Ư�� ��ȭ�� ������ �ִ�.
	 *      �̷��� �̼��� ������ ���� ������� ���ȴ�. 
	 *      �⺻������ �θ�� �ڽ� ���̸� 1������ �����ϰ� �̷κ��� ����� ���� �̼��� ����Ѵ�. 
	 *      ���� ��� ���� �ƹ���, �ƹ����� �Ҿƹ����� ���� 1������ ���� �Ҿƹ����� 2���� �ǰ�, �ƹ��� ������� �Ҿƹ����� 1��, ���� �ƹ��� ��������� 3���� �ȴ�.
	 *      ���� ����鿡 ���� �θ� �ڽĵ� ���� ���谡 �־����� ��, �־��� �� ����� �̼��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 * 
	 * �Է�: ������� 1, 2, 3, ��, n (1 �� n �� 100)�� ���ӵ� ��ȣ�� ���� ǥ�õȴ�. 
	 *      �Է� ������ ù° �ٿ��� ��ü ����� �� n�� �־�����, ��° �ٿ��� �̼��� ����ؾ� �ϴ� ���� �ٸ� �� ����� ��ȣ�� �־�����. 
	 *      �׸��� ��° �ٿ��� �θ� �ڽĵ� ���� ������ ���� m�� �־�����. 
	 *      ��° �ٺ��ʹ� �θ� �ڽİ��� ���踦 ��Ÿ���� �� ��ȣ x,y�� �� �ٿ� ���´�. 
	 *      �̶� �տ� ������ ��ȣ x�� �ڿ� ������ ���� y�� �θ� ��ȣ�� ��Ÿ����.
	 *      �� ����� �θ�� �ִ� �� �� �־�����.
	 * 
	 * ���: �Է¿��� �䱸�� �� ����� �̼��� ��Ÿ���� ������ ����Ѵ�. 
	 *      � ��쿡�� �� ����� ģô ���谡 ���� ���� �̼��� ����� �� ���� ���� �ִ�. 
	 *      �̶����� -1�� ����ؾ� �Ѵ�.
	 * 
	 *     
	 * */
	
	static List<Integer>[] relation;
	static boolean[] checked;
	static int res = -1;
	
	static void dfs(int start, int end, int cnt) {
		if(start == end) {
			res = cnt;
			return; 
		}
		
		checked[start] = true;
		for(int i=0; i<relation[start].size(); i++) { 
			int next = relation[start].get(i);
			if(!checked[next]) {
				dfs(next, end, cnt+1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		relation = new ArrayList[n+1];
		checked = new boolean[n+1];
		for(int i=1; i<n+1; i++) {
			relation[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int l = Integer.parseInt(br.readLine());
		
		for(int i=0; i<l; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			relation[p].add(c);
			relation[c].add(p);
		}
		
		dfs(x,y, 0);
		System.out.println(res);
	}
	
	

}
