import java.util.*;
public class Graph {
    static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // public static void bfs(ArrayList<Edge>[] graphs){
    //     Queue<Integer> q = new LinkedList<>();
    //     boolean vis[] = new boolean[graphs.length];
    //     q.add(0);

    //     while(!q.isEmpty()){
    //         int curr = q.remove();

    //         if((!vis[curr])){
    //             System.out.println(curr);
    //             vis[curr]= true;
    //             for(int i =0; i< graphs[curr].size();i++){
    //                 Edge e = graphs[curr].get(i);
    //                 q.add(e.dest);
    //             }
    //         }
    //     }
    // }

    // public static void dfs(ArrayList<Edge>[] graphs, int curr, boolean[] vist){
    //     System.out.print(curr + " ");
    //     vist[curr] = true;

    //     for(int i=0;i<graphs[curr].size();i++){
    //         Edge e= graphs[curr].get(i);
    //         if(!vist[e.dest]){
    //             dfs(graphs, e.dest, vist);
    //         }
    //     }
    // }

    public static void createGraph(ArrayList<Edge> graphs[], int v){

        for(int i = 0; i <v ;i++){
            graphs[i] = new  ArrayList<>();
        }

        //0- vertex
        graphs[0].add(new Edge(0,1,5));

        graphs[1].add(new Edge(1,0,5));
        graphs[1].add(new Edge(1,2,3));
        graphs[1].add(new Edge(1,3,2));

        graphs[2].add(new Edge(2,2,1));
        graphs[2].add(new Edge(2,3,1));
        graphs[2].add(new Edge(2,4,4));

        graphs[3].add(new Edge(3,1,3));
        graphs[3].add(new Edge(3,2,1));

        graphs[4].add(new Edge(4,2,2));

        //2nd
        // for(int j =0; j<graphs[2].size();j++){
        //     Edge e = graphs[2].get(j);
        //     System.out.println(e.dest);
        // }
    }

    public static boolean hasPath(ArrayList<Edge>[] graphs, int src, int dest, boolean[] vis){
        if(src == dest){
            return true;
        }
        vis[src] = true;
        for(int i =0; i<graphs[src].size();i++){
            Edge e = graphs[src].get(i);
            if(!vis[e.dest] && hasPath(graphs, e.dest, dest, vis)){
                return true;
            }
        }
        return false;
    }

    //Component in graph

    // public static void bfs(ArrayList<Edge>[] graphs){
    //     boolean vis[] = new boolean[graphs.length];
    //     for(int i =0;i<graphs.length;i++){
    //         if(!vis[i]){
    //             bfsUtill(graphs, vis);
    //         }
    //     }
    // }

    // public static void bfsUtill(ArrayList<Edge>[] graphs, boolean[] vis){ //copy past or original bfs starting
    //     Queue<Integer> q = new LinkedList<>();
    //     boolean vis[] = new boolean[graphs.length];
    //     q.add(0);

    //     while(!q.isEmpty()){
    //         int curr = q.remove();

    //         if((!vis[curr])){
    //             System.out.println(curr);
    //             vis[curr]= true;
    //             for(int i =0; i< graphs[curr].size();i++){
    //                 Edge e = graphs[curr].get(i);
    //                 q.add(e.dest);
    //             }
    //         }
    //     }
    // }

    public static void dfs(ArrayList<Edge>[] graphs){
        boolean vis[] = new boolean[graphs.length];

        for(int i =0;i<graphs.length;i++){
            dfsUtill(graphs, i, vis);
        }
    }

    public static void dfsUtill(ArrayList<Edge>[] graphs, int curr, boolean[] vist){
        System.out.print(curr + " ");
        vist[curr] = true;

        for(int i=0;i<graphs[curr].size();i++){
            Edge e= graphs[curr].get(i);
            if(!vist[e.dest]){
                dfsUtill(graphs, e.dest, vist);
            }
        }
    } 

    // public static boolean detectCycleUtil(ArrayList<Edge> graphs, boolean vis[], int curr, int par){
    //     vis[curr] = true;

    //     for(int i=0;i<graphs[curr].size();i++){//calling the neaighboure
    //         Edge e= graphs[curr].get(i);
    //         //case3
    //         if(!vis[e.dest]){
    //             if(detectCycleUtil(graphs, vis, e.dest, curr)){
    //                 return true;
    //             }
    //         }
    //         //case 1
    //         else if(vis[e.dest] && e.dest != par){
    //             return true;
    //         }
    //         //case 2 
    //     }
    //     return false;
    // }

    // public static boolean detectCycle(ArrayList<Edge> graphs){
    //     boolean vis[]= new boolean[graphs.length];//For corner cases ::- component of graph
    //     for(int i =0; i <graphs.length;i++){
    //         if(!vis[i]){
    //             if(detectCycleUtil(graphs, vis, i, -1)){
    //                 return true;
    //             }
    //             //cycle exit on of the part
    //         }
    //     }
    // }

    // public static boolean isBipartite(ArrayList<Edge> graphs[]){
    //     int col[] = new int[graphs.length];
    //     for(int i=0;i<col.length;i++){
    //         col[i] = -1;// no color
    //     }

    //     Queue<Integer> q = new LinkedList<>();

    //     for(int i = 0; i< graphs.length;i++){
    //         if(col[i] == -1){
    //             q.add(i);
    //             col[i] = 0; //yellow
    //             while(!q.isEmpty()){
    //                 int curr = q.remove();
    //                 for(int j =0;j<graphs[curr].size();j++){
    //                     Edge e = graphs[curr].get(j);

    //                     if(col[e.dest] == -1){
    //                         int nextCol = col[curr] == 0 ? 1 : 0; 
    //                         col[e.dest] = nextCol;
    //                         q.add(e.dest);
    //                     }
    //                     else if(col[e.dest] == col[curr]){
    //                         return false;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    // }

    // public static boolean isCycle(ArrayList<Edge>[] graphs){
    //     boolean vis[] = new boolean[graphs.length];
    //     boolean stack[] = new boolean[graphs.length];

    //     for(int i =0; i<graphs.length;i++){
    //         if(!vis[i]){
    //             if(isCycleUtil(graphs, i, vis, stack)){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    // public static boolean isCycleUtil(ArrayList<Edge> graphs,int curr, boolean vis[], boolean stack[]){
    //     vis[curr] = true;
    //     stack[curr] = true;

    //     for(int i = 0; i<graphs[curr].size();i++){
    //         Edge e = graphs[curr].get(i);
    //         if(stack[e.dest]){
    //             return true; //cycle
    //         }
    //         if(!vis[e.dest] && isCycleUtil(graphs, e.dest, vis, stack)){
    //             return true;
    //         }
    //     }
    //     stack[curr] = false;
    //     return false;
    // }
    public static void main(String[] args) {

        int v =5;
        ArrayList<Edge>[] graphs = new ArrayList[v];

        // Edge e = new Edge(0, 0, 0);
        // int v = 7;
        // ArrayList<Edge> graph[] = new ArrayList<>();
        createGraph(graphs, v);
        // bfs(graphs);

        // dfs( graphs, 0,new boolean[v] );

        //HashPath
        //System.out.println(hasPath(graphs, 0, 4, new boolean[v]));
        //dfs(graphs);

        //Cycle Detective
        //System.out.print(detectCycle(graphs));

        //Is bipartite
        //System.out.println(isBipartite(graphs));

        //detected cycle
        System.out.println(isCycle(graphs));
    }
}