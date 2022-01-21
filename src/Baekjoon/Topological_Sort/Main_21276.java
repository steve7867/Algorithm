/**
 * 계보 복원가 호석
 * https://www.acmicpc.net/problem/21276
 */
package Baekjoon.Topological_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main_21276 {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> nameToNum = new TreeMap<>();
        Map<Integer, String> numToName = new HashMap<>();
        List<Integer>[] adjList = input(nameToNum, numToName);
 
        int[] inDegree = makeInDegreeTable(adjList);
 
        StringBuilder sb = new StringBuilder();
 
        List<Integer> rootList = getRootList(inDegree);
        List<String> nameList = getRootNameList(rootList, numToName);
        sb.append(rootList.size()).append('\n');
        for (String name : nameList)
            sb.append(name).append(' ');
 
        sb.append('\n');
 
        Map<String, Set<String>> childMap = topologicalSort(numToName, adjList, rootList, inDegree);
 
        buildAnswer(childMap, sb);
        System.out.println(sb);
    }
 
    private static List<String> getRootNameList(List<Integer> rootList, Map<Integer, String> numToName) {
        List<String> nameList = new ArrayList<>();
        for (int i : rootList)
            nameList.add(numToName.get(i));
 
        Collections.sort(nameList);
        return nameList;
    }
 
    private static void buildAnswer(Map<String, Set<String>> childMap, StringBuilder sb) {
        for (String parent : childMap.keySet()) {
            sb.append(parent).append(' ');
 
            Set<String> childList = childMap.get(parent);
            sb.append(childList.size()).append(' ');
 
            for (String child : childList)
                sb.append(child).append(' ');
 
            sb.append('\n');
        }
    }
 
    private static Map<String, Set<String>> topologicalSort(Map<Integer, String> numToName,
                                                            List<Integer>[] adjList,
                                                            List<Integer> rootList,
                                                            int[] inDegree) {
        Map<String, Set<String>> childMap = new TreeMap<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i : rootList)
            q.offer(i);
 
        while (!q.isEmpty()) {
            int pNum = q.poll();
            String parent = numToName.get(pNum);
 
            childMap.put(parent, new TreeSet<>());
 
            if (adjList[pNum].size() == 0)
                continue;
 
            for (int cNum : adjList[pNum]) {
                inDegree[cNum]--;
 
                if (inDegree[cNum] == 0) {
                    q.offer(cNum);
                    String child = numToName.get(cNum);
                    childMap.get(parent).add(child);
                }
            }
 
        }
 
        return childMap;
    }
 
    private static List<Integer> getRootList(int[] inDegree) {
        int n = inDegree.length;
        List<Integer> rootList = new ArrayList<>();
 
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0)
                rootList.add(i);
        }
 
        return rootList;
    }
 
    private static int[] makeInDegreeTable(List<Integer>[] adjList) {
        int n = adjList.length;
        int[] inDegree = new int[n];
 
        for (List<Integer> list : adjList)
            for (int i : list)
                inDegree[i]++;
 
        return inDegree;
    }
 
    private static List<Integer>[] input(Map<String, Integer> nameToNum, Map<Integer, String> numToName) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int serialID = 0;
        for (int i = 0; i < n; i++) {
            String name = st.nextToken();
            nameToNum.put(name, serialID);
            numToName.put(serialID++, name);
        }
 
        List<Integer>[] adjList = new List[n];
        for (int i = 0; i < n; i++)
            adjList[i] = new ArrayList<>();
 
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String descendant = st.nextToken();
            String ancestor = st.nextToken();
 
            int dNum = nameToNum.get(descendant);
            int aNum = nameToNum.get(ancestor);
 
            adjList[aNum].add(dNum);
        }
 
        return adjList;
    }
}
