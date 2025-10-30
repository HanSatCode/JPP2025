import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class StepApp {
    HashMap<String, ArrayList<Integer>> map =  new HashMap<String, ArrayList<Integer>>();
    Scanner scanner = new Scanner(System.in);
    private void read() {
        while(true){
            System.out.print("이름과 걸음 수 >> ");
            String line = scanner.nextLine();
            if (line.equals("그만")) break;
            String[] tokens = line.split(" ");
            String name = tokens[0];
            var list = map.get(name);
            if (list == null){
                list = new ArrayList<Integer>();
                map.put(name, list);
            }
            for (int i = 1; i < tokens.length; i++){
                list.add(Integer.parseInt(tokens[i]));
            }
        }
    }

    private void findBest() {
        var keys = map.keySet();
        var it = keys.iterator();
        int bestStep = 0; String bestUser = null;
        while (it.hasNext()) {
            String name = it.next();
            var list = map.get(name);
            int sum = 0;
            for(int walk : list) {
                sum += walk;
            }
            if (sum > bestStep) {
                bestStep = sum;
                bestUser = name;
            }
        }
        System.out.println("걸음 수가 가장 많은 사람은 " + bestUser + " " + bestStep + "보");
    }

    private void search() {
        while(true){
            System.out.print("검색할 이름 >> ");
            String name = scanner.next();
            if (name.equals("그만")) break;
            var list = map.get(name);
            if(list == null){
                System.out.println(name +"은 없는 학생입니다.");
                continue;
            }
            int sum = 0;
            for(int walk : list) {
                System.out.print(walk + " ");
                sum += walk;
            }
            System.out.println("평균 " + (sum / list.size()));
        }
    }

    public void run() {
        read();
        findBest();
        search();
    }
}
