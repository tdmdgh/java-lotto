package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoController {
    public void start(){
        //구입 금액 입력
        int cost = costInput();

        //구매 가능 개수 계산
        int count = cost2count(cost);

        //주어진 개수의 로또 뭉치 생성
        LottoBundle lb = new LottoBundle(count);

        //생성된 로또 뭉치 출력
        System.out.println(lb);

        //당첨번호 입력
        Lotto win_lotto = lottoInput();

        //보너스 번호 입력
        int bonus_num = bonusInput(win_lotto);



        //로또 번호를 비교해서 통계결과를 출력해주는 클래스 생성
        LottoStatistic ls = new LottoStatistic(lb, bonus_num, win_lotto);
        //System.out.println(ls);
    }
    private int costInput(){
        System.out.println("구입금액을 입력해 주세요.");
        String cost_str = readLine();
        try{
            return Integer.parseInt(cost_str);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
    public int cost2count(int cost){
        int count = cost/1000;
        if(cost%1000!=0 || count<=0)
            throw new IllegalArgumentException();
        System.out.println(count + "개를 구매했습니다.");
        return count;
    }
    private Lotto lottoInput(){
        System.out.println("당첨번호를 입력해 주세요.");
        String lotto_str = readLine();
        String[] num_list = lotto_str.split(",");
        List<Integer> lottoNumber = new ArrayList<>();
        for(String num_str : num_list) {
            try {
                int num = Integer.parseInt(num_str);
                lottoNumber.add(num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return new Lotto(lottoNumber);
    }
    private int bonusInput(Lotto lotto){
        System.out.println("보너스번호를 입력해 주세요.");
        String bonus_str = readLine();
        try {
//            if(isString_in_1to9(bonus_str))
//                throw new IllegalArgumentException();
            int bonus_num = Integer.parseInt(bonus_str);
            if(bonus_num<1 && bonus_num>45)
                throw new IllegalArgumentException();
            if(isLottoDuplicate(bonus_num,lotto))
                throw new IllegalArgumentException();
            return bonus_num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
//    private boolean isString_in_1to9(String str) {
//        return str.matches("[1-9.]+");
//    }
    private boolean isLottoDuplicate(int num, Lotto lotto) {
        for(int lotto_num : lotto.getNumbers()){
            if(num == lotto_num)
                return true;
        }
        return false;
    }
}
