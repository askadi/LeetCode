public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null)
            return true;
        if(numCourses == 0 || prerequisites.length == 0)
            return true;
        int[] coursePrereq = new int[numCourses];
        
        for(int i=0;i<prerequisites.length;i++){
            coursePrereq[prerequisites[i][0]]++;
        }
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++){
            if(coursePrereq[i] == 0)
                queue.add(i);
        }
        int noPrereq = queue.size();
        
        while(!queue.isEmpty()){
            int course = queue.remove();
            for(int i=0;i<prerequisites.length;i++){
                if(prerequisites[i][1]==course){
                    coursePrereq[prerequisites[i][0]]--;
                    if(coursePrereq[prerequisites[i][0]] == 0){
                        noPrereq++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return noPrereq == numCourses;
    }
}
