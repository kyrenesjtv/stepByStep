package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.bean;

import java.util.LinkedList;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2021/1/19 16:42
 */
public class Graph {
    private int v;
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for(int i = 0 ; i <v ; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s , int t){//s 先于t  s -> t
        adj[s].add(t);
    }

    /**
     * 拓扑排序之Kahn算法
     */
    public void topoSortByKahn(){
        //统计每个节点的入度
        int[] inDegree = new int[v];

        for(int i = 0 ; i < v ;i++){
            for(int j = 0 ; i < adj[i].size();j++){
                // adj[i].size()  adj[i]的出度
                int w = adj[i].get(j);
                //节点w的入度
                inDegree[w]++;
            }
        }

        //如果没有入度的， 那么就是出度。它为首个打印点
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < v; i++){
            if(inDegree[i] == 0 ){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            Integer i = queue.remove();
            System.out.println("->" + i);
            for(int j = 0 ; i <adj[i].size(); j++){
                int k = adj[i].get(j);
                //入度减-
                inDegree[k]--;
                //入度为0，加入打印队列
                if(inDegree[k] == 0 ){
                    queue.add(k);
                }
            }
        }


    }

    /**
     * 拓扑排序之dfs算法
     */
    public void topoSortByDFS(){
        //先构建逆邻接表, s->t表示。s依赖t,t先执行
        LinkedList<Integer> inverseAdj[] = new LinkedList[v];
        for(int i = 0 ; i <v ; i++){
            inverseAdj[i] = new LinkedList<>();
        }

        //通过邻接表生成逆邻接表
        for(int i = 0 ; i < v ; i++){
            for(int j = 0 ; j <adj[i].size() ; j++){
                // i -> w
                Integer w = adj[i].get(j);
                // w -> i
                inverseAdj[w].add(i);
            }
        }

        boolean[] visited = new boolean[v];
        for(int i = 0 ; i<v ; i++){
            if(visited[i] == false){
                visited[i] = true;
                dfs(i,inverseAdj,visited);
            }
        }

    }

    private void dfs(int index, LinkedList<Integer>[] inverseAdj, boolean[] visited) {
        for(int i = 0 ; i < inverseAdj[index].size() ; i++){
            int w = inverseAdj[index].get(i);
            if(visited[w] == true){
                continue;
            }
            visited[w] = true;
            dfs(w,inverseAdj,visited);
        }
        System.out.println("->"+index);
    }


}
