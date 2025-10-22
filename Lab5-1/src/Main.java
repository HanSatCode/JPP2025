public class Main {
    public static void main(String[] args) {
        ColorPoint2 zeroPoint = new ColorPoint2();
        System.out.println(zeroPoint.toString() + "입니다.");

        ColorPoint2 cp = new ColorPoint2(10, 10, "RED");

        cp.set("BLUE");
        cp.set(10, 20);
        System.out.println(cp.toString() + "입니다.");
        ColorPoint2 thresholdPoint = new ColorPoint2(100, 100);

        System.out.println("cp에서 임꼐점까지의 거리는 " + cp.getDistance(thresholdPoint));
    }
}
