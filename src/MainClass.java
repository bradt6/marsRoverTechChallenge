
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] positions = scanner.nextLine().split(" ");
        Plateau plateau = new Plateau(Integer.parseInt(positions[0]),Integer.parseInt(positions[1]));

        ArrayList<Rover> rovers = new ArrayList<>();
        while (scanner.hasNext()) {
            String[] roverPosition = scanner.nextLine().split(" ");
            int xPos = Integer.parseInt(roverPosition[0]);
            int yPos = Integer.parseInt(roverPosition[1]);
            Direction direction = Direction.getDirection(roverPosition[2]);
            Rover rover = new Rover(new Location(xPos, yPos), plateau, direction);
            rovers.add(rover);
            rover.processMove(scanner.nextLine());
        }
        rovers.forEach(r -> System.out.println(r.resultoutput()));
    }
}
