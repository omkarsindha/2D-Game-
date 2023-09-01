package util;


public class Constants {
    public static class Directions{
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }
    public static class PlayerConstants{
        public static final int IDLE = 0;
        public static final int IDLE_MIRROR = 7;
        public static final int RUNNING = 1;
        public static final int RUNNING_MIRROR = 8;
        public static final int ATTACK = 2;
        public static final int ATTACK_MIRROR = 9;

        public static final int HURT = 3;
        public static final int HURT_MIRROR = 10;

        public static final int DYING = 4;
        public static final int DYING_MIRROR = 11;
        public static final int JUMP = 5;
        public static final int JUMP_MIRROR = 12;
        public static final int FALL = 6;
        public static final int FALL_MIRROR = 13;
    }
}
