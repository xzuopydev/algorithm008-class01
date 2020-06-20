class Solution {
    public int myAtoi(String str) {
        char[] arr = str.toCharArray();
        int rev = 0, index, n = arr.length;
        int flag = 1;//1是正，-1为负
        for (index = 0; index < n; index++) {
            //跳过空格
            if (arr[index] == ' ') continue;
            //找到正负号，判断负号后是否有数字
            if (index <= n - 2 && arr[index] == '-' && Character.isDigit(arr[index + 1])) {
                flag = -1;
                index++;
                break;
            } else if (index <= n - 2 && arr[index] == '+' && Character.isDigit(arr[index + 1])) {
                index++;
                break;
            }
            //找到数字
            else if (Character.isDigit(arr[index])) break;
            //其他字符
            else return 0;
        }
        //循环终止条件：1.越界，2.不是数字
        while (index < n && Character.isDigit(arr[index])) {
            //获取当前位
            int pop = arr[index] - '0';
            //判断正负是否越界
            if (flag == 1 && (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)))
                return 2147483647;
            if (flag == -1 && (rev > -(Integer.MIN_VALUE / 10) || (rev == -(Integer.MIN_VALUE / 10) && pop > 8)))
                return -2147483648;
            //添加当前位
            rev = rev * 10 + pop;
            index++;
        }
        return rev * flag;
    }
}