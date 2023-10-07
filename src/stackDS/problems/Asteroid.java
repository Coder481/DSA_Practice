package stackDS.problems;


import globalClasses.Pair;

import java.util.*;

public class Asteroid {

    public static void main(String[] args) {

        int[] arr = {-2,-1,1,2};
        System.out.println(Arrays.toString(solve(arr)));

        int[][] courses = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(getAdjacencyList(courses));
        int n = 1;
        System.out.println(Arrays.toString(getCourses(courses,n)));

    }


    // Courses problem
    private static int[] getCourses(int[][] prerequisites, int numCourses){
        Map<Integer,Integer> adjMap = adjacencyList(prerequisites);
        PriorityQueue<Pair<Integer,Integer>> minH = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
        for(int key : adjMap.keySet()){
            minH.add(new Pair<>(key,adjMap.get(key)));
        }
        int[] res = new int[numCourses];
        int i = 0;
        while(minH.size() != 0)
            res[i++] = minH.poll().getKey();
        return res;
    }
    private static Map<Integer,Integer> adjacencyList(int[][] courses){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        for(int[] course : courses){

            map.put(course[0],map.getOrDefault(course[0],0)+1);
        }
        return map;
    }

    private static Map<Integer,List<Integer>> getAdjacencyList(int[][] courses){
        Map<Integer,List<Integer>> map = new HashMap<>();
        map.put(0,new ArrayList<>());
        for(int[] course : courses){
            List<Integer> list = map.getOrDefault(course[0],new ArrayList<>());
            list.add(course[1]);
            map.put(course[0],list);
        }
        return map;
    }


    private static int[] solve(int[] asteroids){
        Stack<Integer> stack = new Stack<>();
        for(int asteroid : asteroids){

            boolean canPush = true;
            while(!stack.isEmpty() && (stack.peek()*asteroid)<0){
                if(stack.peek() < 0 && asteroid > 0) break;
                int absAsteroid = Math.abs(asteroid);
                int absTop = Math.abs(stack.peek());

                // If the upcoming asteroid is bigger than the top element of stack
                // then explode the top element
                if(absAsteroid > absTop)
                    stack.pop();

                // If both asteroid have same sizes
                else if(absAsteroid == absTop){
                    stack.pop();
                    canPush = false;
                    break;
                }

                // If the upcoming asteroid is smaller than the top of stack
                else {
                    canPush = false;
                    break;
                }
            }

            if(canPush) stack.push(asteroid);
        }

        int size = stack.size();
        int[] result = new int[size];
        for(int i=size-1; i>=0; i--)
            result[i] = stack.pop();

        return result;
    }

}
