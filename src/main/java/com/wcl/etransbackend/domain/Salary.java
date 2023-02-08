package com.wcl.etransbackend.domain;

import java.io.Serializable;

/**
 * (Salary)实体类
 *
 * @author crush
 * @since 2023-02-08 14:58:09
 */
public class Salary implements Serializable {
    private static final long serialVersionUID = 638655607089047086L;
    /**
     * 基本工资
     */
    private Double baseSalary;
    /**
     * 加班工资
     */
    private Double workOvertimeSalary;
    /**
     * 工龄工资
     */
    private Double workingYearsSalary;
    /**
     * 考核奖
     */
    private Double assessmentAward;
    /**
     * 节油奖
     */
    private Double oilSavingAward;
    /**
     * 过节费
     */
    private Double festivalFee;
    /**
     * 年终奖
     */
    private Double yearEndBonus;
    /**
     * 养老保险
     */
    private Double endowmentInsurance;
    /**
     * 医疗保险
     */
    private Double medicalInsurance;
    /**
     * 失业保险
     */
    private Double unemploymentInsurance;
    /**
     * 工伤保险
     */
    private Double employmentInjuryInsurance;
    /**
     * 生育保险
     */
    private Double maternityInsurance;
    /**
     * 公积金
     */
    private Double accumulationFund;
    /**
     * 工资总额
     */
    private Double totalSalary;
    /**
     * 员工账号
     */
    private String staffAccount;


    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Double getWorkOvertimeSalary() {
        return workOvertimeSalary;
    }

    public void setWorkOvertimeSalary(Double workOvertimeSalary) {
        this.workOvertimeSalary = workOvertimeSalary;
    }

    public Double getWorkingYearsSalary() {
        return workingYearsSalary;
    }

    public void setWorkingYearsSalary(Double workingYearsSalary) {
        this.workingYearsSalary = workingYearsSalary;
    }

    public Double getAssessmentAward() {
        return assessmentAward;
    }

    public void setAssessmentAward(Double assessmentAward) {
        this.assessmentAward = assessmentAward;
    }

    public Double getOilSavingAward() {
        return oilSavingAward;
    }

    public void setOilSavingAward(Double oilSavingAward) {
        this.oilSavingAward = oilSavingAward;
    }

    public Double getFestivalFee() {
        return festivalFee;
    }

    public void setFestivalFee(Double festivalFee) {
        this.festivalFee = festivalFee;
    }

    public Double getYearEndBonus() {
        return yearEndBonus;
    }

    public void setYearEndBonus(Double yearEndBonus) {
        this.yearEndBonus = yearEndBonus;
    }

    public Double getEndowmentInsurance() {
        return endowmentInsurance;
    }

    public void setEndowmentInsurance(Double endowmentInsurance) {
        this.endowmentInsurance = endowmentInsurance;
    }

    public Double getMedicalInsurance() {
        return medicalInsurance;
    }

    public void setMedicalInsurance(Double medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }

    public Double getUnemploymentInsurance() {
        return unemploymentInsurance;
    }

    public void setUnemploymentInsurance(Double unemploymentInsurance) {
        this.unemploymentInsurance = unemploymentInsurance;
    }

    public Double getEmploymentInjuryInsurance() {
        return employmentInjuryInsurance;
    }

    public void setEmploymentInjuryInsurance(Double employmentInjuryInsurance) {
        this.employmentInjuryInsurance = employmentInjuryInsurance;
    }

    public Double getMaternityInsurance() {
        return maternityInsurance;
    }

    public void setMaternityInsurance(Double maternityInsurance) {
        this.maternityInsurance = maternityInsurance;
    }

    public Double getAccumulationFund() {
        return accumulationFund;
    }

    public void setAccumulationFund(Double accumulationFund) {
        this.accumulationFund = accumulationFund;
    }

    public Double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(Double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public String getStaffAccount() {
        return staffAccount;
    }

    public void setStaffAccount(String staffAccount) {
        this.staffAccount = staffAccount;
    }

}


