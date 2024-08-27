package com.example.databaseSync.entity.remote;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@Table(name ="fact_company")
@AllArgsConstructor
@NoArgsConstructor
public class EntityA implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CustNo")
    private int Custno;

    @Column(name = "CompanyName")
    private String companyname;

    @Column(name = "RegistrationNumber")
    private String registrationnumber;

    @Column(name = "dateOfIncorporation")
    private String dateofincorporation;

    @Column(name = "KYC")
    private int kyc;

    @Column(name = "BranchCode")
    private int branchcode;

    @Column(name = "PRIM_OFCR_IND")
    private String primOfcrInd;

    @Column(name = "ConnectionSince")
    private String connectionsince;

    @Column(name = "SICCode")
    private String siccode;

    @Column(name = "RiskCategory")
    private int riskcategory;

    @Column(name = "PrimaryContact")
    private String primarycontact;

    @Column(name = "CUST_FULL_NAME_2")
    private String custFullName_2;

    @Column(name = "CUST_DOB")
    private String custDob;

    @Column(name = "ID_NO")
    private String ID_NO;//IDNumber;

    @Column(name = "ID_TYPE")
    private String ID_TYPE;//IDType;

    @Column(name = "EMPLOYER_NAME")
    private String employerName;

    @Column(name = "CUST_OCPTN_CDE")
    private String custOcptnCde;

    @Column(name = "EmailAddress")
    private String emailaddress;

    @Column(name = "MobilePhone")
    private String mobilephone;

    @Column(name = "MRTL_STAT_CDE")
    private String mrtlStatCde;

    @Column(name = "PostalAddress")
    private String postaladdress;

    @Column(name = "PhysicalAddress")
    private String physicaladdress;
}
