package com.example.mamatva01.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="basic_info")
@Data

@Getter
@Setter
public class BasicInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Govt_Mother_id_No")
    private int motherId;

    @Column(name="PHC_Name")
    private String PHCName;

    @Column(name="Name")
    private String name;

    @Column(name="Age")
    private int age;

    @Column(name="contact")
    private int contact;

    @Column(name="Education")
    private String education;

    @Column(name="Occupation")
    private String occupation;

    @Column(name="partners_Name")
    private String partnersName;

    @Column(name="partners_education")
    private String  partnersEducation;

    @Column(name="Religion")
    private String Religion;

    @Column(name="city_town_village")
    private String cityTownVillage;

    @Column(name="district")
    private String district;

    @Column(name="state")
    private String state;

    @Column(name="country")
    private String country;

    @Column(name="Total_no_of_family_member")
    private int TotalNoOfFamilyMember;

    @Column(name="No_of_earning_members")
    private int NoOfEarningMembers;

}
