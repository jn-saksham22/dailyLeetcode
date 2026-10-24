class Solution {
    int findDayOfYear(String date,int cumMonthDays[]){
        int month = Integer.parseInt(date.substring(0,2));
        int days = Integer.parseInt(date.substring(3)); 

        return cumMonthDays[month-1] + days; 
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int months[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int cummlative[] = new int[13];
        cummlative[1] = months[0];

        for(int i=2;i<=12;i++)
         cummlative[i] = cummlative[i-1]+months[i-1];

        int arriveAliceDay = findDayOfYear(arriveAlice, cummlative);
        int leaveAliceDay  = findDayOfYear(leaveAlice, cummlative);
        int arriveBobDay   = findDayOfYear(arriveBob, cummlative);
        int leaveBobDay    = findDayOfYear(leaveBob, cummlative);


        int overLapDays = Math.min(leaveAliceDay, leaveBobDay)-Math.max(arriveAliceDay, arriveBobDay)+1;
        return overLapDays < 0 ? 0 : overLapDays;
    }
}