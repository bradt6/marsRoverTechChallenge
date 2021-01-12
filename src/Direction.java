public enum Direction {
    N, E, S, W;


    public static Direction getDirection(String sign) {
        switch (sign) {
            case "N":
                return N;
            case "E":
                return E;
            case "S":
                return S;
            case "W":
                return W;
            default:
                throw new IllegalStateException("Not a valid direction");
        }
    }
}
