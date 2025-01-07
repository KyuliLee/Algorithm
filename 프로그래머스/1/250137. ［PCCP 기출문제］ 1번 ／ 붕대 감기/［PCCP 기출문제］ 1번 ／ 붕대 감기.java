class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // bandage : 시전 시간t, 초당 회복량x, 추가 회복량y
        // bandage 도중 공격 당하면 성공 시간 0, 곧바로 bandage 다시 시전
        // 공격 받아서 현재 체력 0 이하가 되면 -1 리턴 또는 남은 체력 리턴 
        int time = 0;
        int lastTime = attacks[attacks.length-1][0];
        int t = bandage[0]; int x = bandage[1]; int y = bandage[2];
        int idx = 0;
        int success = 0;
        int maxPh = health;
        while(health > 0 && time < lastTime) {
            // System.out.println("time: " + time + ", health: " + health);
            time++;
            // 현재 time이 attacks[idx][0]과 같으면 success -> 0, health 감소, idx 1 증가
            // 현재 time이 attacks[idx][0]과 다르면 success 1 증가, health x만큼 증가
            // success가 t와 같으면 health x+y만큼 증가
            if(time==attacks[idx][0]) {
                success = 0;
                health -= attacks[idx][1];
                idx++;
            } else {
                success++;
                health += x;
                if(success==t) {
                    health += y;
                    success = 0;
                }
                if(health > maxPh) {
                    health = maxPh;
                }
            }
        }
        if(health > 0) { return health; }
        return -1;
    }
}