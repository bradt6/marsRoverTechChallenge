public class Rover implements Vehicle {

    private Plateau plateau;
    private Direction facing;
    private Location location;

    public Rover (Location location, Plateau plateau, Direction facing) {
        this.location = location;
        this.plateau = plateau;
        this.facing = facing;
    }

    public void processMove(String commands) {
//        commands.chars().mapToObj(command -> RoverCommands.getCommand(String.valueOf(command))).forEach((this::processMove));
        for (char c : commands.toCharArray()) {
            RoverCommands command = RoverCommands.getCommand(c);
            processMove(command);
        }
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String resultoutput() {
        return getLocation().toString() + " " + facing;
    }

    private void processMove(RoverCommands command) throws IllegalStateException {
        switch(command) {
            case L:
                turnLeft();
                break;
            case R:
                turnRight();
                break;
            case M:
                move();
                break;
            default:
                throw new IllegalStateException("This is an invalid command");
        }
    }

    @Override
    public void move() throws IllegalStateException {

        switch (facing){
            case N:
                if(plateau.isValidMove(new Location(location.getX() + 1, location.getY())))
                setLocation(new Location(location.getX(), location.getY() + 1));
                break;
            case E:
                if(plateau.isValidMove(new Location(location.getX(), location.getY() + 1)))
                setLocation(new Location(location.getX() + 1, location.getY()));
                break;
            case S:
                if(plateau.isValidMove(new Location(location.getX() -1, location.getY())))
                setLocation(new Location(location.getX(), location.getY() -1));
                break;
            case W:
                if(plateau.isValidMove(new Location(location.getX(), location.getY() - 1)))
                setLocation(new Location(location.getX() -1, location.getY()));
                break;
            default:
                throw new IllegalStateException("This is not a valid move");
        }
    }


    public Location getLocation() {
        return location;
    }


    public Direction getFacing() {
        return facing;
    }

    @Override
    public void turnLeft() throws IllegalStateException {
        switch (getFacing()) {
            case N:
                setFacing(Direction.W);
                break;
            case E:
                setFacing(Direction.N);
                break;
            case S:
                setFacing(Direction.E);
                break;
            case W:
                setFacing(Direction.S);
                break;
            default:
                throw new IllegalStateException("Invalid Move");
        }
    }

    public void setFacing(Direction facing) {
        this.facing = facing;
    }



    @Override
    public void turnRight() throws IllegalStateException{
        switch (getFacing()) {
            case N:
                setFacing(Direction.E);
                break;
            case E:
                setFacing(Direction.S);
                break;
            case S:
                setFacing(Direction.W);
                break;
            case W:
                setFacing(Direction.N);
                break;
            default:
                throw new IllegalStateException("Invalid Move");
        }
    }

}
