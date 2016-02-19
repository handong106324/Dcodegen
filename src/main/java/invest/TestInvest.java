package invest;

import org.junit.Test;

/**
 * Created by handong on 16/2/3.
 */
public class TestInvest {
    String content = "1 2016-03-01 340.65 239.51 101.14 0.00 - 待还款\n" +
            "2 2016-04-01 340.66 241.87 98.79 0.00 - 待还款\n" +
            "3 2016-05-01 340.65 244.24 96.41 0.00 - 待还款\n" +
            "4 2016-06-01 340.66 246.65 94.01 0.00 - 待还款\n" +
            "5 2016-07-01 340.65 249.07 91.58 0.00 - 待还款\n" +
            "6 2016-08-01 340.65 251.52 89.13 0.00 - 待还款\n" +
            "7 2016-09-01 340.65 253.99 86.66 0.00 - 待还款\n" +
            "8 2016-10-01 340.65 256.49 84.16 0.00 - 待还款\n" +
            "9 2016-11-01 340.65 259.01 81.64 0.00 - 待还款\n" +
            "10 2016-12-01 340.65 261.56 79.09 0.00 - 待还款\n" +
            "11 2017-01-01 340.65 264.13 76.52 0.00 - 待还款\n" +
            "12 2017-02-01 340.65 266.73 73.92 0.00 - 待还款\n" +
            "13 2017-03-01 340.65 269.35 71.30 0.00 - 待还款\n" +
            "14 2017-04-01 340.65 272.00 68.65 0.00 - 待还款\n" +
            "15 2017-05-01 340.65 274.68 65.97 0.00 - 待还款\n" +
            "16 2017-06-01 340.65 277.38 63.27 0.00 - 待还款\n" +
            "17 2017-07-01 340.65 280.10 60.55 0.00 - 待还款\n" +
            "18 2017-08-01 340.65 282.86 57.79 0.00 - 待还款\n" +
            "19 2017-09-01 340.65 285.64 55.01 0.00 - 待还款\n" +
            "20 2017-10-01 340.65 288.45 52.20 0.00 - 待还款\n" +
            "21 2017-11-01 340.65 291.29 49.36 0.00 - 待还款\n" +
            "22 2017-12-01 340.65 294.15 46.50 0.00 - 待还款\n" +
            "23 2018-01-01 340.65 297.04 43.61 0.00 - 待还款\n" +
            "24 2018-02-01 340.65 299.96 40.69 0.00 - 待还款\n" +
            "25 2018-03-01 340.65 302.91 37.74 0.00 - 待还款\n" +
            "26 2018-04-01 340.65 305.89 34.76 0.00 - 待还款\n" +
            "27 2018-05-01 340.65 308.90 31.75 0.00 - 待还款\n" +
            "28 2018-06-01 340.65 311.94 28.71 0.00 - 待还款\n" +
            "29 2018-07-01 340.66 315.01 25.65 0.00 - 待还款\n" +
            "30 2018-08-01 340.65 318.10 22.55 0.00 - 待还款\n" +
            "31 2018-09-01 340.65 321.23 19.42 0.00 - 待还款\n" +
            "32 2018-10-01 340.65 324.39 16.26 0.00 - 待还款\n" +
            "33 2018-11-01 340.65 327.58 13.07 0.00 - 待还款\n" +
            "34 2018-12-01 340.65 330.80 9.85 0.00 - 待还款\n" +
            "35 2019-01-01 340.65 334.05 6.60 0.00 - 待还款\n" +
            "36 2019-02-01 340.65 337.34 3.31 0.00 - 待还款";
    @Test
    public void printInvest(){
        String[] ins = content.split("\\n");
        double count = 0.0;
        double countlixi = 0.0;
        for(String in:ins) {
            String []infos = in.split(" ");
            InvestInfo investInfo = new InvestInfo(Integer.parseInt(infos[0]),Double.parseDouble(infos[3]),Double.parseDouble(infos[4]));
            count += investInfo.getFeilv();
            countlixi += investInfo.lixi;
            System.out.println(investInfo);
        }
        System.out.println(countlixi);
    }

    class InvestInfo{
        private int month;
        private double benjin;
        private double lixi;
        private double feilv;

        public InvestInfo(int month,  double benjin, double lixi) {
            this.month = month;
            this.benjin = benjin;
            this.lixi = lixi;
            count();
        }

        private void count() {
            feilv = (12.0/month)*lixi/benjin;
        }

        public double getFeilv() {
            return feilv;
        }

        public void setFeilv(double feilv) {
            this.feilv = feilv;
        }

        @Override
        public String toString() {
            return "InvestInfo{" +
                    "第" + month +
                    "个月, benjin=" + benjin +
                    ", lixi=" + lixi +
                    ", 利率：" + feilv +
                    ", 转手年化利率:"+(37-month)*lixi/benjin+"}";
        }
    }
}
