package Other;

import java.util.Arrays;

public class Friends {

    public static void main(String[] args) {
        Friend [] friends = new Friend[3];
        friends [0] = new Friend("Вася", 11, true, 12);
        friends [1] = new Friend("Петя", 13, true, 34);
        friends [2] = new Friend("Коля", 14, false, 23);

        System.out.println(Arrays.toString(friends));

    }

    static class Friend {
        private String name;
        private int age;
        private float hoursSpentTogetherLastWeek;
        private boolean isFriendFromSchool;

        public Friend(String name, int age, boolean isFriendFromSchool, float hoursSpentTogetherLastWeek) {
            this.name = name;
            this.age = age;
            this.isFriendFromSchool = isFriendFromSchool;
            this.hoursSpentTogetherLastWeek = hoursSpentTogetherLastWeek;
        }

        @Override
        public String toString() {
            return "Friend" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", myFreind=" + isFriendFromSchool +
                    ", hours=" + hoursSpentTogetherLastWeek;
        }
    }
}
