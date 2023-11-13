package com.app.daeja.Activity.Domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParkingInfo {
    @SerializedName("PARKING_CODE")
    @Expose
    Integer PARKING_CODE;
    @SerializedName("PARKING_NAME")
    @Expose
    String PARKING_NAME;
    @SerializedName("PARKING_ADDR")
    @Expose
    String PARKING_ADDR;
    @SerializedName("PARKING_TYPE_NM")
    @Expose
    String 주차장_종류명; //노외(NW) or 노상(NS)
    @SerializedName("OPERATION_RULE_NM")
    @Expose
    String 운영제구분명; //시간제 주차장 or 버스전용 주차장 or 시간제+버스전용 주차장
    @SerializedName("TEL")
    @Expose
    String 전화번호;
    @SerializedName("QUE_STATUS")
    @Expose
    boolean 주차현황_정보_제공여부; //제공 true, 미제공 false
    @SerializedName("CAPACITY")
    @Expose
    Integer 총_주차면;
    @SerializedName("CUR_PARKING")
    @Expose
    Integer 현재_주차_차량수;
    @SerializedName("CUR_PARKING_TIME")
    @Expose
    String 현재_주차_차량수_업데이트시간;
    @SerializedName("PAY_NM")
    @Expose
    String 유무료구분명;
    @SerializedName("NIGHT_FREE_OPEN_NM")
    @Expose
    String 야간무료개방여부명;
    @SerializedName("WEEKDAY_BEGIN_TIME")
    @Expose
    String 평일_운영_시작시각; //HH:MM
    @SerializedName("WEEKDAY_END_TIME")
    @Expose
    String 평일_운영_종료시각; //HH:MM
    @SerializedName("WEEKEND_BEGIN_TIME")
    @Expose
    String 주말_운영_시작시각; //HH:MM
    @SerializedName("WEEKEND_END_TIME")
    @Expose
    String 주말_운영_종료시각; //HH:MM
    @SerializedName("HOLIDAY_BEGIN_TIME")
    @Expose
    String 공휴일_운영_시작시각; //HH:MM
    @SerializedName("HOLIDAY_END_TIME")
    @Expose
    String 공휴일_운영_종료시각; //HH:MM
    @SerializedName("SATURDAY_PAY_NM")
    @Expose
    String 토요일_유무료_구분명;
    @SerializedName("HOLIDAY_PAY_NM")
    @Expose
    String 공휴일_유무료_구분명;
    @SerializedName("FULLTIME_MONTHLY")
    @Expose
    Integer 월_정기권_금액;
    @SerializedName("RATES")
    @Expose
    Integer 기본_주차_요금;
    @SerializedName("TIME_RATE")
    @Expose
    Integer 기본_주차_시간_분_단위;
    @SerializedName("ADD_RATES")
    @Expose
    Integer 추가_단위_요금;
    @SerializedName("ADD_TIME_RATE")
    @Expose
    String 추가_단위_시간_분_단위;
    @SerializedName("DAY_MAXIMUM")
    @Expose
    Integer 일_최대_요금;
    @SerializedName("LAT")
    @Expose
    Double LAT;
    @SerializedName("LNG")
    @Expose
    Double LNG;
    @SerializedName("SH_CO")
    @Expose
    String 공유_주차장_관리업체명;
    @SerializedName("SH_LINK")
    @Expose
    String 공유_주차장_관리업체_링크;
    @SerializedName("SH_TYPE")
    @Expose
    boolean 공유_주차장_여부; // (true:공유주차장 false:공유주차장 아님)
    @SerializedName("PARKING_TYPE_NM")
    @Expose
    String 주차혼잡도; // "많음", "보통", "적음"

    public ParkingInfo() {
    }

    public ParkingInfo(Integer PARKING_CODE, String PARKING_NAME, String PARKING_ADDR, String 주차장_종류명, String 운영제구분명, String 전화번호, boolean 주차현황_정보_제공여부, Integer 총_주차면, Integer 현재_주차_차량수, String 현재_주차_차량수_업데이트시간, String 유무료구분명, String 야간무료개방여부명, String 평일_운영_시작시각, String 평일_운영_종료시각, String 주말_운영_시작시각, String 주말_운영_종료시각, String 공휴일_운영_시작시각, String 공휴일_운영_종료시각, String 토요일_유무료_구분명, String 공휴일_유무료_구분명, Integer 월_정기권_금액, Integer 기본_주차_요금, Integer 기본_주차_시간_분_단위, Integer 추가_단위_요금, String 추가_단위_시간_분_단위, Integer 일_최대_요금, Double LAT, Double LNG, String 공유_주차장_관리업체명, String 공유_주차장_관리업체_링크, boolean 공유_주차장_여부, String 주차혼잡도) {
        this.PARKING_CODE = PARKING_CODE;
        this.PARKING_NAME = PARKING_NAME;
        this.PARKING_ADDR = PARKING_ADDR;
        this.주차장_종류명 = 주차장_종류명;
        this.운영제구분명 = 운영제구분명;
        this.전화번호 = 전화번호;
        this.주차현황_정보_제공여부 = 주차현황_정보_제공여부;
        this.총_주차면 = 총_주차면;
        this.현재_주차_차량수 = 현재_주차_차량수;
        this.현재_주차_차량수_업데이트시간 = 현재_주차_차량수_업데이트시간;
        this.유무료구분명 = 유무료구분명;
        this.야간무료개방여부명 = 야간무료개방여부명;
        this.평일_운영_시작시각 = 평일_운영_시작시각;
        this.평일_운영_종료시각 = 평일_운영_종료시각;
        this.주말_운영_시작시각 = 주말_운영_시작시각;
        this.주말_운영_종료시각 = 주말_운영_종료시각;
        this.공휴일_운영_시작시각 = 공휴일_운영_시작시각;
        this.공휴일_운영_종료시각 = 공휴일_운영_종료시각;
        this.토요일_유무료_구분명 = 토요일_유무료_구분명;
        this.공휴일_유무료_구분명 = 공휴일_유무료_구분명;
        this.월_정기권_금액 = 월_정기권_금액;
        this.기본_주차_요금 = 기본_주차_요금;
        this.기본_주차_시간_분_단위 = 기본_주차_시간_분_단위;
        this.추가_단위_요금 = 추가_단위_요금;
        this.추가_단위_시간_분_단위 = 추가_단위_시간_분_단위;
        this.일_최대_요금 = 일_최대_요금;
        this.LAT = LAT;
        this.LNG = LNG;
        this.공유_주차장_관리업체명 = 공유_주차장_관리업체명;
        this.공유_주차장_관리업체_링크 = 공유_주차장_관리업체_링크;
        this.공유_주차장_여부 = 공유_주차장_여부;
        this.주차혼잡도 = 주차혼잡도;
    }

    public Integer getPARKING_CODE() {
        return PARKING_CODE;
    }

    public void setPARKING_CODE(Integer PARKING_CODE) {
        this.PARKING_CODE = PARKING_CODE;
    }

    public String getPARKING_NAME() {
        return PARKING_NAME;
    }

    public void setPARKING_NAME(String PARKING_NAME) {
        this.PARKING_NAME = PARKING_NAME;
    }

    public String getPARKING_ADDR() {
        return PARKING_ADDR;
    }

    public void setPARKING_ADDR(String PARKING_ADDR) {
        this.PARKING_ADDR = PARKING_ADDR;
    }

    public String get주차장_종류명() {
        return 주차장_종류명;
    }

    public void set주차장_종류명(String 주차장_종류명) {
        this.주차장_종류명 = 주차장_종류명;
    }

    public String get운영제구분명() {
        return 운영제구분명;
    }

    public void set운영제구분명(String 운영제구분명) {
        this.운영제구분명 = 운영제구분명;
    }

    public String get전화번호() {
        return 전화번호;
    }

    public void set전화번호(String 전화번호) {
        this.전화번호 = 전화번호;
    }

    public boolean is주차현황_정보_제공여부() {
        return 주차현황_정보_제공여부;
    }

    public void set주차현황_정보_제공여부(boolean 주차현황_정보_제공여부) {
        this.주차현황_정보_제공여부 = 주차현황_정보_제공여부;
    }

    public Integer get총_주차면() {
        return 총_주차면;
    }

    public void set총_주차면(Integer 총_주차면) {
        this.총_주차면 = 총_주차면;
    }

    public Integer get현재_주차_차량수() {
        return 현재_주차_차량수;
    }

    public void set현재_주차_차량수(Integer 현재_주차_차량수) {
        this.현재_주차_차량수 = 현재_주차_차량수;
    }

    public String get현재_주차_차량수_업데이트시간() {
        return 현재_주차_차량수_업데이트시간;
    }

    public void set현재_주차_차량수_업데이트시간(String 현재_주차_차량수_업데이트시간) {
        this.현재_주차_차량수_업데이트시간 = 현재_주차_차량수_업데이트시간;
    }

    public String get유무료구분명() {
        return 유무료구분명;
    }

    public void set유무료구분명(String 유무료구분명) {
        this.유무료구분명 = 유무료구분명;
    }

    public String get야간무료개방여부명() {
        return 야간무료개방여부명;
    }

    public void set야간무료개방여부명(String 야간무료개방여부명) {
        this.야간무료개방여부명 = 야간무료개방여부명;
    }

    public String get평일_운영_시작시각() {
        return 평일_운영_시작시각;
    }

    public void set평일_운영_시작시각(String 평일_운영_시작시각) {
        this.평일_운영_시작시각 = 평일_운영_시작시각;
    }

    public String get평일_운영_종료시각() {
        return 평일_운영_종료시각;
    }

    public void set평일_운영_종료시각(String 평일_운영_종료시각) {
        this.평일_운영_종료시각 = 평일_운영_종료시각;
    }

    public String get주말_운영_시작시각() {
        return 주말_운영_시작시각;
    }

    public void set주말_운영_시작시각(String 주말_운영_시작시각) {
        this.주말_운영_시작시각 = 주말_운영_시작시각;
    }

    public String get주말_운영_종료시각() {
        return 주말_운영_종료시각;
    }

    public void set주말_운영_종료시각(String 주말_운영_종료시각) {
        this.주말_운영_종료시각 = 주말_운영_종료시각;
    }

    public String get공휴일_운영_시작시각() {
        return 공휴일_운영_시작시각;
    }

    public void set공휴일_운영_시작시각(String 공휴일_운영_시작시각) {
        this.공휴일_운영_시작시각 = 공휴일_운영_시작시각;
    }

    public String get공휴일_운영_종료시각() {
        return 공휴일_운영_종료시각;
    }

    public void set공휴일_운영_종료시각(String 공휴일_운영_종료시각) {
        this.공휴일_운영_종료시각 = 공휴일_운영_종료시각;
    }

    public String get토요일_유무료_구분명() {
        return 토요일_유무료_구분명;
    }

    public void set토요일_유무료_구분명(String 토요일_유무료_구분명) {
        this.토요일_유무료_구분명 = 토요일_유무료_구분명;
    }

    public String get공휴일_유무료_구분명() {
        return 공휴일_유무료_구분명;
    }

    public void set공휴일_유무료_구분명(String 공휴일_유무료_구분명) {
        this.공휴일_유무료_구분명 = 공휴일_유무료_구분명;
    }

    public Integer get월_정기권_금액() {
        return 월_정기권_금액;
    }

    public void set월_정기권_금액(Integer 월_정기권_금액) {
        this.월_정기권_금액 = 월_정기권_금액;
    }

    public Integer get기본_주차_요금() {
        return 기본_주차_요금;
    }

    public void set기본_주차_요금(Integer 기본_주차_요금) {
        this.기본_주차_요금 = 기본_주차_요금;
    }

    public Integer get기본_주차_시간_분_단위() {
        return 기본_주차_시간_분_단위;
    }

    public void set기본_주차_시간_분_단위(Integer 기본_주차_시간_분_단위) {
        this.기본_주차_시간_분_단위 = 기본_주차_시간_분_단위;
    }

    public Integer get추가_단위_요금() {
        return 추가_단위_요금;
    }

    public void set추가_단위_요금(Integer 추가_단위_요금) {
        this.추가_단위_요금 = 추가_단위_요금;
    }

    public String get추가_단위_시간_분_단위() {
        return 추가_단위_시간_분_단위;
    }

    public void set추가_단위_시간_분_단위(String 추가_단위_시간_분_단위) {
        this.추가_단위_시간_분_단위 = 추가_단위_시간_분_단위;
    }

    public Integer get일_최대_요금() {
        return 일_최대_요금;
    }

    public void set일_최대_요금(Integer 일_최대_요금) {
        this.일_최대_요금 = 일_최대_요금;
    }

    public Double getLAT() {
        return LAT;
    }

    public void setLAT(Double LAT) {
        this.LAT = LAT;
    }

    public Double getLNG() {
        return LNG;
    }

    public void setLNG(Double LNG) {
        this.LNG = LNG;
    }

    public String get공유_주차장_관리업체명() {
        return 공유_주차장_관리업체명;
    }

    public void set공유_주차장_관리업체명(String 공유_주차장_관리업체명) {
        this.공유_주차장_관리업체명 = 공유_주차장_관리업체명;
    }

    public String get공유_주차장_관리업체_링크() {
        return 공유_주차장_관리업체_링크;
    }

    public void set공유_주차장_관리업체_링크(String 공유_주차장_관리업체_링크) {
        this.공유_주차장_관리업체_링크 = 공유_주차장_관리업체_링크;
    }

    public boolean is공유_주차장_여부() {
        return 공유_주차장_여부;
    }

    public void set공유_주차장_여부(boolean 공유_주차장_여부) {
        this.공유_주차장_여부 = 공유_주차장_여부;
    }

    public String get주차혼잡도() {
        return 주차혼잡도;
    }

    public void set주차혼잡도(String 주차혼잡도) {
        this.주차혼잡도 = 주차혼잡도;
    }
}
