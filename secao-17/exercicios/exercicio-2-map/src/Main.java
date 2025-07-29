import entities.Vote;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Vote> votes = new LinkedHashMap<>();

        System.out.print("Enter a file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                int count = Integer.parseInt(fields[1]);

                if (votes.containsKey(name)) {
                    Vote existingVote = votes.get(name);
                    existingVote.setVotes(existingVote.getVotes() + count);
                } else {
                    votes.put(name, new Vote(name, count));
                }

                line = br.readLine();
            }

            for (Vote vote : votes.values()) {
                System.out.println(vote.getName() + ": " + vote.getVotes());
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
