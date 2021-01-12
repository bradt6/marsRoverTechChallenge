public enum RoverCommands {
    L, R, M;

    public static RoverCommands getCommand(char Command) {
        switch (Command) {
            case 'L':
                return L;
            case 'R':
                return R;
            case 'M':
                return M;
            default:
                throw new IllegalStateException("Not a valid direction");
        }
    }
}

