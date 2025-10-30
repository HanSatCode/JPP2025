public class Main {
    public static void main(String[] args) {
        SumPositives sp = new SumPositives();
        sp.read();
        sp.changeToZero();
        System.out.print("음수를 0으로 바꾸면 ");
        sp.showAll();
        System.out.println("양수들의 합은 " + sp.add());
    }
}
