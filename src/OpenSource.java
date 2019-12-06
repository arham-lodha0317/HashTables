import java.io.File;
import java.util.*;

public class OpenSource {

    public static void main(String[] args) throws Exception{

        Scanner file = new Scanner(new File("input.txt"));
        HashSet<String> seen = new HashSet<>();
        HashMap<String, Integer> count = new HashMap<>();
        ArrayList<String>  projects = new ArrayList<>();

        String projectName = "";

        while(file.hasNext()){
            String line = file.nextLine();

            if(!line.equals("0") || !line.equals("1")){

                if(line.equals(line.toUpperCase())){
                    projectName = line;
                    projects.add(projectName);
                }

                if(line.equals(line.toLowerCase())){
                    if(!seen.contains(line)){
                        seen.add(line);
                        if(count.containsKey(projectName)){
                            int num = count.get(projectName);
                            num++;
                            count.remove(projectName);
                            count.put(projectName, num);
                        }
                        else {
                            count.put(projectName, 1);
                        }
                    }
                }

            }


        }

        for (String s: projects) {
            System.out.println(s + " " + count.get(s));
        }

    }


}
