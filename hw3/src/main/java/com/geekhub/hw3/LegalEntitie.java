package com.geekhub.hw3;

public class LegalEntitie extends Customer {

    private long mfoCode;
    private long edrpouCode;

    LegalEntitie(String name, long taxId, long mfoCode, long edrpouCode) {
        super(name, taxId);
        this.mfoCode = mfoCode;
        this.edrpouCode = edrpouCode;
    }

    @Override
    public String toString() {
        return super.toString() + " MFO Code:" + mfoCode + " EDRPOU Code:" + edrpouCode;
    }
}
