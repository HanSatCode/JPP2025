public class Main {
    public static void main(String[] args) {
        Memo a = new Memo("유송연", "10:10", "자바 과제 있음");
        Memo b = new Memo("박채원", "  10:15", "시카고로 어학 연수가요!");
        Memo c = new Memo("김경미", "11:30", "사랑하는 사람이 생겼어요.");

        a.show();
        if(a.isSameName(b)) System.out.println("동일한 사람입니다.");
        else System.out.println("다른 사람입니다.");
        System.out.println(c.getName() + "가 작성한 메모의 길이는 " + c.length());
    }
}
