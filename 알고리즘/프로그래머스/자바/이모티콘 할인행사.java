import java.util.*;
class Solution {
    
    static int maxUsers = 0;    // 최대 서비스 가입자
    static int maxSales = 0;     //  최대 판매액
    static int[] discount = {10,20,30,40};   //  최소 ~ 최대 할인율
    static int n;
    static int[][] userList;    //  사용자 정보
    static int[] emoticonList;  //  이모티콘 정가
    
    //  중복 순열 : 각 이모티콘의 할인율
    public void perm(int[] emoticonDiscount, int k){
        if(k == n){
            int users = 0;
            int sales = 0;
            for(int i = 0; i < userList.length; i++){
                int totalSale = 0;  //  사용자가 구매한 이모티콘 총 합
                for(int j = 0; j < emoticonDiscount.length; j++){
                    if(userList[i][0] <= emoticonDiscount[j]){
                        totalSale += emoticonList[j] * (100 - emoticonDiscount[j]) * 0.01 ;
                    }
                }

                if(userList[i][1] <= totalSale)
                    users++;
                else
                    sales += totalSale;
            }
            
            //  최대 서비스 가입자, 판매액 갱신
            
            if(maxUsers < users){
                maxUsers = users;
                maxSales = sales;
            }
            else if(maxUsers == users){
                maxSales = Math.max(maxSales,sales);
            }
            
            return;
        }
        
        
        //  중복 순열
        for(int i = 0; i < discount.length; i++){
            emoticonDiscount[k] = discount[i];
            perm(emoticonDiscount, k + 1);
        }
        
    }
    
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        //  비율 기준 오름차순 정렬
        int[] emoticonDiscount = new int[emoticons.length];
        
        n = emoticons.length;
        userList = new int[users.length][2];
        userList = users;
        emoticonList = new int[emoticons.length];
        emoticonList = emoticons;
          
        perm(emoticonDiscount, 0);

        return new int[]{maxUsers, maxSales};
    }
}
