class Solution {
    Map<Integer, List<Integer>> preMap = new HashMap<>();
    Set<Integer> path = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++){
            preMap.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites){
            // [a,b] b is a prereq to a so add to a's list of prereqs
            preMap.get(prereq[0]).add(prereq[1]);
        }
        for (int i=0; i < numCourses; i++){
            if(!dfs(i)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int cnum){
        if (path.contains(cnum)){
            return false;
        }
        if (preMap.get(cnum).isEmpty()){
            return true;
        }
        path.add(cnum);
        for (int pre : preMap.get(cnum)){
            //for every course in the prereqs do dfs
            if (!dfs(pre)){
                return false;
            }
        }
        path.remove(cnum);
        preMap.put(cnum, new ArrayList<>());
        return true;
    }
}
