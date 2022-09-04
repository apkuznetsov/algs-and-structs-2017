package kuznetsov;

// Игрок в футбол обладает одной числовой характеристикой – профессионализмом.
// Команда называется сплочённой, если профессионализм любого игрока не превосходит
// суммарный профессионализм любых двух других игроков из команды.
// Команда может состоять из любого количетсва игроков.
//
// Дана отсортированная последовательность чисел длиной N –
// профессионализм игроков.
//
// Необходимо найти максимальный суммарный профессионализм
// сплочённой команды.
public class BestTeamSum {

    public int bestTeamSum(int[] sortedNums) {
        int currSum = 0;
        int bestSum = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < sortedNums.length; i++) {
            left = i;
            while (right < sortedNums.length
                    && (right == left
                    || (sortedNums[left] + sortedNums[left + 1] >= sortedNums[right]))
            ) {
                currSum += sortedNums[right];
                right++;
            }

            bestSum = Math.max(currSum, bestSum);
            currSum -= sortedNums[left];
        }

        return bestSum;
    }
}
